package hranj.marijan.diplomskirad.controller

import hranj.marijan.diplomskirad.dto.RezervacijaDto
import hranj.marijan.diplomskirad.model.Lokacija
import hranj.marijan.diplomskirad.model.Rezervacija
import hranj.marijan.diplomskirad.model.Smjestaj
import hranj.marijan.diplomskirad.services.KategorijaService
import hranj.marijan.diplomskirad.services.LokacijaService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import java.sql.Timestamp
import java.util.stream.Collectors
import javax.validation.Valid

@Controller
class PonudaController(private val kategorijaService: KategorijaService,
                       private val lokacijaService: LokacijaService) {

    @PostMapping("/pretrazi-ponudu")
    fun pretraziPonuduPost(@Valid rezervacijaDto: RezervacijaDto, bindingResult: BindingResult, model: Model): String {
        try {
            model["kategorije"] = kategorijaService.findAll()
            model["lokacije"] = lokacijaService.findAll()
            if (!bindingResult.hasErrors()) {
                model["lokacijePonuda"] = filtrirajLokacije(rezervacijaDto)
                return "redirect:/"
            }
        } catch (e: Exception) {
            model["greska"] = true
        }
        model["rezervacijaDto"] = rezervacijaDto
        return "pocetna"
    }

    private fun filtrirajLokacije(rezervacijaDto: RezervacijaDto) : List<Lokacija> {
        val lokacije = dohvatiLokacijePremaKategoriji(rezervacijaDto)
        for (lokacija: Lokacija in lokacije) {
            var postojiSlobodanTermin = true
            if (!lokacija.smjestaji.isNullOrEmpty()) {
                val rezervacije = dohvatiRezervacijeZaSmjestaje(lokacija.smjestaji!!, rezervacijaDto)
                if (!rezervacije.isNullOrEmpty()) {
                    postojiSlobodanTermin = rezervacije.stream()
                            .anyMatch { !vremenaSePoklapaju(rezervacijaDto, it.pocetak, it.kraj) }
                }
            } else {
                postojiSlobodanTermin = false
            }
            if (!postojiSlobodanTermin) {
                lokacije.remove(lokacija)
            }
        }
        return lokacije
    }

    private fun dohvatiRezervacijeZaSmjestaje(smjestaji: List<Smjestaj>, rezervacijaDto: RezervacijaDto): MutableList<Rezervacija>? {
        return smjestaji.stream()
                .filter { smjestaj -> smjestaj.maxOsoba >= rezervacijaDto.brojOsoba }
                .map { it.rezervacije }
                .flatMap { it?.stream() }
                .collect(Collectors.toList())
    }

    private fun dohvatiLokacijePremaKategoriji(rezervacijaDto: RezervacijaDto): MutableList<Lokacija> {
        var lokacije: MutableList<Lokacija> = mutableListOf()
        if (rezervacijaDto.lokacija > 0) {
            lokacijaService.findById(rezervacijaDto.lokacija)
                    .ifPresent { lokacije.add(it) }
        } else if (rezervacijaDto.kategorija > 0) {
            val kategorija = kategorijaService.findById(rezervacijaDto.kategorija)
            if (kategorija.isPresent) {
                lokacije = kategorija.get().lokacije?.toList()?.toMutableList() ?: lokacije
            }
        }
        return lokacije
    }

    private fun vremenaSePoklapaju(rezervacijaDto: RezervacijaDto, pocetak: Timestamp?, kraj: Timestamp?): Boolean {
        val pocetakLocalDate = pocetak?.toLocalDateTime()?.toLocalDate()
        val krajLocalDate = kraj?.toLocalDateTime()?.toLocalDate()
        if (pocetakLocalDate != null && krajLocalDate != null) {
            return (pocetakLocalDate.isBefore(rezervacijaDto.kraj) || pocetakLocalDate == rezervacijaDto.kraj)
                    && (krajLocalDate.isAfter(rezervacijaDto.pocetak) || krajLocalDate == rezervacijaDto.pocetak)
        }
        return true
    }

}
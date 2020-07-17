package hranj.marijan.diplomskirad.services.impl

import hranj.marijan.diplomskirad.dto.RezervacijaDto
import hranj.marijan.diplomskirad.model.Lokacija
import hranj.marijan.diplomskirad.model.Smjestaj
import hranj.marijan.diplomskirad.services.KategorijaService
import hranj.marijan.diplomskirad.services.LokacijaService
import hranj.marijan.diplomskirad.services.PretrazivanjePonudeService
import hranj.marijan.diplomskirad.utils.VremenaUtils
import org.springframework.stereotype.Service
import java.sql.Timestamp

@Service
class PretrazivanjePonudeServiceImpl(private val kategorijaService: KategorijaService,
                                     private val lokacijaService: LokacijaService) : PretrazivanjePonudeService {

    override fun pretraziLokacije(rezervacijaDto: RezervacijaDto) : List<Lokacija> {
        val slobodneLokacije = mutableListOf<Lokacija>()
        for (lokacija: Lokacija in dohvatiOdabraneIliLokacijePremaKategoriji(rezervacijaDto)) {
            var postojiSlobodanTermin = false
            if (!lokacija.smjestaji.isNullOrEmpty()) {
                for (smjestaj: Smjestaj in lokacija.smjestaji!!) {
                    if (smjestaj.maxOsoba >= rezervacijaDto.brojOsoba) {
                        val rezervacije = smjestaj.rezervacije
                        if (!rezervacije.isNullOrEmpty()) {
                            postojiSlobodanTermin = rezervacije.stream()
                                    .anyMatch { !vremenaSePoklapaju(rezervacijaDto, it.pocetak, it.kraj) }
                        } else {
                            postojiSlobodanTermin = true
                        }
                    }
                }
            }
            if (postojiSlobodanTermin) {
                slobodneLokacije.add(lokacija)
            }
        }
        return slobodneLokacije
    }

    private fun dohvatiOdabraneIliLokacijePremaKategoriji(rezervacijaDto: RezervacijaDto): List<Lokacija> {
        var lokacije: MutableList<Lokacija> = mutableListOf()
        if (rezervacijaDto.lokacija > 0) {
            lokacijaService.findById(rezervacijaDto.lokacija)
                    .ifPresent { lokacije.add(it) }
        } else if (rezervacijaDto.kategorija > 0) {
            val kategorija = kategorijaService.findById(rezervacijaDto.kategorija)
            if (kategorija.isPresent) {
                lokacije = kategorija.get().lokacije?.toList()?.toMutableList() ?: lokacije
            }
        } else if (rezervacijaDto.lokacija == 0) {
            lokacije = lokacijaService.findAll().toMutableList()
        }
        return lokacije
    }

    private fun vremenaSePoklapaju(rezervacijaDto: RezervacijaDto, pocetak: Timestamp?, kraj: Timestamp?): Boolean {
        val pocetakLocalDate = pocetak?.toLocalDateTime()?.toLocalDate()
        val krajLocalDate = kraj?.toLocalDateTime()?.toLocalDate()
        if (pocetakLocalDate != null && krajLocalDate != null) {
            return VremenaUtils.vremenaSePokalapaju(pocetakLocalDate, krajLocalDate,
                    rezervacijaDto.pocetak, rezervacijaDto.kraj)
        }
        return true
    }

}
package hranj.marijan.diplomskirad.controller

import hranj.marijan.diplomskirad.dto.RezervacijaDto
import hranj.marijan.diplomskirad.enums.NazivUloge
import hranj.marijan.diplomskirad.model.Rezervacija
import hranj.marijan.diplomskirad.services.KorisnikService
import hranj.marijan.diplomskirad.services.RezervacijaService
import hranj.marijan.diplomskirad.services.SmjestajService
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import javax.validation.Valid

@Controller
class RezervacijaController(private val rezervacijaService: RezervacijaService,
                            private val korisnikService: KorisnikService,
                            private val smjestajService: SmjestajService) {

    @PostMapping("/rezerviraj-smjestaj")
    fun rezervirajSmjestaj(@Valid rezervacijaDto: RezervacijaDto, model: Model,
                                bindingResult: BindingResult, authentication: Authentication?): String {
        try {
            if (!bindingResult.hasErrors()) {
                val korisnickoIme = authentication?.name ?: ""
                val korisnik = korisnikService.findByKorisnickoIme(korisnickoIme)
                val smjestaj = smjestajService.findById(rezervacijaDto.odabraniSmjestaj)
                if (smjestaj.isPresent && korisnik != null) {
                    val rezervacija = Rezervacija(rezervacijaDto, korisnik, smjestaj.get())
                    rezervacijaService.rezerviraj(rezervacija)
                } else {
                    model["greska"] = true
                }
                return "redirect:/moje-rezervacije"
            }
        } catch (e: Exception) {
            model["greska"] = true
        }
        dodajAtributeModelu(authentication, model)
        return "smjestaji"
    }

    @PostMapping("/otkazi-smjestaj")
    fun otkaziSmjestaj(@RequestParam odabranaRezervacija: Int, model: Model,
                                authentication: Authentication?, redirectAttributes: RedirectAttributes): String {
        try {
            rezervacijaService.otkazi(odabranaRezervacija)
        } catch (e: Exception) {
            redirectAttributes.addFlashAttribute("greska", true)
        }
        return "redirect:/moje-rezervacije"
    }

    private fun dodajAtributeModelu(authentication: Authentication?, model: Model) {
        val korisnikJeAdmin: Boolean = authentication?.authorities
                ?.stream()
                ?.anyMatch { authority -> authority.authority == NazivUloge.ADMIN.toString() } ?: false
        model["korisnickoIme"] = authentication?.name?.toUpperCase() ?: ""
        model["adminKorisnik"] = korisnikJeAdmin
    }

}
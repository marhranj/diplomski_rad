package hranj.marijan.diplomskirad.controller

import hranj.marijan.diplomskirad.dto.RezervacijaDto
import hranj.marijan.diplomskirad.enums.NazivUloge
import hranj.marijan.diplomskirad.services.KategorijaService
import hranj.marijan.diplomskirad.services.LokacijaService
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid

@Controller
class PocetnaController(private val kategorijaService: KategorijaService,
                        private val lokacijaService: LokacijaService) {

    @GetMapping("/")
    fun pocetna(model: Model, authentication: Authentication?): String {
        dodajAtributeModelu(authentication, model)
        return "pocetna"
    }

    @PostMapping("/pretrazi-ponudu")
    fun pretraziPonuduPost(@Valid rezervacijaDto: RezervacijaDto, bindingResult: BindingResult, model: Model): String {
        try {
            model["kategorije"] = kategorijaService.findAll()
            model["lokacije"] = lokacijaService.findAll()
            if (!bindingResult.hasErrors()) {
                return "redirect:/"
            }
        } catch (e: Exception) {
            model["greska"] = true
        }
        model["rezervacijaDto"] = rezervacijaDto
        return "pocetna"
    }

    private fun dodajAtributeModelu(authentication: Authentication?, model: Model) {
        val korisnikJeAdmin: Boolean = authentication?.authorities
                ?.stream()
                ?.anyMatch { authority -> authority.authority == NazivUloge.ADMIN.toString() } ?: false
        model["korisnickoIme"] = authentication?.name?.toUpperCase() ?: ""
        model["adminKorisnik"] = korisnikJeAdmin
        model["kategorije"] = kategorijaService.findAll()
        model["lokacije"] = lokacijaService.findAll()
        model["rezervacijaDto"] = RezervacijaDto()
        model["greska"] = false
    }

}
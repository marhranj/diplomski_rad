package hranj.marijan.diplomskirad.controller

import hranj.marijan.diplomskirad.enums.NazivUloge
import hranj.marijan.diplomskirad.model.Rezervacija
import hranj.marijan.diplomskirad.services.KorisnikService
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.thymeleaf.expression.Calendars

@Controller
class MojeRezervacijeController(private val korisnikService: KorisnikService) {

    @GetMapping("/moje-rezervacije")
    fun mojeRezervacije(model: Model, authentication: Authentication?): String {
        dodajAtributeModelu(authentication, model)
        val korisnickoIme = authentication?.name ?: ""
        val korisnik = korisnikService.findByKorisnickoIme(korisnickoIme)
        model["rezervacije"] = korisnik?.rezervacije as List<Rezervacija>
        return "moje_rezervacije"
    }

    private fun dodajAtributeModelu(authentication: Authentication?, model: Model) {
        val korisnikJeAdmin: Boolean = authentication?.authorities
                ?.stream()
                ?.anyMatch { authority -> authority.authority == NazivUloge.ADMIN.toString() } ?: false
        model["korisnickoIme"] = authentication?.name?.toUpperCase() ?: ""
        model["adminKorisnik"] = korisnikJeAdmin
        model["greska"] = false
    }

}
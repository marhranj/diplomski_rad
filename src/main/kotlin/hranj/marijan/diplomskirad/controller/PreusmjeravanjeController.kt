package hranj.marijan.diplomskirad.controller

import hranj.marijan.diplomskirad.enums.NazivUloge
import hranj.marijan.diplomskirad.services.KorisnikService
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PreusmjeravanjeController(private val korisnikService: KorisnikService) {

    @GetMapping("/")
    fun pocetna(model: Model, authentication: Authentication?): String {
        dodajKorisnickePodatke(authentication, model)
        return "pocetna"
    }

    @GetMapping("/prijava")
    fun prijava(): String {
        return "prijava"
    }

    private fun dodajKorisnickePodatke(authentication: Authentication?, model: Model) {
        val korisnikJeAdmin: Boolean = authentication?.authorities
                ?.stream()
                ?.anyMatch { authority -> authority.authority == NazivUloge.ADMIN.toString() } ?: false
        model["korisnickoIme"] = authentication?.name?.toUpperCase() ?: ""
        model["adminKorisnik"] = korisnikJeAdmin
    }

}
package hranj.marijan.diplomskirad.controller

import hranj.marijan.diplomskirad.dto.RezervacijaDto
import hranj.marijan.diplomskirad.enums.NazivUloge
import hranj.marijan.diplomskirad.services.KategorijaService
import hranj.marijan.diplomskirad.services.LokacijaService
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PocetnaController(private val kategorijaService: KategorijaService,
                        private val lokacijaService: LokacijaService) {

    @GetMapping("/")
    fun pocetna(model: Model, authentication: Authentication?): String {
        dodajAtributeModelu(authentication, model)
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
        if (model.getAttribute("rezervirano") == null) {
            model["rezervirano"] = false
        }
        model["greska"] = false
    }

}
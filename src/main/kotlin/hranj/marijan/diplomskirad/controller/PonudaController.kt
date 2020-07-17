package hranj.marijan.diplomskirad.controller

import hranj.marijan.diplomskirad.dto.RezervacijaDto
import hranj.marijan.diplomskirad.enums.NazivUloge
import hranj.marijan.diplomskirad.services.KategorijaService
import hranj.marijan.diplomskirad.services.LokacijaService
import hranj.marijan.diplomskirad.services.PretrazivanjePonudeService
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid

@Controller
class PonudaController(private val kategorijaService: KategorijaService,
                       private val lokacijaService: LokacijaService,
                       private val pretrazivanjePonudeService: PretrazivanjePonudeService) {

    @PostMapping("/pretrazi-ponudu")
    fun pretraziPonuduPost(@Valid rezervacijaDto: RezervacijaDto, bindingResult: BindingResult,
                           model: Model, authentication: Authentication?): String {
        try {
            model["rezervacijaDto"] = rezervacijaDto
            if (!bindingResult.hasErrors()) {
                model["lokacije"] = pretrazivanjePonudeService.pretraziLokacije(rezervacijaDto)
                dodajAtributeModelu(authentication, model)
                return "lokacije"
            }
            model["kategorije"] = kategorijaService.findAll()
            model["lokacije"] = lokacijaService.findAll()
        } catch (e: Exception) {
            model["greska"] = true
        }
        return "pocetna"
    }

    private fun dodajAtributeModelu(authentication: Authentication?, model: Model) {
        val korisnikJeAdmin: Boolean = authentication?.authorities
                ?.stream()
                ?.anyMatch { authority -> authority.authority == NazivUloge.ADMIN.toString() } ?: false
        model["korisnickoIme"] = authentication?.name?.toUpperCase() ?: ""
        model["adminKorisnik"] = korisnikJeAdmin
    }

}
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
import org.springframework.web.bind.annotation.GetMapping
import javax.validation.Valid

@Controller
class PonudaLokacijaController(private val kategorijaService: KategorijaService,
                               private val lokacijaService: LokacijaService,
                               private val pretrazivanjePonudeService: PretrazivanjePonudeService) {

    @GetMapping("/pretrazi-ponudu-lokacija")
    fun pretraziPonuduLokacija(@Valid rezervacijaDto: RezervacijaDto, bindingResult: BindingResult,
                               model: Model, authentication: Authentication?): String {
        try {
            dodajAtributeModelu(authentication, model)
            if (!bindingResult.hasErrors()) {
                model["lokacije"] = pretrazivanjePonudeService.pretraziSlobodneLokacije(rezervacijaDto)
                return "lokacije"
            }
            model["rezervacijaDto"] = rezervacijaDto
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
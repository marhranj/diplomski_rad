package hranj.marijan.diplomskirad.controller

import hranj.marijan.diplomskirad.dto.RezervacijaDto
import hranj.marijan.diplomskirad.enums.NazivUloge
import hranj.marijan.diplomskirad.services.PretrazivanjePonudeService
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import javax.validation.Valid

@Controller
class PonudaSmjestajaController(private val pretrazivanjePonudeService: PretrazivanjePonudeService) {

    @GetMapping("/pretrazi-ponudu-smjestaja")
    fun pretraziPonuduPost(@Valid rezervacijaDto: RezervacijaDto, model: Model, authentication: Authentication?): String {
        model["smjestaji"] = pretrazivanjePonudeService.pretraziSlobodneSmjestaje(rezervacijaDto)
        dodajAtributeModelu(authentication, model)
        return "smjestaji"
    }

    private fun dodajAtributeModelu(authentication: Authentication?, model: Model) {
        val korisnikJeAdmin: Boolean = authentication?.authorities
                ?.stream()
                ?.anyMatch { authority -> authority.authority == NazivUloge.ADMIN.toString() } ?: false
        model["korisnickoIme"] = authentication?.name?.toUpperCase() ?: ""
        model["adminKorisnik"] = korisnikJeAdmin
    }

}
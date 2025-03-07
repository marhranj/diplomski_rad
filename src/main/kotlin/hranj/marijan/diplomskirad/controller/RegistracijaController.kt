package hranj.marijan.diplomskirad.controller

import hranj.marijan.diplomskirad.dto.KorisnikDto
import hranj.marijan.diplomskirad.exceptions.KorisnikVecPostojiException
import hranj.marijan.diplomskirad.services.KorisnikService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import java.lang.Exception
import javax.validation.Valid

@Controller
class RegistracijaController(private val korisnikService: KorisnikService) {

    @GetMapping("/registracija")
    fun registracija(model: Model): String {
        model["korisnikDto"] = KorisnikDto()
        model["korisnikVecPostoji"] = false
        model["problemSaBazom"] = false
        return "registracija"
    }

    @PostMapping("/registracija")
    fun registracijaPost(@Valid korisnikDto: KorisnikDto, bindingResult: BindingResult, model: Model): String {
        if (bindingResult.hasErrors()) {
            model["korisnikDto"] = korisnikDto
            model["korisnikVecPostoji"] = false
            model["problemSaBazom"] = false
            return "registracija"
        }
        try {
            korisnikService.spremiKorisnika(korisnikDto)
        } catch (e: KorisnikVecPostojiException) {
            model["korisnikVecPostoji"] = true
            return "registracija"
        } catch (e: Exception) {
            model["problemSaBazom"] = true
            return "registracija"
        }
        return "redirect:/prijava"
    }

}
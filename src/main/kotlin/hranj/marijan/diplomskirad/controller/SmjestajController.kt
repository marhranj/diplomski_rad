package hranj.marijan.diplomskirad.controller

import hranj.marijan.diplomskirad.dto.SmjestajDto
import hranj.marijan.diplomskirad.services.LokacijaService
import hranj.marijan.diplomskirad.services.SmjestajService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid

@Controller
class SmjestajController(private val smjestajService: SmjestajService,
                         private val lokacijaService: LokacijaService) {

    @GetMapping("/admin/dodaj-smjestaj")
    fun dodavanjeSmjestaja(model: Model): String {
        model["smjestajDto"] = SmjestajDto()
        model["greska"] = false
        model["lokacije"] = lokacijaService.findAll()
        return "dodavanje_smjestaja"
    }

    @PostMapping("/admin/dodaj-smjestaj")
    fun dodavanjeSmjestajaPost(@Valid smjestajDto: SmjestajDto, bindingResult: BindingResult, model: Model): String {
        try {
            if (!bindingResult.hasErrors()) {
                smjestajService.spremiSmjestaj(smjestajDto)
                return "redirect:/"
            }
            model["lokacije"] = lokacijaService.findAll()
        } catch (e: Exception) {
            model["greska"] = true
        }
        model["smjestajDto"] = smjestajDto
        return "dodavanje_smjestaja"
    }

}
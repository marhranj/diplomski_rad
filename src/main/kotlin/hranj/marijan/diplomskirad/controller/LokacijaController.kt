package hranj.marijan.diplomskirad.controller

import hranj.marijan.diplomskirad.dto.LokacijaDto
import hranj.marijan.diplomskirad.services.KategorijaService
import hranj.marijan.diplomskirad.services.LokacijaService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid

@Controller
class LokacijaController(private val lokacijaService: LokacijaService,
                         private val kategorijaService: KategorijaService) {

    @GetMapping("/admin/dodaj-lokaciju")
    fun dodavanjeLokacije(model: Model): String {
        model["lokacijaDto"] = LokacijaDto()
        model["greska"] = false
        model["kategorije"] = kategorijaService.findAll()
        return "dodavanje_lokacije"
    }

    @PostMapping("/admin/dodaj-lokaciju")
    fun dodavanjeLokacijePost(@Valid lokacijaDto: LokacijaDto, bindingResult: BindingResult, model: Model): String {
        try {
            model["kategorije"] = kategorijaService.findAll()
            if (!bindingResult.hasErrors()) {
                lokacijaService.spremiLokaciju(lokacijaDto)
                return "redirect:/"
            }
        } catch (e: Exception) {
            model["greska"] = true
        }
        model["lokacijaDto"] = lokacijaDto
        return "dodavanje_lokacije"
    }

}
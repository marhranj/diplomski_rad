package hranj.marijan.diplomskirad.controller

import hranj.marijan.diplomskirad.dto.LokacijaDto
import hranj.marijan.diplomskirad.model.Lokacija
import hranj.marijan.diplomskirad.model.SlikaLokacije
import hranj.marijan.diplomskirad.services.KategorijaService
import hranj.marijan.diplomskirad.services.LokacijaService
import hranj.marijan.diplomskirad.services.UpravljanjeSlikomService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import java.util.stream.Collectors
import javax.validation.Valid

@Controller
class LokacijaController(private val lokacijaService: LokacijaService,
                         private val kategorijaService: KategorijaService,
                         private val upravljanjeSlikomService: UpravljanjeSlikomService) {

    @GetMapping("/admin/dodaj-lokaciju")
    fun dodavanjeLokacije(model: Model): String {
        model["lokacijaDto"] = LokacijaDto()
        model["problemSaBazom"] = false
        model["kategorije"] = kategorijaService.findAll()
        return "dodavanje_lokacije"
    }

    @PostMapping("/admin/dodaj-lokaciju")
    fun dodavanjeLokacijePost(@Valid lokacijaDto: LokacijaDto, bindingResult: BindingResult, model: Model): String {
        if (bindingResult.hasErrors()) {
            model["lokacijaDto"] = lokacijaDto
            model["kategorije"] = kategorijaService.findAll()
            return "dodavanje_lokacije"
        }
        val slikeLokacija = upravljanjeSlikomService.spremiSlike(lokacijaDto.slike).stream()
                .map { putanja -> SlikaLokacije(putanja) }
                .collect(Collectors.toList())
        val kategorije = kategorijaService.findAllByIdIn(lokacijaDto.kategorije!!)
        val lokacija = Lokacija(lokacijaDto, kategorije, slikeLokacija)
        return "redirect:/"
    }

}
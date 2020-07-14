package hranj.marijan.diplomskirad.controller

import hranj.marijan.diplomskirad.dto.RezervacijaDto
import hranj.marijan.diplomskirad.model.Lokacija
import hranj.marijan.diplomskirad.model.Smjestaj
import hranj.marijan.diplomskirad.services.KategorijaService
import hranj.marijan.diplomskirad.services.LokacijaService
import hranj.marijan.diplomskirad.services.PretrazivanjePonudeService
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
    fun pretraziPonuduPost(@Valid rezervacijaDto: RezervacijaDto, bindingResult: BindingResult, model: Model): String {
        try {
            model["kategorije"] = kategorijaService.findAll()
            model["lokacije"] = lokacijaService.findAll()
            if (!bindingResult.hasErrors()) {
                model["lokacijePonuda"] = pretrazivanjePonudeService.pretraziLokacije(rezervacijaDto)
                return "redirect:/"
            }
        } catch (e: Exception) {
            model["greska"] = true
        }
        model["rezervacijaDto"] = rezervacijaDto
        return "pocetna"
    }


}
package hranj.marijan.diplomskirad.controller

import hranj.marijan.diplomskirad.model.Korisnik
import hranj.marijan.diplomskirad.services.KorisnikService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController(private val korisnikService: KorisnikService) {

    @GetMapping("/news")
    fun blog(): String {
        val korisnici: List<Korisnik> = korisnikService.findAll();
        return "news"
    }

}
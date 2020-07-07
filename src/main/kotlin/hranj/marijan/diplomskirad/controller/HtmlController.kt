package hranj.marijan.diplomskirad.controller

import hranj.marijan.diplomskirad.model.Korisnik
import hranj.marijan.diplomskirad.services.KorisnikService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController(private val korisnikService: KorisnikService) {

    @GetMapping("/news")
    fun blog(): String {
        return "news"
    }

    @GetMapping("/offers")
    fun blog1(): String {
        return "offers"
    }

    @GetMapping("/elements")
    fun blog2(): String {
        return "elements"
    }

    @GetMapping("/about")
    fun blog3(): String {
        return "about"
    }

    @GetMapping("/contact")
    fun blog4(): String {
        return "contact"
    }

}
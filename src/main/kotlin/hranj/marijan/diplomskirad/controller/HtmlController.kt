package hranj.marijan.diplomskirad.controller

import hranj.marijan.diplomskirad.services.KorisnikService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import java.security.Principal

@Controller
class HtmlController(private val korisnikService: KorisnikService) {

    @GetMapping("/")
    fun start(model: Model, principal: Principal?): String {
        model["korisnickoIme"] = principal?.name?.toUpperCase() ?: ""
        return "index"
    }

    @GetMapping("/prijava")
    fun blog1(): String {
        return "login"
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
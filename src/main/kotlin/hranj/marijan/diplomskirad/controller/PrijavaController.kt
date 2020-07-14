package hranj.marijan.diplomskirad.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PrijavaController {

    @GetMapping("/prijava")
    fun prijava(): String {
        return "prijava"
    }

}
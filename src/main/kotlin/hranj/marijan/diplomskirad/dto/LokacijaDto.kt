package hranj.marijan.diplomskirad.dto

import org.springframework.web.multipart.MultipartFile
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

class LokacijaDto {

    @NotEmpty(message = "Morate ispuniti ovo polje")
    var naziv: String? = null

    @Size(min = 20, max = 1000, message = "Morate imati barem 20 znakova a najviše 1000")
    var opis: String? = null

    @NotEmpty(message = "Morate ispuniti ovo polje")
    var kategorije: List<Int>? = null

    @Size(min = 3, max = 6, message = "Možete dodate najmanje 3 slike a najviše 6")
    var slike: List<MultipartFile>? = null

}
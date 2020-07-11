package hranj.marijan.diplomskirad.dto

import org.springframework.web.multipart.MultipartFile
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

class LokacijaDto {

    @NotEmpty(message = "Morate ispuniti ovo polje")
    var naziv: String? = null

    @Size(min = 20, message = "Morate imati barem 20 znakova")
    var opis: String? = null

    @NotEmpty(message = "Morate ispuniti ovo polje")
    var kategorije: List<String>? = null

    @Size(min = 3, message = "Morate dodate najmanje 3 slike")
    var slike: List<MultipartFile>? = null

}
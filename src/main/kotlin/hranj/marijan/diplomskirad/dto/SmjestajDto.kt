package hranj.marijan.diplomskirad.dto

import org.springframework.web.multipart.MultipartFile
import java.math.BigDecimal
import javax.validation.constraints.*

class SmjestajDto {

    @NotEmpty(message = "Morate ispuniti ovo polje")
    var naziv: String? = null

    @PositiveOrZero(message = "Morate unijeti broj veći ili jednak 0")
    @NotNull
    var cijena: BigDecimal? = null

    @NotEmpty(message = "Morate ispuniti ovo polje")
    @Email(message = "Morate unijeti ispravnu email adresu")
    var email: String? = null

    @Max(value = 100, message = "Broj mora biti manji ili jednak 100")
    @Min(value = 1, message = "Broj mora biti veći ili jednak 1")
    var brojOsoba: Int = 0

    @Positive(message = "Morate odabrati lokaciju")
    var lokacija: Int = 0

    @Size(min = 3, message = "Morate dodate najmanje 3 slike")
    var slike: List<MultipartFile>? = null

}
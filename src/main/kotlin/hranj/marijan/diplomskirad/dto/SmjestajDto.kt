package hranj.marijan.diplomskirad.dto

import org.springframework.web.multipart.MultipartFile
import java.math.BigDecimal
import javax.validation.constraints.*

class SmjestajDto {

    @NotEmpty(message = "Morate ispuniti ovo polje")
    var naziv: String? = null

    @Size(min = 20, max = 1000, message = "Morate imati barem 20 znakova a najviše 1000")
    var opis: String? = null

    @PositiveOrZero(message = "Morate unijeti broj veći ili jednak 0")
    @NotNull
    var cijena: BigDecimal? = null

    @NotEmpty(message = "Morate ispuniti ovo polje")
    @Email(message = "Morate unijeti ispravnu email adresu")
    var email: String? = null

    @Max(value = 100, message = "Broj mora biti manji ili jednak 100")
    @Min(value = 1, message = "Broj mora biti veći ili jednak 1")
    var brojOsoba: Int = 1

    @Max(value = 5, message = "Broj mora biti manji ili jednak 5")
    @Min(value = 1, message = "Broj mora biti veći ili jednak 1")
    var brojZvjezdica: Int = 1

    @Positive(message = "Morate odabrati lokaciju")
    var lokacija: Int = 0

    @Size(min = 3, max = 6, message = "Možete dodate najmanje 3 slike a najviše 6")
    var slike: List<MultipartFile>? = null

}
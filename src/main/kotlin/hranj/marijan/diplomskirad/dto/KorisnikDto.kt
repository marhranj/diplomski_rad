package hranj.marijan.diplomskirad.dto

import hranj.marijan.diplomskirad.validators.JakaLozinka
import hranj.marijan.diplomskirad.validators.JednakeLozinke
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@JednakeLozinke
class KorisnikDto {

    @NotEmpty(message = "Morate ispuniti ovo polje")
    var ime: String? = null

    @NotEmpty(message = "Morate ispuniti ovo polje")
    var prezime: String? = null

    @NotEmpty(message = "Morate ispuniti ovo polje")
    @Email(message = "Morate unijeti ispravnu email adresu")
    var email: String? = null

    @Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s.0-9]*\$", message = "Morate unijeti ispravni telefonski broj")
    @Size(min = 9, message = "Minimalan broj znakova je 9")
    var telefon: String? = null

    @NotEmpty(message = "Morate ispuniti ovo polje")
    @Size(min = 3, message = "Korisničko ime mora sadržavati barem 3 znaka")
    var korisnickoIme: String? = null

    @NotEmpty(message = "Morate ispuniti ovo polje")
    @JakaLozinka("Lozinka mora sadržavati barem 6 znakova, barem jedan poseban znak te barem jedan broj")
    var lozinka: String? = null

    @NotEmpty(message = "Morate ispuniti ovo polje")
    var ponovljenaLozinka: String? = null

}
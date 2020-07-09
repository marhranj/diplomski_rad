package hranj.marijan.diplomskirad.dto

import hranj.marijan.diplomskirad.validators.JakaLozinka
import hranj.marijan.diplomskirad.validators.JednakeLozinke
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
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

    @NotEmpty(message = "Morate ispuniti ovo polje")
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
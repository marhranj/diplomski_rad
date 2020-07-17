package hranj.marijan.diplomskirad.dto

import hranj.marijan.diplomskirad.validators.KrajPoslijePocetka
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import javax.validation.constraints.*

@KrajPoslijePocetka(message = "Krajnji datum mora biti poslije početnog")
class RezervacijaDto {

    @PositiveOrZero
    var lokacija: Int = 0

    @PositiveOrZero
    var kategorija: Int = 0

    @Max(value = 100, message = "Broj mora biti manji ili jednak 100")
    @Min(value = 1, message = "Broj mora biti veći ili jednak 1")
    var brojOsoba: Int = 1

    @FutureOrPresent(message = "Morate odabrati budući datum")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    var pocetak: LocalDate = LocalDate.now()

    @FutureOrPresent(message = "Morate odabrati budući datum")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    var kraj: LocalDate = LocalDate.now().plusDays(1)

    var odabranaLokacija: Int = 0

    var odabraniSmjestaj: Int = 0

}
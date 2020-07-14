package hranj.marijan.diplomskirad.validators

import hranj.marijan.diplomskirad.dto.RezervacijaDto
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class KrajPoslijePocetkaValidator : ConstraintValidator<KrajPoslijePocetka, RezervacijaDto> {

    override fun initialize(constraintAnnotation: KrajPoslijePocetka) {

    }
    override fun isValid(rezervacijaDto: RezervacijaDto, constraintValidatorContext: ConstraintValidatorContext): Boolean {
        return rezervacijaDto.kraj?.isAfter(rezervacijaDto.pocetak) ?: false
    }

}
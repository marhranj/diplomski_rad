package hranj.marijan.diplomskirad.validators

import hranj.marijan.diplomskirad.dto.KorisnikDto
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class JednakeLozinkeValidator : ConstraintValidator<JednakeLozinke, KorisnikDto> {

    override fun initialize(constraintAnnotation: JednakeLozinke) {

    }
    override fun isValid(korisnik: KorisnikDto, constraintValidatorContext: ConstraintValidatorContext): Boolean {
        return korisnik.lozinka.equals(korisnik.ponovljenaLozinka)
    }

}
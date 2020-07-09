package hranj.marijan.diplomskirad.validators

import hranj.marijan.diplomskirad.dto.KorisnikDto
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class JednakeLozinkeValidator : ConstraintValidator<JednakeLozinke, Any> {

    override fun initialize(constraintAnnotation: JednakeLozinke) {

    }
    override fun isValid(o: Any, constraintValidatorContext: ConstraintValidatorContext): Boolean {
        val korisnikDto: KorisnikDto = o as KorisnikDto
        return korisnikDto.lozinka.equals(korisnikDto.ponovljenaLozinka)
    }

}
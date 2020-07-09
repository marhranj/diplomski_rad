package hranj.marijan.diplomskirad.validators

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class JakaLozinkaValidator : ConstraintValidator<JakaLozinka, String> {

    val lozinkaRegex: Regex = Regex("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$")

    override fun initialize(constraintAnnotation: JakaLozinka) {

    }
    override fun isValid(lozinka: String, constraintValidatorContext: ConstraintValidatorContext): Boolean {
        return lozinkaRegex.containsMatchIn(lozinka);
    }

}
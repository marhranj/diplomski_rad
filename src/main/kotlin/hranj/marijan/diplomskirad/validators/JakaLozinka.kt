package hranj.marijan.diplomskirad.validators

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [JakaLozinkaValidator::class])
annotation class JakaLozinka(val message: String = "", val groups: Array<KClass<*>> = [], val payload: Array<KClass<out Payload>> = [])
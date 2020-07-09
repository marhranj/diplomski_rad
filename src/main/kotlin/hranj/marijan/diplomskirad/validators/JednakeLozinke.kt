package hranj.marijan.diplomskirad.validators

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [JednakeLozinkeValidator::class])
annotation class JednakeLozinke(val message: String = "Lozinke moraju biti jednake", val groups: Array<KClass<*>> = [], val payload: Array<KClass<out Payload>> = [])
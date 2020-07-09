package hranj.marijan.diplomskirad.exceptions

import org.springframework.security.core.AuthenticationException

class KorisnikVecPostojiException : AuthenticationException {

    constructor(msg: String, t: Throwable) : super(msg, t)
    constructor(msg: String) : super(msg)

}
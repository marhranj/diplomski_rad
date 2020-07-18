package hranj.marijan.diplomskirad.services

interface EmailService {

    fun posaljiEmail(primatelj: String, subjekt: String, sadrzaj: String)

}
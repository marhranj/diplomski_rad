package hranj.marijan.diplomskirad.services

import hranj.marijan.diplomskirad.model.Korisnik

interface KorisnikService {

    fun findAll(): List<Korisnik>

}
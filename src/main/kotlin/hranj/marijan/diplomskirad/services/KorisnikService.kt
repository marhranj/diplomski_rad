package hranj.marijan.diplomskirad.services

import hranj.marijan.diplomskirad.dto.KorisnikDto
import hranj.marijan.diplomskirad.model.Korisnik

interface KorisnikService {

    fun findAll(): List<Korisnik>

    fun spremiKorisnika(korisnikDto: KorisnikDto)

}
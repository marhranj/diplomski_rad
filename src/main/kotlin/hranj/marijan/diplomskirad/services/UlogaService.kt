package hranj.marijan.diplomskirad.services

import hranj.marijan.diplomskirad.enums.NazivUloge
import hranj.marijan.diplomskirad.model.Uloga

interface UlogaService {

    fun findAll(): List<Uloga>

    fun findByNaziv(naziv : NazivUloge): Uloga

}
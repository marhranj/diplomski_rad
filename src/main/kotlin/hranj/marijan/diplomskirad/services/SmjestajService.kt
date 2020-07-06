package hranj.marijan.diplomskirad.services

import hranj.marijan.diplomskirad.model.Smjestaj

interface SmjestajService {

    fun findAll(): List<Smjestaj>

}
package hranj.marijan.diplomskirad.services

import hranj.marijan.diplomskirad.model.Lokacija

interface LokacijaService {

    fun findAll(): List<Lokacija>

}
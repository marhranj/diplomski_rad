package hranj.marijan.diplomskirad.services

import hranj.marijan.diplomskirad.model.Rezervacija

interface RezervacijaService {

    fun findAll(): List<Rezervacija>

}
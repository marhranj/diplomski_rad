package hranj.marijan.diplomskirad.services

import hranj.marijan.diplomskirad.dto.RezervacijaDto
import hranj.marijan.diplomskirad.model.Lokacija

interface PretrazivanjePonudeService {

    fun pretraziLokacije(rezervacijaDto: RezervacijaDto): List<Lokacija>

}
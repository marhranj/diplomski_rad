package hranj.marijan.diplomskirad.services

import hranj.marijan.diplomskirad.dto.RezervacijaDto
import hranj.marijan.diplomskirad.model.Lokacija
import hranj.marijan.diplomskirad.model.Smjestaj

interface PretrazivanjePonudeService {

    fun pretraziSlobodneLokacije(rezervacijaDto: RezervacijaDto): List<Lokacija>
    fun pretraziSlobodneSmjestaje(rezervacijaDto: RezervacijaDto): List<Smjestaj>

}
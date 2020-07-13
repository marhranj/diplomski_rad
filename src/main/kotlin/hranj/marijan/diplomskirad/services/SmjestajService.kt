package hranj.marijan.diplomskirad.services

import hranj.marijan.diplomskirad.dto.SmjestajDto
import hranj.marijan.diplomskirad.model.Smjestaj
import java.lang.Exception

interface SmjestajService {

    fun findAll(): List<Smjestaj>

    fun spremiSmjestaj(smjestajDto: SmjestajDto)

}
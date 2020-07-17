package hranj.marijan.diplomskirad.services

import hranj.marijan.diplomskirad.dto.SmjestajDto
import hranj.marijan.diplomskirad.model.Smjestaj
import java.lang.Exception
import java.util.*

interface SmjestajService {

    fun findAll(): List<Smjestaj>

    fun findById(id: Int): Optional<Smjestaj>

    fun spremiSmjestaj(smjestajDto: SmjestajDto)

}
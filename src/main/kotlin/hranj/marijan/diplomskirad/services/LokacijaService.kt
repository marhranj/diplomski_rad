package hranj.marijan.diplomskirad.services

import hranj.marijan.diplomskirad.dto.LokacijaDto
import hranj.marijan.diplomskirad.model.Lokacija
import java.util.*

interface LokacijaService {

    fun findAll(): List<Lokacija>

    fun spremiLokaciju(lokacijaDto: LokacijaDto)

    fun findById(id: Int): Optional<Lokacija>

}
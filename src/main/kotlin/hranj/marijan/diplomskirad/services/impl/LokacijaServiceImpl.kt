package hranj.marijan.diplomskirad.services.impl

import hranj.marijan.diplomskirad.model.Lokacija
import hranj.marijan.diplomskirad.repository.LokacijaRepository
import hranj.marijan.diplomskirad.services.LokacijaService
import org.springframework.stereotype.Service

@Service
class LokacijaServiceImpl(private val lokacijaRepository: LokacijaRepository) : LokacijaService {

    override fun findAll(): List<Lokacija> {
        return lokacijaRepository.findAll() as List<Lokacija>
    }

}
package hranj.marijan.diplomskirad.services.impl

import hranj.marijan.diplomskirad.model.Lokacija
import hranj.marijan.diplomskirad.repository.LokacijaRepository
import hranj.marijan.diplomskirad.services.LokacijaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LokacijaServiceImpl : LokacijaService {

    @Autowired
    var lokacijaRepository: LokacijaRepository? = null

    override fun findAll(): List<Lokacija> {
        return lokacijaRepository?.findAll() as List<Lokacija>
    }

}
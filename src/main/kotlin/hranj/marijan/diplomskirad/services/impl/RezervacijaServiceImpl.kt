package hranj.marijan.diplomskirad.services.impl

import hranj.marijan.diplomskirad.model.Rezervacija
import hranj.marijan.diplomskirad.repository.RezervacijaRepository
import hranj.marijan.diplomskirad.services.RezervacijaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RezervacijaServiceImpl : RezervacijaService {

    @Autowired
    var rezervacijaRepository: RezervacijaRepository? = null

    override fun findAll(): List<Rezervacija> {
        return rezervacijaRepository?.findAll() as List<Rezervacija>
    }

}
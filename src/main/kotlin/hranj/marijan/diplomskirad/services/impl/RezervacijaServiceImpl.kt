package hranj.marijan.diplomskirad.services.impl

import hranj.marijan.diplomskirad.model.Rezervacija
import hranj.marijan.diplomskirad.repository.RezervacijaRepository
import hranj.marijan.diplomskirad.services.RezervacijaService
import org.springframework.stereotype.Service

@Service
class RezervacijaServiceImpl(private val rezervacijaRepository: RezervacijaRepository) : RezervacijaService {

    override fun findAll(): List<Rezervacija> {
        return rezervacijaRepository.findAll()
    }

}
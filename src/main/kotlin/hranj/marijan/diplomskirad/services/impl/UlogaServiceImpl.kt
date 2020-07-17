package hranj.marijan.diplomskirad.services.impl

import hranj.marijan.diplomskirad.enums.NazivUloge
import hranj.marijan.diplomskirad.model.Uloga
import hranj.marijan.diplomskirad.repository.UlogaRepository
import hranj.marijan.diplomskirad.services.UlogaService
import org.springframework.stereotype.Service

@Service
class UlogaServiceImpl(private val ulogaRepository: UlogaRepository) : UlogaService {

    override fun findAll(): List<Uloga> {
        return ulogaRepository.findAll()
    }

    override fun findByNaziv(naziv: NazivUloge): Uloga {
        return ulogaRepository.findByNaziv(naziv)
    }

}
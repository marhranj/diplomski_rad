package hranj.marijan.diplomskirad.services.impl

import hranj.marijan.diplomskirad.model.Smjestaj
import hranj.marijan.diplomskirad.repository.SmjestajRepository
import hranj.marijan.diplomskirad.services.SmjestajService
import org.springframework.stereotype.Service

@Service
class SmjestajServiceImpl(private val smjestajRepository: SmjestajRepository) : SmjestajService {

    override fun findAll(): List<Smjestaj> {
        return smjestajRepository.findAll()
    }

}
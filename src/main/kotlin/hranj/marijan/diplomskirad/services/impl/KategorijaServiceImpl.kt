package hranj.marijan.diplomskirad.services.impl

import hranj.marijan.diplomskirad.model.Kategorija
import hranj.marijan.diplomskirad.repository.KategorijaRepository
import hranj.marijan.diplomskirad.services.KategorijaService
import org.springframework.stereotype.Service
import java.util.*

@Service
class KategorijaServiceImpl(private val kategorijaRepository: KategorijaRepository) : KategorijaService {

    override fun findAll(): List<Kategorija> {
        return kategorijaRepository.findAll()
    }

    override fun findAllByIdIn(id: List<Int>): Set<Kategorija> {
        return kategorijaRepository.findAllByIdIn(id)
    }

    override fun findById(id: Int): Optional<Kategorija> {
        return kategorijaRepository.findById(id)
    }

}
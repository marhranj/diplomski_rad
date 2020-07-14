package hranj.marijan.diplomskirad.services

import hranj.marijan.diplomskirad.model.Kategorija
import java.util.*

interface KategorijaService {

    fun findAll(): List<Kategorija>

    fun findAllByIdIn(id: List<Int>): Set<Kategorija>

    fun findById(id: Int): Optional<Kategorija>

}
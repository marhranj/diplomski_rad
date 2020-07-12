package hranj.marijan.diplomskirad.services

import hranj.marijan.diplomskirad.model.Kategorija

interface KategorijaService {

    fun findAll(): List<Kategorija>

    fun findAllByIdIn(id: List<Int>): Set<Kategorija>

}
package hranj.marijan.diplomskirad.repository

import hranj.marijan.diplomskirad.model.Kategorija
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KategorijaRepository : JpaRepository<Kategorija, Int> {

    fun findAllByIdIn(id: List<Int>): Set<Kategorija>

}
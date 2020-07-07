package hranj.marijan.diplomskirad.repository

import hranj.marijan.diplomskirad.model.Smjestaj
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SmjestajRepository : JpaRepository<Smjestaj, Long>
package hranj.marijan.diplomskirad.repository

import hranj.marijan.diplomskirad.model.Uloga
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UlogaRepository : JpaRepository<Uloga, Long>
package hranj.marijan.diplomskirad.repository

import hranj.marijan.diplomskirad.model.Lokacija
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LokacijaRepository : JpaRepository<Lokacija, Int>
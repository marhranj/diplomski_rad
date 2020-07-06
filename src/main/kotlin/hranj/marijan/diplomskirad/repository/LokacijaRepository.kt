package hranj.marijan.diplomskirad.repository

import hranj.marijan.diplomskirad.model.Lokacija
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LokacijaRepository : CrudRepository<Lokacija, Long>
package hranj.marijan.diplomskirad.repository

import hranj.marijan.diplomskirad.model.Smjestaj
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SmjestajRepository : CrudRepository<Smjestaj, Long>
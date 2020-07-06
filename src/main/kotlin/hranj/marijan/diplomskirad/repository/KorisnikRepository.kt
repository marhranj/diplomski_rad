package hranj.marijan.diplomskirad.repository

import hranj.marijan.diplomskirad.model.Korisnik
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface KorisnikRepository : CrudRepository<Korisnik, Long>
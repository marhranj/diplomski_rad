package hranj.marijan.diplomskirad.repository

import hranj.marijan.diplomskirad.model.Rezervacija
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RezervacijaRepository : JpaRepository<Rezervacija, Int>
package hranj.marijan.diplomskirad.repository

import hranj.marijan.diplomskirad.model.Korisnik
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KorisnikRepository : JpaRepository<Korisnik, Int> {

    fun findByKorisnickoImeOrEmail(korisnickoIme: String?, email: String?): Korisnik?

    fun findByKorisnickoIme(korisnickoIme: String?): Korisnik?

}
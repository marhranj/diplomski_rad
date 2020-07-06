package hranj.marijan.diplomskirad.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "korisnik", schema = "putovanja")
class Korisnik {

    @Column(name = "id", nullable = false)
    @Id
    var id = 0

    @Column(name = "ime", nullable = false, length = 45)
    @Basic
    var ime: String? = null

    @Column(name = "prezime", nullable = false, length = 45)
    @Basic
    var prezime: String? = null

    @Column(name = "email", nullable = false, length = 45)
    @Basic
    var email: String? = null

    @Column(name = "telefon", nullable = false, length = 45)
    @Basic
    var telefon: String? = null

    @OneToMany(mappedBy = "korisnikByFkKorisnik")
    var rezervacije: List<Rezervacija>? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val korisnik = o as Korisnik
        return id == korisnik.id &&
                ime == korisnik.ime &&
                prezime == korisnik.prezime &&
                email == korisnik.email &&
                telefon == korisnik.telefon
    }

    override fun hashCode(): Int {
        return Objects.hash(id, ime, prezime, email, telefon)
    }

}
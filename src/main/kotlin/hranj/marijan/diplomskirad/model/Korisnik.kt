package hranj.marijan.diplomskirad.model

import hranj.marijan.diplomskirad.dto.KorisnikDto
import java.util.*
import javax.persistence.*

@Entity
class Korisnik {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "korisnicko_ime", nullable = false, length = 45)
    @Basic
    var korisnickoIme: String? = null

    @Column(name = "lozinka", nullable = false, length = 100)
    @Basic
    var lozinka: String? = null

    @OneToMany(mappedBy = "korisnik", cascade = [CascadeType.ALL])
    var rezervacije: List<Rezervacija>? = null

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "korisnik_uloga",
            joinColumns = [JoinColumn(name = "fk_korisnik")],
            inverseJoinColumns = [JoinColumn(name = "fk_uloga")]
    )
    var uloge: Set<Uloga>? = null

    constructor(korisnikDto: KorisnikDto, uloge: Set<Uloga>, enkriptiranaLozinka: String) {
        this.ime = korisnikDto.ime
        this.prezime = korisnikDto.prezime
        this.email = korisnikDto.email
        this.telefon = korisnikDto.telefon
        this.korisnickoIme = korisnikDto.korisnickoIme
        this.lozinka = enkriptiranaLozinka
        this.uloge = uloge
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val korisnik = o as Korisnik
        return id == korisnik.id &&
                ime == korisnik.ime &&
                prezime == korisnik.prezime &&
                email == korisnik.email &&
                telefon == korisnik.telefon &&
                korisnickoIme == korisnik.korisnickoIme &&
                lozinka == korisnik.lozinka
    }

    override fun hashCode(): Int {
        return Objects.hash(id, ime, prezime, email, telefon, korisnickoIme, lozinka)
    }

}
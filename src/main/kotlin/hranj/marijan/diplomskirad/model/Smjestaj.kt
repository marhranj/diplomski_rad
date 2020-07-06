package hranj.marijan.diplomskirad.model

import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "smjestaj", schema = "putovanja")
class Smjestaj {

    @Column(name = "id", nullable = false)
    @Id
    var id = 0

    @Column(name = "naziv", nullable = false, length = 45)
    @Basic
    var naziv: String? = null

    @Column(name = "cijena", nullable = false, precision = 2)
    @Basic
    var cijena: BigDecimal? = null

    @Column(name = "email", nullable = false, length = 45)
    @Basic
    var email: String? = null

    @Column(name = "max_osoba", nullable = false)
    @Basic
    var maxOsoba = 0

    @OneToMany(mappedBy = "smjestaj")
    var rezervacije: List<Rezervacija>? = null

    @JoinColumn(name = "fk_lokacija", referencedColumnName = "id", nullable = false)
    @ManyToOne
    var lokacija: Lokacija? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val smjestaj = o as Smjestaj
        return id == smjestaj.id && maxOsoba == smjestaj.maxOsoba &&
                naziv == smjestaj.naziv &&
                cijena == smjestaj.cijena &&
                email == smjestaj.email
    }

    override fun hashCode(): Int {
        return Objects.hash(id, naziv, cijena, email, maxOsoba)
    }

}
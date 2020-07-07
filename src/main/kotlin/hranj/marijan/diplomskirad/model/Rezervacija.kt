package hranj.marijan.diplomskirad.model

import lombok.Getter
import lombok.Setter
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.*
import javax.persistence.*

@Entity
@Getter
@Setter
class Rezervacija {

    @Column(name = "id", nullable = false)
    @Id
    var id = 0

    @Column(name = "pocetak", nullable = false)
    @Basic
    var pocetak: Timestamp? = null

    @Column(name = "kraj", nullable = false)
    @Basic
    var kraj: Timestamp? = null

    @Column(name = "ukupna_cijena", nullable = false, precision = 2)
    @Basic
    var ukupnaCijena: BigDecimal? = null

    @Column(name = "broj_osoba", nullable = false)
    @Basic
    var brojOsoba = 0

    @JoinColumn(name = "fk_korisnik", referencedColumnName = "id", nullable = false)
    @ManyToOne
    var korisnik: Korisnik? = null

    @JoinColumn(name = "fk_smjestaj", referencedColumnName = "id", nullable = false)
    @ManyToOne
    var smjestaj: Smjestaj? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as Rezervacija
        return id == that.id && brojOsoba == that.brojOsoba &&
                pocetak == that.pocetak &&
                kraj == that.kraj &&
                ukupnaCijena == that.ukupnaCijena
    }

    override fun hashCode(): Int {
        return Objects.hash(id, pocetak, kraj, ukupnaCijena, brojOsoba)
    }

}
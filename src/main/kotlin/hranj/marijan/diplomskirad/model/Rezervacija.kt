package hranj.marijan.diplomskirad.model

import hranj.marijan.diplomskirad.dto.RezervacijaDto
import java.math.BigDecimal
import java.sql.Timestamp
import java.time.Duration
import java.time.format.DateTimeFormatter
import java.util.*
import javax.persistence.*
import kotlin.jvm.Transient

@Entity
class Rezervacija {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    constructor(rezervacijaDto: RezervacijaDto, korisnik: Korisnik?, smjestaj: Smjestaj?) {
        this.pocetak = Timestamp.valueOf(rezervacijaDto.pocetak.atStartOfDay())
        this.kraj = Timestamp.valueOf(rezervacijaDto.kraj.atStartOfDay())
        this.brojOsoba = rezervacijaDto.brojOsoba
        val brojDana = Duration.between(rezervacijaDto.pocetak.atStartOfDay(), rezervacijaDto.kraj.atStartOfDay()).toDays()
        this.ukupnaCijena = smjestaj?.cijena?.multiply(BigDecimal(brojOsoba * brojDana))
        this.korisnik = korisnik
        this.smjestaj = smjestaj
    }

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
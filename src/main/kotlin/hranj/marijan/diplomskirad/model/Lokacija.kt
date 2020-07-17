package hranj.marijan.diplomskirad.model

import hranj.marijan.diplomskirad.dto.LokacijaDto
import java.util.*
import javax.persistence.*

@Entity
class Lokacija {
    
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0

    @Column(name = "naziv", nullable = false, length = 45)
    @Basic
    var naziv: String? = null

    @Column(name = "opis", nullable = false, length = 1000)
    @Basic
    var opis: String? = null

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(name = "lokacija_kategorija",
            joinColumns = [JoinColumn(name = "fk_lokacija")],
            inverseJoinColumns = [JoinColumn(name = "fk_kategorija")]
    )
    var kategorije: Set<Kategorija>? = null

    @OneToMany(mappedBy = "lokacija", cascade = [CascadeType.ALL])
    var slikeLokacije: List<SlikaLokacije>? = null

    @OneToMany(mappedBy = "lokacija", cascade = [CascadeType.ALL])
    var smjestaji: List<Smjestaj>? = null

    constructor(lokacijaDto: LokacijaDto, kategorije: Set<Kategorija>) {
        this.naziv = lokacijaDto.naziv
        this.opis = lokacijaDto.opis
        this.kategorije = kategorije
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val lokacija = o as Lokacija
        return id == lokacija.id &&
                naziv == lokacija.naziv &&
                opis == lokacija.opis;
    }

    override fun hashCode(): Int {
        return Objects.hash(id, naziv, opis)
    }

}
package hranj.marijan.diplomskirad.model

import java.util.*
import javax.persistence.*

@Entity
class Lokacija {
    
    @Column(name = "id", nullable = false)
    @Id
    var id = 0

    @Column(name = "naziv", nullable = false, length = 45)
    @Basic
    var naziv: String? = null

    @Column(name = "opis", nullable = true, length = 500)
    @Basic
    var opis: String? = null

    @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable(name = "lokacija_kategorija",
            joinColumns = [JoinColumn(name = "fk_lokacija")],
            inverseJoinColumns = [JoinColumn(name = "fk_kategorija")]
    )
    var kategorije: Set<Kategorija>? = null

    @OneToMany(mappedBy = "lokacija")
    var slikeLokacije: List<SlikaLokacije>? = null

    @OneToMany(mappedBy = "lokacija")
    var smjestaji: List<Smjestaj>? = null

    @OneToMany(mappedBy = "lokacija")
    var znamenitosti: List<Znamenitost>? = null

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
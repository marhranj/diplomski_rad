package hranj.marijan.diplomskirad.model

import lombok.Getter
import lombok.Setter
import java.util.*
import javax.persistence.*

@Entity
@Getter
@Setter
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

    @Column(name = "kategorija", nullable = false, length = 45)
    @Basic
    var kategorija: String? = null

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
                opis == lokacija.opis &&
                kategorija == lokacija.kategorija
    }

    override fun hashCode(): Int {
        return Objects.hash(id, naziv, opis, kategorija)
    }

}
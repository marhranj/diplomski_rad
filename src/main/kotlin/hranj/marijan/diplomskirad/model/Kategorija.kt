package hranj.marijan.diplomskirad.model

import java.util.*
import javax.persistence.*

@Entity
class Kategorija {

    @Column(name = "id", nullable = false)
    @Id
    var id = 0

    @Column(name = "naziv", nullable = false, length = 70)
    @Basic
    var naziv: String? = null

    @ManyToMany(mappedBy = "kategorije")
    var lokacije: Set<Lokacija>? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as Kategorija
        return id == that.id &&
                naziv == that.naziv
    }

    override fun hashCode(): Int {
        return Objects.hash(id, naziv)
    }

}
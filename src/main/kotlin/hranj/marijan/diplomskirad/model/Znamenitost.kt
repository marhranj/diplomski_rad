package hranj.marijan.diplomskirad.model

import lombok.Getter
import lombok.Setter
import java.util.*
import javax.persistence.*

@Entity
@Getter
@Setter
class Znamenitost {

    @Column(name = "id", nullable = false)
    @Id
    var id = 0

    @Column(name = "naziv", nullable = false, length = 45)
    @Basic
    var naziv: String? = null

    @Column(name = "opis", nullable = true, length = 500)
    @Basic
    var opis: String? = null

    @Column(name = "putanja_slike", nullable = false, length = 200)
    @Basic
    var putanjaSlike: String? = null

    @JoinColumn(name = "fk_lokacija", referencedColumnName = "id", nullable = false)
    @ManyToOne
    var lokacija: Lokacija? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as Znamenitost
        return id == that.id &&
                naziv == that.naziv &&
                opis == that.opis &&
                putanjaSlike == that.putanjaSlike
    }

    override fun hashCode(): Int {
        return Objects.hash(id, naziv, opis, putanjaSlike)
    }

}
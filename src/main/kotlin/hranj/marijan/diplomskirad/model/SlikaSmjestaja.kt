package hranj.marijan.diplomskirad.model

import java.util.*
import javax.persistence.*

@Entity
class SlikaSmjestaja {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0

    @Column(name = "putanja_slike", nullable = false, length = 200)
    @Basic
    var putanjaSlike: String? = null

    @JoinColumn(name = "fk_smjestaj", referencedColumnName = "id", nullable = false)
    @ManyToOne
    var smjestaj: Smjestaj? = null

    constructor(putanjaSlike: String?, smjestaj: Smjestaj?) {
        this.putanjaSlike = putanjaSlike
        this.smjestaj = smjestaj
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as SlikaSmjestaja
        return id == that.id &&
                putanjaSlike == that.putanjaSlike
    }

    override fun hashCode(): Int {
        return Objects.hash(id, putanjaSlike)
    }

}
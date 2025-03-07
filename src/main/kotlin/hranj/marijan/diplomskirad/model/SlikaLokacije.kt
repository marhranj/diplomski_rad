package hranj.marijan.diplomskirad.model

import java.util.*
import javax.persistence.*

@Entity
class SlikaLokacije {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0

    @Column(name = "putanja_slike", nullable = false, length = 200)
    @Basic
    var putanjaSlike: String? = null

    @JoinColumn(name = "fk_lokacija", referencedColumnName = "id", nullable = false)
    @ManyToOne
    var lokacija: Lokacija? = null

    constructor(putanjaSlike: String?, lokacija: Lokacija?) {
        this.putanjaSlike = putanjaSlike
        this.lokacija = lokacija
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as SlikaLokacije
        return id == that.id &&
                putanjaSlike == that.putanjaSlike
    }

    override fun hashCode(): Int {
        return Objects.hash(id, putanjaSlike)
    }

}
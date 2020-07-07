package hranj.marijan.diplomskirad.model

import hranj.marijan.diplomskirad.enums.NazivUloge
import lombok.Getter
import lombok.Setter
import java.util.*
import javax.persistence.*

@Entity
@Getter
@Setter
class Uloga {

    @Column(name = "id", nullable = false)
    @Id
    var id = 0

    @Column(name = "naziv", nullable = false, length = 45)
    @Enumerated(EnumType.STRING)
    var naziv: NazivUloge? = null

    @ManyToMany(mappedBy = "uloge")
    var korisnici: Set<Korisnik>? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val uloga = o as Uloga
        return id == uloga.id &&
                naziv == uloga.naziv
    }

    override fun hashCode(): Int {
        return Objects.hash(id, naziv)
    }

}
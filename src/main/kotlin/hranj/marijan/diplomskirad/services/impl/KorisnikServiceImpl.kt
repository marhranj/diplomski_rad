package hranj.marijan.diplomskirad.services.impl

import hranj.marijan.diplomskirad.model.Korisnik
import hranj.marijan.diplomskirad.repository.KorisnikRepository
import hranj.marijan.diplomskirad.services.KorisnikService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class KorisnikServiceImpl(private val korisnikRepository: KorisnikRepository) : KorisnikService {

    override fun findAll(): List<Korisnik> {
        return korisnikRepository?.findAll() as List<Korisnik>
    }

}
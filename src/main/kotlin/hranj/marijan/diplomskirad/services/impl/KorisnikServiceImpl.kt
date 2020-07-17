package hranj.marijan.diplomskirad.services.impl

import hranj.marijan.diplomskirad.dto.KorisnikDto
import hranj.marijan.diplomskirad.enums.NazivUloge
import hranj.marijan.diplomskirad.exceptions.KorisnikVecPostojiException
import hranj.marijan.diplomskirad.model.Korisnik
import hranj.marijan.diplomskirad.model.Uloga
import hranj.marijan.diplomskirad.repository.KorisnikRepository
import hranj.marijan.diplomskirad.services.KorisnikService
import hranj.marijan.diplomskirad.services.UlogaService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class KorisnikServiceImpl(private val korisnikRepository: KorisnikRepository,
                          private val ulogaService: UlogaService,
                          private val passwordEncoder: PasswordEncoder) : KorisnikService {

    override fun findAll(): List<Korisnik> {
        return korisnikRepository.findAll()
    }

    @Throws(KorisnikVecPostojiException::class, Exception::class)
    override fun spremiKorisnika(korisnikDto: KorisnikDto) {
        if (korisnikRepository.findByKorisnickoImeOrEmail(korisnikDto.korisnickoIme, korisnikDto.email) != null) {
            throw KorisnikVecPostojiException("Postoji već korisnik s korisničkim imenom: ${korisnikDto.korisnickoIme} " +
                    "ili emailom: ${korisnikDto.email}")
        }
        val uloga: Uloga = ulogaService.findByNaziv(NazivUloge.KORISNIK)
        val korisnik = Korisnik(korisnikDto, setOf(uloga), passwordEncoder.encode(korisnikDto.lozinka))
        korisnikRepository.save(korisnik)
    }

    override fun findByKorisnickoIme(korisnickoIme: String): Korisnik? {
        return korisnikRepository.findByKorisnickoIme(korisnickoIme)
    }

}
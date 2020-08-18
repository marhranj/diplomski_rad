package hranj.marijan.diplomskirad.security.service

import hranj.marijan.diplomskirad.model.Korisnik
import hranj.marijan.diplomskirad.repository.KorisnikRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service("userDetailsService")
@Transactional
class UserDetailsService(private val korisnikRepository: KorisnikRepository) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val korisnik = korisnikRepository.findByKorisnickoImeOrEmail(username, username)
                ?: throw UsernameNotFoundException("Nepostojeće korisničko ime pod nazivom $username")
        val grantedAuthorities: MutableSet<GrantedAuthority> = HashSet()
        korisnik.uloge?.stream()
                ?.map { uloga -> SimpleGrantedAuthority(uloga.naziv.toString().toUpperCase()) }
                ?.forEach { uloga -> grantedAuthorities.add(uloga) }

        return User(korisnik.korisnickoIme, korisnik.lozinka, grantedAuthorities)
    }

}
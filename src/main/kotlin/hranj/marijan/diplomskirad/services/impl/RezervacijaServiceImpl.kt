package hranj.marijan.diplomskirad.services.impl

import hranj.marijan.diplomskirad.model.Rezervacija
import hranj.marijan.diplomskirad.repository.RezervacijaRepository
import hranj.marijan.diplomskirad.services.EmailService
import hranj.marijan.diplomskirad.services.RezervacijaService
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat

@Service
class RezervacijaServiceImpl(private val rezervacijaRepository: RezervacijaRepository,
                             private val emailService: EmailService) : RezervacijaService {

    val formatter: SimpleDateFormat = SimpleDateFormat("dd.MM.yyyy")

    override fun findAll(): List<Rezervacija> {
        return rezervacijaRepository.findAll()
    }

    override fun spremiRezervaciju(rezervacija: Rezervacija) {
        rezervacijaRepository.save(rezervacija)
    }

    override fun obrisiRezervaciju(rezervacija: Rezervacija) {
        rezervacijaRepository.delete(rezervacija)
    }

    override fun rezerviraj(rezervacija: Rezervacija) {
        spremiRezervaciju(rezervacija)
        posaljiEmailORezervaciji(rezervacija)
    }

    override fun otkazi(idRezervacije: Int) {
        val rezervacija = rezervacijaRepository.findById(idRezervacije)
        rezervacija.ifPresent{
            posaljiEmailOOtkazivanju(it)
            obrisiRezervaciju(it)
        }
    }

    fun posaljiEmailORezervaciji(rezervacija: Rezervacija) {
        val primatelj = rezervacija.smjestaj?.email ?: ""
        val imePrezime = "${rezervacija.korisnik?.ime} ${rezervacija.korisnik?.prezime}"
        val subjekt = "Rezervacija smještaja ${imePrezime}"
        val formatiraniPocetak = formatter.format(rezervacija.pocetak)
        val formatiraniKraj = formatter.format(rezervacija.kraj)
        val sadrzaj = "${imePrezime} s email adresom: ${rezervacija.korisnik?.email} te brojem telefona: ${rezervacija.korisnik?.telefon} " +
                "je rezervirao smještaj ${rezervacija.smjestaj?.naziv} u datumu " +
                "od ${formatiraniPocetak} do ${formatiraniKraj} te po cijeni od ${rezervacija.ukupnaCijena} kn"
        emailService.posaljiEmail(primatelj, subjekt, sadrzaj)
    }

    fun posaljiEmailOOtkazivanju(rezervacija: Rezervacija) {
        val primatelj = rezervacija.smjestaj?.email ?: ""
        val imePrezime = "${rezervacija.korisnik?.ime} ${rezervacija.korisnik?.prezime}"
        val subjekt = "Otkazivanje smještaja ${imePrezime}"
        val formatiraniPocetak = formatter.format(rezervacija.pocetak)
        val formatiraniKraj = formatter.format(rezervacija.kraj)
        val sadrzaj = "${imePrezime} s email adresom: ${rezervacija.korisnik?.email} te brojem telefona: ${rezervacija.korisnik?.telefon} " +
                "je otkazao smještaj ${rezervacija.smjestaj?.naziv} u datumu " +
                "od ${formatiraniPocetak} do ${formatiraniKraj}"
        emailService.posaljiEmail(primatelj, subjekt, sadrzaj)
    }

}
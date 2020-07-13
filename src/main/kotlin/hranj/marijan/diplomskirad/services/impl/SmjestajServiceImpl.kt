package hranj.marijan.diplomskirad.services.impl

import hranj.marijan.diplomskirad.dto.SmjestajDto
import hranj.marijan.diplomskirad.exceptions.LokacijaNePostojiException
import hranj.marijan.diplomskirad.model.SlikaSmjestaja
import hranj.marijan.diplomskirad.model.Smjestaj
import hranj.marijan.diplomskirad.repository.SmjestajRepository
import hranj.marijan.diplomskirad.services.LokacijaService
import hranj.marijan.diplomskirad.services.SmjestajService
import hranj.marijan.diplomskirad.services.UpravljanjeSlikomService
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class SmjestajServiceImpl(private val smjestajRepository: SmjestajRepository,
                          private val upravljanjeSlikomService: UpravljanjeSlikomService,
                          private val lokacijaService: LokacijaService) : SmjestajService {

    override fun findAll(): List<Smjestaj> {
        return smjestajRepository.findAll()
    }

    @Throws(Exception::class)
    override fun spremiSmjestaj(smjestajDto: SmjestajDto) {
        val lokacija = lokacijaService.findById(smjestajDto.lokacija)
        if (lokacija.isPresent) {
            val smjestaj = Smjestaj(smjestajDto, lokacija.get())
            val slikeSmjestaja = upravljanjeSlikomService.spremiSlike(smjestajDto.slike).stream()
                    .map { putanja -> SlikaSmjestaja(putanja, smjestaj) }
                    .collect(Collectors.toList())
            smjestaj.slikeSmjestaja = slikeSmjestaja
            smjestajRepository.save(smjestaj)
        } else {
            throw LokacijaNePostojiException("Ne postoji odabrana lokacija")
        }
    }

}
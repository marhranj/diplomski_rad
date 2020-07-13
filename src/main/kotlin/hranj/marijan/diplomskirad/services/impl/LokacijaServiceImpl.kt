package hranj.marijan.diplomskirad.services.impl

import hranj.marijan.diplomskirad.dto.LokacijaDto
import hranj.marijan.diplomskirad.model.Lokacija
import hranj.marijan.diplomskirad.model.SlikaLokacije
import hranj.marijan.diplomskirad.repository.LokacijaRepository
import hranj.marijan.diplomskirad.services.KategorijaService
import hranj.marijan.diplomskirad.services.LokacijaService
import hranj.marijan.diplomskirad.services.UpravljanjeSlikomService
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class LokacijaServiceImpl(private val lokacijaRepository: LokacijaRepository,
                          private val kategorijaService: KategorijaService,
                          private val upravljanjeSlikomService: UpravljanjeSlikomService) : LokacijaService {

    override fun findAll(): List<Lokacija> {
        return lokacijaRepository.findAll()
    }

    override fun findById(id: Int): Optional<Lokacija> {
        return lokacijaRepository.findById(id)
    }

    @Throws(Exception::class)
    override fun spremiLokaciju(lokacijaDto: LokacijaDto) {
        val kategorije = kategorijaService.findAllByIdIn(lokacijaDto.kategorije!!)
        val lokacija = Lokacija(lokacijaDto, kategorije)
        val slikeLokacije = upravljanjeSlikomService.spremiSlike(lokacijaDto.slike).stream()
                .map { putanja -> SlikaLokacije(putanja, lokacija) }
                .collect(Collectors.toList())
        lokacija.slikeLokacije = slikeLokacije
        lokacijaRepository.save(lokacija)
    }

}
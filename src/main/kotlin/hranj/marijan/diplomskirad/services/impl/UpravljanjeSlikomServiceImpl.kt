package hranj.marijan.diplomskirad.services.impl

import hranj.marijan.diplomskirad.services.UpravljanjeSlikomService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.util.ResourceUtils
import org.springframework.web.multipart.MultipartFile
import java.io.File

@Service
class UpravljanjeSlikomServiceImpl : UpravljanjeSlikomService {

    @Value("\${hranj.marijan.diplomskirad.lokacija.uploadanih.slika}")
    lateinit var direktorijSlika: String

    @Throws(Exception::class)
    override fun spremiSliku(slika: MultipartFile?) {
        if (slika != null && !slika.isEmpty) {
            val resourcesDirektorij: String = File("src/main/resources").absolutePath
            val direktorijSlikaAbsolutniUri = resourcesDirektorij + direktorijSlika
            if (!File(direktorijSlikaAbsolutniUri).exists()) {
                File(direktorijSlikaAbsolutniUri).mkdir()
            }
            val destinacija = File(direktorijSlikaAbsolutniUri + slika.originalFilename)
            slika.transferTo(destinacija)
        }
    }

    @Throws(Exception::class)
    override fun spremiSlike(slike: List<MultipartFile>?) {
        slike?.forEach{ slika -> spremiSliku(slika) }
    }

}
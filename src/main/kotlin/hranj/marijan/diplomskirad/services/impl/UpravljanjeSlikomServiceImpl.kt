package hranj.marijan.diplomskirad.services.impl

import hranj.marijan.diplomskirad.services.UpravljanjeSlikomService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.util.stream.Collectors

@Service
class UpravljanjeSlikomServiceImpl : UpravljanjeSlikomService {

    @Value("\${hranj.marijan.diplomskirad.lokacija.uploadanih.slika}")
    lateinit var direktorijSlika: String

    val putanjaResourcesDirektorija: String = "src/main/resources"

    @Throws(Exception::class)
    override fun spremiSliku(slika: MultipartFile?): String {
        if (slika != null && !slika.isEmpty) {
            val resourcesDirektorij: String = File(putanjaResourcesDirektorija).absolutePath
            val direktorijSlikaAbsolutniUri = resourcesDirektorij + direktorijSlika
            if (!File(direktorijSlikaAbsolutniUri).exists()) {
                File(direktorijSlikaAbsolutniUri).mkdir()
            }
            val jedinstvenaPutanjaSLike = "$direktorijSlikaAbsolutniUri${System.currentTimeMillis()}_${slika.originalFilename}"
            val destinacija = File(jedinstvenaPutanjaSLike)
            slika.transferTo(destinacija)
            return jedinstvenaPutanjaSLike.split("$putanjaResourcesDirektorija/static")[1]
        }
        return ""
    }

    @Throws(Exception::class)
    override fun spremiSlike(slike: List<MultipartFile>?): List<String> {
        return slike?.stream()
                ?.map{ slika -> spremiSliku(slika) }
                ?.collect(Collectors.toList())!!
    }

}
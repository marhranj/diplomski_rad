package hranj.marijan.diplomskirad.services

import org.springframework.web.multipart.MultipartFile

interface UpravljanjeSlikomService {

    fun spremiSliku(slika: MultipartFile?): String

    fun spremiSlike(slike: List<MultipartFile>?): List<String>

}
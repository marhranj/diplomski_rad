package hranj.marijan.diplomskirad.services

import org.springframework.web.multipart.MultipartFile

interface UpravljanjeSlikomService {

    fun spremiSliku(slika: MultipartFile?)

    fun spremiSlike(slike: List<MultipartFile>?)

}
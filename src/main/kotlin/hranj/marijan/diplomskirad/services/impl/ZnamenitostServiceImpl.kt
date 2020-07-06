package hranj.marijan.diplomskirad.services.impl

import hranj.marijan.diplomskirad.model.Znamenitost
import hranj.marijan.diplomskirad.repository.ZnamenitostRepository
import hranj.marijan.diplomskirad.services.ZnamenitostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ZnamenitostServiceImpl : ZnamenitostService {

    @Autowired
    var znamenitostRepository: ZnamenitostRepository? = null

    override fun findAll(): List<Znamenitost> {
        return znamenitostRepository?.findAll() as List<Znamenitost>
    }

}
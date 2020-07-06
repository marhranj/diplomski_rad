package hranj.marijan.diplomskirad.services

import hranj.marijan.diplomskirad.model.Znamenitost

interface ZnamenitostService {

    fun findAll(): List<Znamenitost>

}
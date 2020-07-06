package hranj.marijan.diplomskirad.repository

import hranj.marijan.diplomskirad.model.Znamenitost
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ZnamenitostRepository : CrudRepository<Znamenitost, Long>
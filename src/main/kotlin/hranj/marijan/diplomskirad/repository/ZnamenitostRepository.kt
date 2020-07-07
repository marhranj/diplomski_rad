package hranj.marijan.diplomskirad.repository

import hranj.marijan.diplomskirad.model.Znamenitost
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ZnamenitostRepository : JpaRepository<Znamenitost, Long>
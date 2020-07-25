package hranj.marijan.diplomskirad

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DiplomskiRadApplication

	fun main(args: Array<String>) {
        val i = 1
        if (i !in 2..i + 6) {
            println("Varijabla nije u rasponu brojeva")
        }

        runApplication<DiplomskiRadApplication>(*args)
	}


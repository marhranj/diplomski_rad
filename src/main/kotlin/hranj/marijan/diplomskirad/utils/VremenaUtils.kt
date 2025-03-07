package hranj.marijan.diplomskirad.utils

import java.time.LocalDate

class VremenaUtils {

    companion object Objekt {
        fun vremenaSePokalapaju(pocetakVrijemeJedan: LocalDate, krajVrijemeJedan: LocalDate,
                                pocetakVrijemeDva: LocalDate, krajVrijemeDva: LocalDate) : Boolean {
            return (pocetakVrijemeJedan.isBefore(krajVrijemeDva) || pocetakVrijemeJedan == krajVrijemeDva)
                    && (krajVrijemeJedan.isAfter(pocetakVrijemeDva) || krajVrijemeJedan == pocetakVrijemeDva)
        }
    }

}
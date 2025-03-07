package hranj.marijan.diplomskirad.services

import hranj.marijan.diplomskirad.model.Rezervacija

interface RezervacijaService {

    fun findAll(): List<Rezervacija>

    fun spremiRezervaciju(rezervacija: Rezervacija)

    fun rezerviraj(rezervacija: Rezervacija)

    fun otkazi(idRezervacije: Int)

    fun obrisiRezervaciju(rezervacija: Rezervacija)

}
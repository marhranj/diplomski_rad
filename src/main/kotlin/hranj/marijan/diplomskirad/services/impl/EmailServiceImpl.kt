package hranj.marijan.diplomskirad.services.impl

import hranj.marijan.diplomskirad.services.EmailService
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.MailException
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailServiceImpl(private val javaMailSender: JavaMailSender) : EmailService {

    @Value("\${hranj.marijan.diplomskirad.email.posiljatelj}")
    lateinit var posiljatelj: String

    @Throws(MailException::class)
    override fun posaljiEmail(primatelj: String, subjekt: String, sadrzaj: String) {
        val jednostavniMail = SimpleMailMessage()
        jednostavniMail.setFrom(posiljatelj)
        jednostavniMail.setTo(primatelj)
        jednostavniMail.setSubject(subjekt)
        jednostavniMail.setText(sadrzaj)
        javaMailSender.send(jednostavniMail)
    }

}
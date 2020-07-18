package hranj.marijan.diplomskirad.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration(private val userDetailsService: UserDetailsService) : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .antMatchers("/admin/**")
                    .hasAuthority("ADMIN")
                .antMatchers("/rezerviraj-smjestaj", "/moji-smjestaji")
                    .authenticated()
                .antMatchers("/prijava", "/registracija")
                    .anonymous()
                .and()
                .formLogin()
                    .loginPage("/prijava")
                    .usernameParameter("korisnickoIme")
                    .passwordParameter("lozinka")
                .and()
                .logout()
                    .logoutUrl("/odjava")
                    .logoutSuccessUrl("/")
                .and()
                .exceptionHandling()
                    .accessDeniedPage("/")
    }

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder())
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }

}
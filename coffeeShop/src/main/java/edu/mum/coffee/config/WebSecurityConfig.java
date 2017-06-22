package edu.mum.coffee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.repository.PersonRepository;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
//        .authorizeRequests()
//            .antMatchers("/", "/persons/addPerson","/home", "/index").permitAll()
//            .antMatchers("/products/**").hasRole("ADMIN")
//            .antMatchers("/products").hasRole("USER")
//            .anyRequest().authenticated()
//            .and()
//        .formLogin().defaultSuccessUrl("/home")
//        	.permitAll()
//        	.and()
//        .logout()
//        	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//        	.logoutSuccessUrl("/")
//            .permitAll();

    }

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	
//		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
//		
//		for(Person uc:personRepository.findAll()){			
//		auth.inMemoryAuthentication().withUser(uc.getUserCredential().getUserName()).password(uc.getUserCredential().getPassword()).roles("USER");
//		}
	}
}
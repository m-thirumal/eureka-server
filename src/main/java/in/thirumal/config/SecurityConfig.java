package in.thirumal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Thirumal
 * @version 1.0
 * @since 22/10/2018
 */
@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
        .withUser("thirumal").password("$2a$11$WWZlUCd4XndWGpriAx7Pv.HpZ042awTnlAKr9VDiN9xEdPNS1Xy1q").roles("ADMIN").roles("ACTUATOR");
	}
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		//http.csrf().disable();
		/*http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS).
			and().requestMatchers()
			.antMatchers("/eureka/**").and().authorizeRequests().antMatchers("/eureka/**").hasRole("ADMIN")
			.anyRequest().denyAll().and().httpBasic().and().csrf().disable(); */
		  http.csrf().ignoringAntMatchers("/eureka/**");
	      super.configure(http);
	}
		
	@Override 
	public void configure(WebSecurity web) { //
		web.ignoring().antMatchers("/**"); //web.debug(true);
		//web.ignoring().requestMatchers(CorsUtils::isPreFlightRequest)
	  	//	.antMatchers("/webjars/**"); 
	}		 
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
		PasswordEncoder encoder = new BCryptPasswordEncoder(); 
		return encoder; 
	}
	
}

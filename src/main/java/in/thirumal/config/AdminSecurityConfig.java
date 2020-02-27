/**
 * 
 */
package in.thirumal.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author thirumal
 *
 */
@Configuration
public class AdminSecurityConfig {//extends WebSecurityConfigurerAdapter{
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
	   http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
	     .and().httpBasic().disable().authorizeRequests()
	     .antMatchers(HttpMethod.GET, "/").hasRole("ADMIN")
	     .antMatchers("/info", "/health").authenticated().anyRequest()
	     .denyAll().and().csrf().disable();
	 }*/
	
}

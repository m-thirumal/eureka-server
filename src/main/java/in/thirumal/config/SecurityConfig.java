package in.thirumal.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AnonymousConfigurer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Thirumal
 * @version 1.0
 * @since 22/10/2018
 */
@Configuration
@EnableWebSecurity
//@Order(1)
public class SecurityConfig {

    @Bean
    InMemoryUserDetailsManager configAuthentication() {

       List<UserDetails> users = new ArrayList<>();
       List<GrantedAuthority> adminAuthority = new ArrayList<>();
       adminAuthority.add(new SimpleGrantedAuthority("ADMIN"));
       adminAuthority.add(new SimpleGrantedAuthority("ACTUATOR"));
       UserDetails admin= new User("thirumal", "$2a$11$WWZlUCd4XndWGpriAx7Pv.HpZ042awTnlAKr9VDiN9xEdPNS1Xy1q", adminAuthority);
       users.add(admin);

       List<GrantedAuthority> managerAuthority = new ArrayList<>();
       adminAuthority.add(new SimpleGrantedAuthority("MANAGER"));
       UserDetails manager= new User("t", "{noop}t", managerAuthority);
       users.add(manager);

       return new InMemoryUserDetailsManager(users);
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http.cors(CorsConfigurer::disable);
    	http.anonymous(AnonymousConfigurer::disable);
    	http.csrf(CsrfConfigurer::disable);
    	http
		.authorizeHttpRequests(authorize -> authorize
			//	.requestMatchers(HttpMethod.POST, "/user/**").permitAll()
			.anyRequest().authenticated())
		// Form login handles the redirect to the login page from the
		// authorization server filter chain
		.formLogin(Customizer.withDefaults());
//        http.cors().and().csrf().disable() 
//        		.anonymous().disable()
//        		 .formLogin().permitAll()//.and()//.authorizeHttpRequests().requestMatchers("/", "/eureka/**").permitAll()
//        		 .and().authorizeHttpRequests()
//                         .anyRequest().authenticated();
        return http.build();
    }

    @Bean
    WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers(CorsUtils::isPreFlightRequest).requestMatchers("/actuator/**", "/eureka/**");
    }

    @Bean
    PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
}

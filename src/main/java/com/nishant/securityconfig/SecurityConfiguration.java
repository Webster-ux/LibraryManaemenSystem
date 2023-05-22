package com.nishant.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.nishant.jwt.config.JwtAuthenticationEntryPoint;
import com.nishant.jwt.filter.JwtRequestFilter;
import com.nishant.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		var auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		  http.authorizeRequests().antMatchers("/js/**", "/css/**",
		  "/img/**","/auth").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").and().logout()
			  .logoutRequestMatcher(new
					  AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
					  .deleteCookies("JSESSIONID").and().exceptionHandling()
					  .authenticationEntryPoint(jwtAuthenticationEntryPoint).and().
					  sessionManagement() .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
					  http.addFilterBefore(jwtRequestFilter,
					  UsernamePasswordAuthenticationFilter.class);
		  /*.and().formLogin().loginPage("/login").permitAll().and().logout().
		  invalidateHttpSession(true)
		  .clearAuthentication(true).logoutRequestMatcher(new
		  AntPathRequestMatcher("/logout"))
		  .logoutSuccessUrl("/login?logout").permitAll().and().
			  sessionManagement() .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			  http.addFilterBefore(jwtRequestFilter,
			  UsernamePasswordAuthenticationFilter.class);*/
		 
		/*
		 * http.csrf().disable().authorizeRequests().antMatchers( "/login",
		 * "/auth").permitAll()
		 * 
		 * .antMatchers("/login", "/authors",
		 * "/updateAuthor","/update-author","/remove-author","/addAuthor","/add-author",
		 * "/books", "/"
		 * ,"/searchBook","/add","/add-book","/update","/update-book","/remove-book",
		 * "/categories","/addCategory","/add-category","/updateCategory",
		 * "/update-category","/remove-category",
		 * "/publishers","/addPublisher","/add-publisher","/updatePublisher",
		 * "/update-publisher","/remove-publisher","/auth")
		 * 
		 * .permitAll()
		 * 
		 * .and().formLogin().loginPage("/login").and().logout()
		 * .logoutRequestMatcher(new
		 * AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
		 * .deleteCookies("JSESSIONID").and().exceptionHandling()
		 * .authenticationEntryPoint(jwtAuthenticationEntryPoint).and().
		 * sessionManagement() .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 * http.addFilterBefore(jwtRequestFilter,
		 * UsernamePasswordAuthenticationFilter.class);
		 */

	}
}
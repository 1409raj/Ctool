package com.sampark.ctool.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.jdbcAuthentication().dataSource(dataSource)
//		.passwordEncoder(passwordEncoder())
		.usersByUsernameQuery("select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select u.username, r.name from users as u,roles as r where u.username=? and r.id = u.role_Id");
	}	
//	@Bean
//	public PasswordEncoder passwordEncoder(){
//		PasswordEncoder encoder = new BCryptPasswordEncoder();
//		return encoder;
//	}
    @Override
    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/common/**");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
//		http.httpBasic().authenticationEntryPoint(new AjaxAuthorizationPoint("/login"));
		http.authorizeRequests()
//			.antMatchers("apms/").access(SecurityUtils.getAllUserTypes())
//			.antMatchers("/contact").access("hasRole('" + ApmsConstants.USER_SUPER + "')")
//			.antMatchers("/superuser/**").access(SecurityUtils.getAllUserTypes())
//			.antMatchers("/exit").access(SecurityUtils.getAllUserTypes())
//			.and().anonymous().disable()
		.antMatchers("/").permitAll()
		.and().formLogin().loginPage("/login").failureUrl("/login?error")
	  	.usernameParameter("username").passwordParameter("password").and().logout().logoutSuccessUrl("/login?logout/")
		.and().exceptionHandling().accessDeniedPage("/accessDenied").and().anonymous().disable();
	http.csrf().disable();
		
	}
}
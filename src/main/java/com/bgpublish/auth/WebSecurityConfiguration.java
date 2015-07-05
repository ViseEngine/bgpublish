/**
 * 
 */
package com.bgpublish.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bgpublish.domain.User;
import com.bgpublish.service.UserService;

/**
 * @author ps
 *
 */
@Configuration
public class WebSecurityConfiguration extends
		GlobalAuthenticationConfigurerAdapter {
	
	private @Autowired UserService userService;
	private @Autowired PasswordEncoder passwordEncoder;
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder);
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
	}
	
	@Bean
	protected UserDetailsService  userDetailsService(){
		UserDetailsService userDetailsService = new UserDetailsService(){
			@Override
			public UserDetails loadUserByUsername(String username)
					throws UsernameNotFoundException {
				User user = WebSecurityConfiguration.this.userService.selectUserByMobile(username);
				if(user != null){
					return new org.springframework.security.core.userdetails.User(user.getMobile(), user.getPassword(), 
							true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
				}
				throw new UsernameNotFoundException("could not find the user '" + username + "'");
			}
		};
		
		return userDetailsService;
	}
}

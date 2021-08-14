package com.kobos.oursearchlist.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//스프링 시큐리티 설정 클래스 
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// MemberAuthenticationProvider: 인증 로직을 정의한 클래스
	//( id 일치여부, 암호화된 password 일치여부 , id, password가 일치하지 않으면 exception throws 
	//  권한체크해 exception throws , 인증 조건이 되면 Security 인증 객체로 할당)
	@Autowired
	private MemberAuthenticationProvider authenticationProvider;
	
	//비밀번호 암호화를 위한 bean 생성 -> MemberService 에서 비번 암호화를 위해 사용 , 
	//MemberAuthenticationProvider 에서 비번 일치여부를 위해 사용 
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	/*
	 	인증(authentication)을 위한 설정은 아래의 메서드에서 처리한다 (로그인 기능과 로그인 여부에 따른 서비스 접근에 대한 설정 ) 
	 	인가(authorization)에 대한 설정은 각 컨트롤러 메서드에서 @Secured("ROLE_ADMIN") 와 같이 설정한다  
	 	( 인증받은 회원이 부여받은 권한에 의거해 접근할 수 있는 서비스에 대한 설정 ) 	 	
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {		
		httpSecurity.oauth2Login().defaultSuccessUrl("/loginSuccess").failureUrl("/loginFailure");
		httpSecurity
			.authorizeRequests()
				.antMatchers("/", "/home","/user/**", "/myweb/**", "oauth2/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/user/signInForm")
				.loginProcessingUrl("/signIn")
				.failureUrl("/user/signInFormFail")
				.defaultSuccessUrl("/home")
				.usernameParameter("id")
				.passwordParameter("password")
				.permitAll()
				.and()
			.logout()
				.permitAll()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/home")
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true)
				.and()
			.exceptionHandling()
				.accessDeniedPage("/accessDeniedView")
				.authenticationEntryPoint(new AjaxAuthenticationEntryPoint("/user/signInForm"));
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider);
	}

}
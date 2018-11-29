package com.example.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfigure extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private DataSource dataSource;   //是在application.properites
	
	@Autowired
	private MyAuthenticationProvider provider;  //注入我们自己的AuthenticationProvider
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailHander myAuthenticationFailHander;

/*	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
        http
        .formLogin().loginPage("/login").loginProcessingUrl("/login/form").failureUrl("/login-error").permitAll()  //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
        .and()
        .authorizeRequests().anyRequest().authenticated()                  
        .and()
        .csrf().disable();  
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
        http
        .formLogin().loginPage("/login").loginProcessingUrl("/login/form")
        .successHandler(myAuthenticationSuccessHandler)
        .failureHandler(myAuthenticationFailHander).permitAll()  //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
        .and()
        .rememberMe()
        .rememberMeParameter("remember-me").userDetailsService(userDetailsService)
        .tokenRepository(persistentTokenRepository())
        .tokenValiditySeconds(1209600)
        .and()
        .authorizeRequests()
/*        .antMatchers("/hello").permitAll()  //这就表示 /hello这个页面不需要权限认证，所有人都可以访问
        .antMatchers("/whoim").hasRole("ADMIN") //这就表示/whoim的这个资源需要有ROLE_ADMIN的这个角色才能访问。不然就会提示拒绝访问
        .antMatchers(HttpMethod.POST,"/user/*").hasRole("ADMIN")   //post需要 管理员权限，get 需要user权限
        .antMatchers(HttpMethod.GET,"/user/*").hasRole("USER")
        .anyRequest().authenticated()   */   
        .anyRequest().access("@rbacService.hasPermission(request,authentication)")    //必须经过认证以后才能访问            
        .and()
        .csrf().disable();  
	}

/*	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth
        .inMemoryAuthentication()
              .withUser("admin").password("{noop}123456").roles("USER")
              .and()
              .withUser("test").password("{noop}test123").roles("ADMIN");
	}*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {   //自定义认证
		// TODO Auto-generated method stub
		auth.authenticationProvider(provider);

	}
	
/*    @Autowired   //两种方法都可以用户认证
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
          auth
                .inMemoryAuthentication()
                      .withUser("admin").password("{noop}123456").roles("USER");
          
    }*/
	
	
    /**
     * 记住我功能的token存取器配置
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
          JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
          tokenRepository.setDataSource(dataSource);
          return tokenRepository;
    }


}

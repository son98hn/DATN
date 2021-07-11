package com.example.datn.Config;//package com.example.demo.Config;

import javax.sql.DataSource;

import com.example.datn.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.authorizeRequests().antMatchers("/trang-chu", "/login", "/logout").permitAll()
//        .anyRequest().authenticated().and();
//        http.authorizeRequests().antMatchers("/userInfo**").access("hasAnyRole('admin', 'user')");
//        http.authorizeRequests().antMatchers("/admin-*").access("hasRole('admin')");
//        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/login?error=true");
//        http.authorizeRequests().and().formLogin()//
//                // Submit URL của trang login
//                .loginProcessingUrl("/j_spring_security_check") // Submit URL
//                .loginPage("/login")//
//                .defaultSuccessUrl("/trang-chu")//
////                .success
//                .failureUrl("/login?error=true")//
//                .usernameParameter("username")//
//                .passwordParameter("password")
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/trang-chu","/login**","/","/template/**","/nhom-bai-viet/**","/bai-viet/**").permitAll()
                .antMatchers("/admin**").authenticated()
                .antMatchers("/userInfo**").authenticated()
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").permitAll()
                .successHandler(authenticationSuccessHandler)
                .failureUrl("/login?error=true")
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().exceptionHandling().accessDeniedPage("/403");
//                .and().logout().logoutUrl("/trang-chu").logoutSuccessUrl("/trang-chu");
        // Cấu hình Remember Me.
//        http.authorizeRequests().and() //
//                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
//                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h

    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        return new InMemoryTokenRepositoryImpl();
    }

}
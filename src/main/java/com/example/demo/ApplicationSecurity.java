package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity
public class ApplicationSecurity  extends WebSecurityConfigurerAdapter {
  /*  @Override
    protected void configure(HttpSecurity http) throws Exception {
         http
                 .csrf().disable()
                 .authorizeRequests()
                 .antMatchers("/**").permitAll();




    }
*/
    @Override
    public void configure(WebSecurity web ) throws Exception {
        web.ignoring().antMatchers("/**");
    }
}

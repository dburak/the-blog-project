package com.burakdiker.security;
import com.burakdiker.bean.PasswordEncoderBean;
import com.burakdiker.security.jwt.JwtAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//lombok
@RequiredArgsConstructor

//security
@EnableWebSecurity

//bean için ekledim
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //field
    private final PasswordEncoderBean passwordEncoderBean;
    private final UserDetailsServiceCustom customUserDetailsService;


    //////////////////////////////////////////////////////////////////////////////////
    //BEAN
    //import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*")
                        .allowedMethods("*"); //POST,GET,
            }
        };
    }


    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilterBeanMethod(){
        return new JwtAuthorizationFilter();
    }

    // AUTHENTICATION_MANAGER
    @Override
    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoderBean.passwordEncoderMethod());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();


        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/api/authentication/**").permitAll() //login and register
                .anyRequest().authenticated();


        http.addFilterBefore(jwtAuthorizationFilterBeanMethod(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/h2-console/**","/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/assets/**","/fonts/**","/dis/**","/vendor1/**","/assets2/**");
    } //end configure WebSecurity(1)
}

package v0.project.mysite.config;



import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import v0.project.mysite.KBC.service.CustomAuthenticationFailureHandler;
import v0.project.mysite.PJH.CustomAuthenticationSuccessHandler;
import v0.project.mysite.PJH.CustomOAuth2UserService;

import static org.springframework.security.config.Customizer.withDefaults;


@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@Log4j2
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;
//    private final UserDetailsService userDetailsService;
    private final AuthenticationConfiguration authenticationConfiguration;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        CustomUsernamePasswordAuthenticationFilter customFilter = new CustomUsernamePasswordAuthenticationFilter();
//        customFilter.setAuthenticationManager(authenticationManager(http));
//        customFilter.setAuthenticationFailureHandler(new CustomAuthenticationFailureHandler());

        http
                .csrf(csrf -> csrf.disable())
                .cors(withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll()
                        .anyRequest().authenticated()
                )
//                .addFilterAt(customFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin((formLogin) -> formLogin
                        .loginProcessingUrl("/login")  // Vue.js에서 POST로 요청할 로그인 URL
                        .usernameParameter("username")  // Vue.js에서 보낼 사용자 이름 파라미터 이름
                        .passwordParameter("password")  // Vue.js에서 보낼 패스워드 파라미터 이름
                        .defaultSuccessUrl("/", true)
                        .failureHandler(new CustomAuthenticationFailureHandler())) // 로그인 실패 시 CustomAuthenticationFailureHandler 사용

                .oauth2Login(oauth2Login -> oauth2Login
                        .defaultSuccessUrl("http://localhost:5173/", true)
//                        .failureUrl("/login?error")
                        .userInfoEndpoint(userInfoEndpoint ->
                                userInfoEndpoint.userService(customOAuth2UserService))
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
//package com.example.nicecoding.security;
//
//import com.example.nicecoding.security.service.KullaniciService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.ObjectPostProcessor;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class AppSecurityConfig{
//
//        @Autowired
//        private KullaniciService kullaniciService;
//
//        @Bean
//        public BCryptPasswordEncoder passwordEncoder(){
//            return new BCryptPasswordEncoder();
//        }
//
//        @Bean
//        public DaoAuthenticationProvider daoAuthenticationProvider(){
//            DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//            auth.setUserDetailsService(kullaniciService);
//            auth.setPasswordEncoder(passwordEncoder());
//            return auth;
//        }
//
//    @Bean
//    public AuthenticationManagerBuilder authenticationManagerBuilder() throws Exception {
//        // Burada AuthenticationManagerBuilder'ı istediğiniz gibi yapılandırabilirsiniz
//        // AuthenticationManagerBuilder auth = new AuthenticationManagerBuilder(); // Bu satırı silin
//        AuthenticationManagerBuilder auth = new AuthenticationManagerBuilder(new ObjectPostProcessor<Object>() {
//            @Override
//            public <O extends Object> O postProcess(O object) {
//                // Burada object'i istediğiniz gibi özelleştirebilirsiniz
//                return object;
//            }
//        }); // Bu satırı ekleyin
//        auth.authenticationProvider(daoAuthenticationProvider());
//        return auth;
//    }
//
//        @Bean
//        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//            return http
//                    .authorizeHttpRequests((requests) -> requests
//                            .requestMatchers("/register/account", "/css/**", "/js/**", "/img/**").permitAll()
//                            .anyRequest().authenticated()
//                    )
//                    .and()
//                    .formLogin().loginPage("/login").permitAll()
//                    .and()
//                    .logout()
//                    .invalidateHttpSession(true)
//                    .clearAuthentication(true)
//                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                    .logoutSuccessUrl("/login?logout").permitAll()
//                    .and()
//                    .csrf().disable() // CSRF korumasını devre dışı bırakmak için gerekli
//                    .build();
//        }
//
//
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        return http
////                .authorizeHttpRequests((requests) -> requests
////                        .requestMatchers("/register/account", "/css/**", "/js/**", "/img/**").permitAll()
////                        .anyRequest().authenticated()
////                )
////                .and()
////                .formLogin().loginPage("/login").permitAll()
////                .and()
////                .logout()
////                .invalidateHttpSession(true)
////                .clearAuthentication(true)
////                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                .logoutSuccessUrl("/login?logout").permitAll()
////                .and()
////                .csrf().disable() // CSRF korumasını devre dışı bırakmak için gerekli
////                .build();
////    }
//
//
//
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        return http
////                .authorizeRequests()
////                .mvcMatchers("/register/account", "/css/**", "/js/**", "/img/**").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .formLogin().loginPage("/login").permitAll()
////                .and()
////                .logout()
////                .invalidateHttpSession(true)
////                .clearAuthentication(true)
////                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                .logoutSuccessUrl("/login?logout").permitAll()
////                .and()
////                .build();
////    }
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        return http.authorizeRequests()
////                .mvcMatchers("/register/account", "/css/**", "/js/**", "/img/**").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .formLogin().loginPage("/login").permitAll()
////                .and()
////                .logout()
////                .invalidateHttpSession(true)
////                .clearAuthentication(true)
////                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                .logoutSuccessUrl("/login?logout").permitAll()
////                .and()
////                .build(); // Burada build() yöntemini çağırarak SecurityFilterChain döndürüyoruz
////    }
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        // Burada HttpSecurity nesnesini kullanarak web güvenliği kurallarını belirleyebilirsiniz
////        return http.authorizeRequests()
////                .pathMatchers("/register/account", "/css/**", "/js/**", "/img/**").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .formLogin().loginPage("/login").permitAll()
////                .and()
////                .logout()
////                .invalidateHttpSession(true)
////                .clearAuthentication(true)
////                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                .logoutSuccessUrl("/login?logout").permitAll()
////                .and()
////                .build();
////    }
//
//
//
//
//
//
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        // Burada HttpSecurity nesnesini kullanarak web güvenliği kurallarını belirleyebilirsiniz
////        http.authorizeRequests()
////                // antMatchers() yerine mvcMatchers() kullanın
////                .mvcMatchers("/register/account", "/css/**", "/js/**", "/img/**").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .formLogin().loginPage("/login").permitAll()
////                .and()
////                .logout()
////                .invalidateHttpSession(true)
////                .clearAuthentication(true)
////                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                .logoutSuccessUrl("/login?logout").permitAll();
////        // Son olarak, HttpSecurity nesnesini SecurityFilterChain olarak döndürün
////        return http.build();
////    }
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        // Burada HttpSecurity nesnesini kullanarak web güvenliği kurallarını belirleyebilirsiniz
////        http.authorizeRequests()
////                // antMatchers() yerine pathMatchers() kullanın
////                .createMvcMatchers("/register/account", "/css/**", "/js/**", "/img/**").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .formLogin().loginPage("/login").permitAll()
////                .and()
////                .logout()
////                .invalidateHttpSession(true)
////                .clearAuthentication(true)
////                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                .logoutSuccessUrl("/login?logout").permitAll();
////        // Son olarak, HttpSecurity nesnesini SecurityFilterChain olarak döndürün
////        return http.build();
////    }
//
////    @Override
////        protected void configure(HttpSecurity http)throws Exception{
////
////            http.authorizeRequests()
////                    .antMatchers("/register/account", "/css/**", "/js/**", "/img/**").permitAll()
////                    .anyRequest().authenticated()
////                    .and()
////                    .formLogin().loginPage("/login").permitAll()
////                    .and()
////                    .logout()
////                    .invalidateHttpSession(true)
////                    .clearAuthentication(true)
////                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                    .logoutSuccessUrl("/login?logout").permitAll();
////        }
//}

package com.ProjectEM.EMS.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        // Create users with roles
        manager.createUser(User.withUsername("empadmin")
                .password(passwordEncoder().encode("exam#123"))
                .roles("ADMIN")
                .build());

        manager.createUser(User.withUsername("emp001")
                .password(passwordEncoder().encode("emppw#123"))
                .roles("USER")
                .build());

        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}





//package com.ProjectEM.EMS.configuration;
//
//import com.ProjectEM.EMS.entity.Role;
//import com.ProjectEM.EMS.repository.RoleRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class DataInitializer {
//
//    private final RoleRepository roleRepository;
//
//    public DataInitializer(RoleRepository roleRepository) {
//        this.roleRepository = roleRepository;
//    }
//
//    @Bean
//    public CommandLineRunner initRoles(){
//        return args -> {
//            if(roleRepository.findByName("ROLE_ADMIN").isEmpty()){
//                roleRepository.save(new Role("ROLE_ADMIN"));
//            }
//            if(roleRepository.findByName("ROLE_USER").isEmpty()){
//                roleRepository.save(new Role("ROLE_USER"));
//            }
//
//        };
//    }
//}

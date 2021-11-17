package com.progmatic.homework.Homework2.configTests;

import com.progmatic.homework.Homework2.models.ProfileType;
import com.progmatic.homework.Homework2.models.UserAuthority;
import com.progmatic.homework.Homework2.models.UserProfile;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@TestConfiguration
public class WebConfigTests {

    @Bean
    @Primary
    public UserDetailsService userDetailsSerivice() {
        UserProfile user = createUser("anita", "kjjlj", ProfileType.user );
        return new InMemoryUserDetailsManager(user);
    }

    private UserProfile createUser (String userName, String password, ProfileType profileType) {
        UserProfile user = new UserProfile();
        user.setUsername("anita");
        user.setUserPassword("kjjlj");
        user.setProfileType(ProfileType.user);

        return user;
    }
}

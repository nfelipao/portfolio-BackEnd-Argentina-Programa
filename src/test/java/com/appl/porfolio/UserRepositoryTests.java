package com.appl.porfolio;

import com.appl.porfolio.models.User;
import com.appl.porfolio.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    UserRepo repo;

    @Test
    public void testCreateUser(){
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String rawPassword= "qwe789asd456zxc123";
        String encodePassword=passwordEncoder.encode(rawPassword);
        User newUser=new User("user@gmail.com", encodePassword);
        User savedUser=repo.save(newUser);
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }
}

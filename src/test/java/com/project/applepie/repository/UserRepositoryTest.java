package com.project.applepie.repository;

import static  org.assertj.core.api.Assertions.assertThat;

import com.project.applepie.repository.UserRepository;
import com.project.applepie.model.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        Users user = new Users();
        user.setEmail("chatona@gmail.fr");
        user.setPassword("bobh");
        user.setFirstname("Jakop");
        user.setLastname("Azamira");
        Users savedUser = repo.save(user);
        Users existUser = entityManager.find(Users.class, savedUser.getId());
        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());

    }

    @Test
    public void testFindUser(){
        String email = "calebyambu@huuii.fr";
        Users user = repo.findByEmail(email);
        assertThat(user).isNotNull();
    }
}

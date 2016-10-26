package me.jpomykala.spring.demo;

import me.jpomykala.spring.demo.model.User;
import me.jpomykala.spring.demo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Evelan on 23/10/2016.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;
    @Test
    public void whenPersistUser_thenReturnSameUser() {
        entityManager.persist(new User("Jakub", 23));
        User user = repository.findByName("Jakub");
        assertThat(user.getName()).isEqualTo("Jakub");
    }
}


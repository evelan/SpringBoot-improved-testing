package me.jpomykala.spring.demo;

import me.jpomykala.spring.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Evelan on 23/10/2016.
 */
@RunWith(SpringRunner.class)
@JsonTest
public class UserJsonTest {

    private JacksonTester<User> json;

    @Test
    public void serializeUser() throws Exception {
        User user = new User("Jakub", 23);
        assertThat(json.write(user))
                .extractingJsonPathStringValue("@.name")
                .isEqualTo("Jakub");

        assertThat(json.write(user))
                .extractingJsonPathStringValue("@.age")
                .isEqualTo("23");
    }


}

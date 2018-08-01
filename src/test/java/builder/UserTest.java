package builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Michał Gębarowski on 1/08/2018
 */
public class UserTest {

    private User user;

    @Test
    public void createAll() {
        user = new User.UserBuilder("Michal", "Gebarowski")
                .setAddress("Coronet House")
                .setAge(20)
                .setPhone("3452342342")
                .build();
        assertAll(
                () -> assertEquals("Michal", user.getFirstName()),
                () -> assertEquals("Gebarowski", user.getLastName()),
                () -> assertEquals("Coronet House", user.getAddresss()),
                () -> assertEquals(20, user.getAge()),
                () -> assertEquals("3452342342", user.getPhone())
        );
    }

    @Test
    public void createFinal() {
        user = new User.UserBuilder("Michal", "Gebarowski").build();
        assertAll(
                () -> assertEquals("Michal", user.getFirstName()),
                () -> assertEquals("Gebarowski", user.getLastName()),
                () -> assertEquals(null, user.getAddresss()),
                () -> assertEquals(0, user.getAge()),
                () -> assertEquals(null, user.getPhone())
        );
    }

    @Test
    public void setNegativeAge() {

    }

    @Test
    public void setAgeAboveLimit() {

    }
}
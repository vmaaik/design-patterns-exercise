package builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Michał Gębarowski on 1/08/2018
 */
public class UserTest {

    private User user;

    @Test
    public void testCreateAll() {
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
    public void testMissingFirstName() {
        assertThrows(NullPointerException.class, () -> new User.UserBuilder(null, "Gebarowski").build());
    }

    @Test
    public void testMissingLastName() {
        assertThrows(NullPointerException.class, () -> new User.UserBuilder("Michal", null).build());
    }

    @Test
    public void testNegativeAge() {
        assertThrows(IllegalArgumentException.class, () -> new User.UserBuilder("Michal", "Gebarowski").setAge(-1).build());
    }

    @Test
    public void testAgeAboveLimit() {
        assertThrows(IllegalArgumentException.class, () -> new User.UserBuilder("Michal", "Gebarowski").setAge(120).build());
    }
}
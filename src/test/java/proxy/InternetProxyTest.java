package proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by Michał Gębarowski on 05/04/2018
 */
class InternetProxyTest {
    private Internet internet;

    @BeforeEach
    public void before() {
        internet = new InternetProxy();
    }

    @Test
    public void connectToHost() throws Exception {
        assertEquals(internet.connectTo("instagram.com"), "Connected to instagram.com");
    }

    @Test
    public void connectToRestrictedHost() {
        assertThrows(IllegalArgumentException.class, () -> internet.connectTo("test.pl"));
    }

    @Test
    public void connectToNullHost() {
        assertThrows(IllegalArgumentException.class, () -> internet.connectTo(null));
    }

    @Test
    public void connectToEmptyHost() {
        assertThrows(IllegalArgumentException.class, () -> internet.connectTo(""));
    }


}
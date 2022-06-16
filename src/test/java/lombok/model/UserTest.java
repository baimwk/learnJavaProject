package lombok.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void getUserId() {
        User user = new User("rte", "ddsfs@test.tt");
        assertEquals("rte", user.getUserId());
    }

    @Test
    void assertUsersEquals() {
        User user1 = new User("werwerwe", "ddeesfs@test.tt");
        User user2 = new User("333", "ddeesfs@test.tt");
        user2.setUserId("werwerwe");
        assertTrue(user2.equals(user1));
        assertEquals(user2.hashCode(), user1.hashCode());
    }
}
package ar.fiuba.tdd.tp2.acceptance;

import ar.fiuba.tdd.tp2.Supervisor;
import ar.fiuba.tdd.tp2.User;
import ar.fiuba.tdd.tp2.Users;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

public class UsersListTest {
    private Users users;

    @Before
    public void setUp() throws IOException, ParseException {
        this.users = new Users("users.json");
    }

    @After
    public void tearDown() {
    }

    @Test(expected = ar.fiuba.tdd.tp2.UserDoesNotExist.class)
    public void notExistanceUserShouldRaiseException() {
        this.users.get("doesNotExists");
    }

    @Test
    public void getExistingUser () {
        JSONObject user = this.users.get("supervisor");
        assertTrue("Failed", user.get("username").equals("supervisor"));
    }

    @Test
    public void getExistingUserClass () {
        User user = this.users.getUser("supervisor", "123456");
        assertTrue("Failed", user.getUsername().equals("supervisor"));
    }
}

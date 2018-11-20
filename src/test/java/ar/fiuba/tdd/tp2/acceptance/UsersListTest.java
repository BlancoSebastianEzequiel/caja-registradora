package ar.fiuba.tdd.tp2.acceptance;

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
        this.users.get("doesNotExists", "123456");
    }

    @Test
    public void getExistingUser () {
        JSONObject user = this.users.get("supervisor", "123456");
        assertTrue("Failed", user.get("username").equals("supervisor"));
    }
}

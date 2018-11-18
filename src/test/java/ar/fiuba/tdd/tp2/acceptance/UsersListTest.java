package ar.fiuba.tdd.tp2.acceptance;

import ar.fiuba.tdd.tp2.Users;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
}

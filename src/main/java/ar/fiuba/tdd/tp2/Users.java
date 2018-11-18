package ar.fiuba.tdd.tp2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class Users extends JsonConverter {

    public Users(String JsonFileName) throws IOException, ParseException {
        super(JsonFileName);
    }

    public JSONObject get(String username) {
        JSONArray users = ((JSONArray) this.obj);
        for (Object anUser : users) {
            JSONObject user = (JSONObject) anUser;
            if (username.equals(user.get(username))) {  // castear!
                return user;
            }
        }
        throw new UserDoesNotExist();
    }

    public User getUser(String username, String password) {
        JSONObject user = this.get(username);
        if (user.get("role").equals("cashier")) {
            return new User(username, password, new Cashier());
        } else {
            return new User(username, password, new Supervisor());
        }
    }
}

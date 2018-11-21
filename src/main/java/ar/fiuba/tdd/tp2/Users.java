package ar.fiuba.tdd.tp2;

import ar.fiuba.tdd.tp2.exceptions.UserDoesNotExist;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class Users extends JsonConverter {

    public Users(String JsonFileName) throws IOException, ParseException {
        super(JsonFileName);
    }

    private String getPassword(JSONObject user) {
        return (String) user.get("hashed_password");
    }

    public JSONObject get(String username, String password) {
        JSONArray users = (JSONArray) this.obj;
        for (Object anUser : users) {
            JSONObject user = (JSONObject) anUser;
            String pass = this.getPassword(user);
            if (username.equals(user.get("username")) && password.equals(pass)) {
                return user;
            }
        }
        throw new UserDoesNotExist();
    }

    User getUser(String username, String password) {
        JSONObject user = this.get(username, password);
        if (user.get("role").equals("cashier")) {
            return new User(username, password, new Cashier());
        } else {
            return new User(username, password, new Supervisor());
        }
    }
}

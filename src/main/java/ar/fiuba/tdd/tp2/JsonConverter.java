package ar.fiuba.tdd.tp2;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class JsonConverter {
    private JSONParser parser;
    protected Object obj;

    public JsonConverter(String JsonFileName) throws IOException, ParseException {
        this.parser = new JSONParser();
        this.obj = parser.parse(new FileReader(JsonFileName));
    }

    public String stringify() {
        return this.obj.toString();
    }
}

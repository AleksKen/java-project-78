package hexlet.code;

import hexlet.code.Schems.NumberSchema;
import hexlet.code.Schems.StringSchema;

public class Validator {
    public Validator() {
    }

    public StringSchema string() {
        return new StringSchema();
    }

    public NumberSchema number() {
        return new NumberSchema();
    }
}

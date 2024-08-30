package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        Predicate<String> lambda = x -> x != null && !x.isEmpty();
        checks.put("required", lambda);
        return this;
    }

    public StringSchema minLength(int length) {
        Predicate<String> lambda = x -> x == null || x.length() >= length;
        checks.put("minLength", lambda);
        return this;
    }

    public StringSchema contains(String subStr) {
        Predicate<String> lambda = x -> x == null || x.contains(subStr);
        checks.put("contains", lambda);
        return this;
    }
}

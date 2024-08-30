package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        Predicate<Integer> lambda = Objects::nonNull;
        checks.put("required", lambda);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> lambda = x -> x == null || x > 0;
        checks.put("positive", lambda);
        return this;
    }

    public NumberSchema range(int left, int right) {
        Predicate<Integer> lambda = x -> x >= left && x <= right;
        checks.put("range", lambda);
        return this;
    }
}

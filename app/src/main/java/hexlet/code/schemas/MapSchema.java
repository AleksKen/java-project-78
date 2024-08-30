package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema required() {
        Predicate<Map> lambda = Objects::nonNull;
        checks.put("required", lambda);
        return this;
    }

    public MapSchema sizeof(int size) {
        Predicate<Map> lambda = x -> x.size() == size;
        checks.put("sizeof", lambda);
        return this;
    }
}

package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema<T> extends BaseSchema<Map> {

    public MapSchema<T> required() {
        Predicate<Map> lambda = Objects::nonNull;
        checks.put("required", lambda);
        return this;
    }

    public MapSchema<T> sizeof(int size) {
        Predicate<Map> lambda = x -> x.size() == size;
        checks.put("sizeof", lambda);
        return this;
    }

    public <V> MapSchema<T> shape(Map<T, BaseSchema<V>> schemas) {
        Predicate<Map> lambda = x -> {
            for (var key : schemas.keySet()) {
                if (!schemas.get(key).isValid((V) x.get(key))) {
                    return false;
                }
            }
            return true;
        };
        checks.put("shape", lambda);
        return this;
    }
}

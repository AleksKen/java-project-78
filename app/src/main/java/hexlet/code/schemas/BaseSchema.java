package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    public boolean isValid(T data) {
        if (checks.isEmpty()) {
            return true;
        }

        for (var lambda : checks.values()) {
            if (!lambda.test(data)) {
                return false;
            }
        }
        return true;
    }
}

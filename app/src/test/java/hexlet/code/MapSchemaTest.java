package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {
    @Test
    public void testCore() {
        var v = new Validator();
        var schema = v.map();

        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));

        schema.sizeof(2);

        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));

        var schema1 = v.map();

        assertTrue(schema1.sizeof(5).sizeof(2).isValid(data));
    }

    @Test
    public void testNestedStr() {
        var v = new Validator();
        var schema = v.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));
        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(schema.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(schema.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertFalse(schema.isValid(human3));
    }

    @Test
    public void testNestedInt() {
        var v = new Validator();
        var schema = v.map();
        Map<Integer, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put(7, v.number().required());
        schemas.put(3, v.number().required().positive());
        schema.shape(schemas);

        Map<Integer, Integer> nums1 = new HashMap<>();
        nums1.put(7, -1);
        nums1.put(3, 2);
        assertTrue(schema.isValid(nums1));

        Map<Integer, Integer> nums2 = new HashMap<>();
        nums2.put(7, null);
        nums2.put(3, 2);
        assertFalse(schema.isValid(nums2));

        Map<Integer, Integer> nums3 = new HashMap<>();
        nums3.put(7, 0);
        nums3.put(3, 0);
        assertFalse(schema.isValid(nums3));
    }

    @Test
    public void testNestedStrAndInt() {
        var v = new Validator();
        var schema = v.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("age", v.number().required().range(18, 25));
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("age", 19);
        assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("age", null);
        assertFalse(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("firstName", null);
        human3.put("age", 20);
        assertFalse(schema.isValid(human3));
    }
}

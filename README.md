# Валидатор на Java

### Hexlet tests and linter status:
[![Actions Status](https://github.com/AleksKen/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/AleksKen/java-project-78/actions)
[![Java CI](https://github.com/AleksKen/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/AleksKen/java-project-78/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/91cf5ce7212a56b79ec7/maintainability)](https://codeclimate.com/github/AleksKen/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/91cf5ce7212a56b79ec7/test_coverage)](https://codeclimate.com/github/AleksKen/java-project-78/test_coverage)

Эта библиотека предоставляет гибкий и настраиваемый механизм валидации данных в Java. Основная цель — упростить процесс проверки входных данных в приложениях, обеспечивая лёгкий способ задания правил и схем валидации.

### Основные возможности:
1. Валидация строковых данных (StringSchema):
- Обязательное наличие: Проверка, что строка не null и не пустая.
- Минимальная длина: Возможность задать минимальную длину строки.
- Содержимое: Проверка на наличие подстроки в строке.
2. Валидация числовых данных (NumberSchema):
- Обязательное наличие: Проверка, что число не null.
- Положительное значение: Проверка, что число положительное.
- Диапазон: Задание диапазона допустимых значений для чисел.
3. Композиция схем валидации (MapSchema):
- Настраивайте валидацию для объектов Map, задавая индивидуальные схемы для каждого ключа.


### Пример использования:
#### Валидация строки:

```java
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;

var v = new Validator();
var stringSchema = v.string();
stringSchema.required().minLength(5).contains("world");

System.out.println(stringSchema.isValid("Hello world")); // true
System.out.println(stringSchema.isValid("Hi")); // false
```

#### Валидация числа:

```java
import hexlet.code.Validator;
import hexlet.code.schemas.NumberSchema;

var v = new Validator();
var numberSchema = v.number();
numberSchema.required().positive().range(10, 100);

System.out.println(numberSchema.isValid(50)); // true
System.out.println(numberSchema.isValid(-5)); // false
System.out.println(numberSchema.isValid(150)); // false
```

#### Вложенная валидация:

```java
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;
import java.util.HashMap;
import java.util.Map;

var v = new Validator();
var schema = v.map();
Map<String, BaseSchema<String>> schemas = new HashMap<>();
schemas.put("firstName", v.string().required());
schemas.put("lastName", v.string().required().minLength(2));
schema.shape(schemas);

Map<String, String> human = new HashMap<>();
human.put("firstName", "John");
human.put("lastName", "Smith");
System.out.println(schema.isValid(human)); // true

human.put("lastName", null);
System.out.println(schema.isValid(human)); // false
```




package hexlet.code.Schems;

public class BaseSchema<T> {
    private boolean flagRequired = false;

    public BaseSchema<T> required() {
        this.flagRequired = true;
        return this;
    }

    private boolean checkRequired(T data) {
        return !flagRequired || (data != null && !data.equals(""));
    }

    public boolean isValid(T data) {
        return checkRequired(data);
    }
}

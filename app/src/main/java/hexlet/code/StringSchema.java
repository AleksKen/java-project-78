package hexlet.code;

public class StringSchema {
    private boolean flagRequired = false;
    private int flagMinLength;
    private String flagContains;

    public StringSchema() {
    }

    public StringSchema required() {
        this.flagRequired = true;
        return this;
    }

    public StringSchema minLength(int length) {
        this.flagMinLength = length;
        return this;
    }

    public StringSchema contains(String subStr) {
        this.flagContains = subStr;
        return this;
    }

    public boolean isValid(String data) {
        if (flagRequired && (data == null || data.isEmpty())) {
            return false;
        }
        if (data != null && flagMinLength > data.length()) {
            return false;
        }
        if (flagContains != null && !data.contains(flagContains)) {
            return false;
        }
        return true;
    }
}

package hexlet.code.Schems;

public class StringSchema extends BaseSchema {
    private int flagMinLength;
    private String flagContains;

    public StringSchema() {
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
        if (!super.isValid(data)) {
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

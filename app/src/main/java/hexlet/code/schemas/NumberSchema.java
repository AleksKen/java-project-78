package hexlet.code.schemas;

import org.apache.commons.lang3.tuple.Pair;

public class NumberSchema extends BaseSchema {
    private boolean flagPositive = false;
    private Pair<Integer, Integer> flagRange = Pair.of(null, null);

    public NumberSchema() {
    }

    public NumberSchema positive() {
        this.flagPositive = true;
        return this;
    }

    public NumberSchema range(int left, int right) {
        flagRange = Pair.of(left, right);
        return this;
    }

    public boolean isValid(Integer data) {
        if (!super.isValid(data)) {
            return false;
        }
        if (flagPositive && data != null && data <= 0) {
            return false;
        }
        return flagRange.getLeft() == null || (flagRange.getLeft() <= data && flagRange.getRight() >= data);
    }
}

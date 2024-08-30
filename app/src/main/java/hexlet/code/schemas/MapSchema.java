package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    private int flagSize = -1;

    public MapSchema() {
    }

    public MapSchema sizeof(int size) {
        this.flagSize = size;
        return this;
    }

    public boolean isValid(Map data) {
        if (!super.isValid(data)) {
            return false;
        }
        return flagSize == -1 || data.size() == flagSize;
    }
}

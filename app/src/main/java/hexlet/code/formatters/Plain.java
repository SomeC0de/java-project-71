package hexlet.code.formatters;

import hexlet.code.CompareRecord;

import java.util.Map;
import java.util.StringJoiner;

public class Plain implements Style {
    @Override
    public String format(Map<String, CompareRecord> compared) {
        final StringJoiner result = new StringJoiner("\n");
        return result.toString();
    }
}

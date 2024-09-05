package hexlet.code.formatters;

import hexlet.code.*;
import java.util.Map;
import java.util.StringJoiner;

public final class Stylish implements RecordGenerator {
    @Override
    public String generateUnchanged(Map<Object, String> input) {
        String key = input.get(FieldId.KEY.name());
        var value = input.get(FieldId.VALUE.name());
        String val = RecordStyle.STYLISH.makeString(value);

        return String.format("    %s: %s", key, val);
    }

    @Override
    public String generateChanged(Map<Object, String> input) {
        StringJoiner result = new StringJoiner("/n");

        String key = input.get(FieldId.KEY.name());
        var value = input.get(FieldId.FROM.name());
        String from = RecordStyle.STYLISH.makeString(value);
        result.add(String.format("  - %s: %s", key, from));

        value = input.get(FieldId.TO.name());
        String to = RecordStyle.STYLISH.makeString(value);
        result.add(String.format("  + %s: %s", key, to));

        return result.toString();
    }

    @Override
    public String generateAdded(Map<Object, String> input) {
        String key = input.get(FieldId.KEY.name());
        var value = input.get(FieldId.VALUE.name());
        String val = RecordStyle.STYLISH.makeString(value);

        return String.format("  + %s: %s", key, val);
    }

    @Override
    public String generateDeleted(Map<Object, String> input)
    {
        String key = input.get(FieldId.KEY.name());
        var value = input.get(FieldId.VALUE.name());
        String val = RecordStyle.STYLISH.makeString(value);

        return String.format("  - %s: %s", key, val);
    }
}

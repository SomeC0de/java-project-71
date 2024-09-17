package hexlet.code.formatters;

import hexlet.code.RecordStatus;
import hexlet.code.builders.CommonBuilder;
import hexlet.code.builders.RecordMaker;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import static hexlet.code.Comparator.KEY_ID_KEY;
import static hexlet.code.Comparator.KEY_ID_VALUE;
import static hexlet.code.Comparator.KEY_ID_FROM;
import static hexlet.code.Comparator.KEY_ID_TO;

public final class Stylish implements Style {
    @Override
    public String apply(List<Map<String, Object>> compared) {
        return CommonBuilder.build(compared, builders);
    }

    private String makeString(Object obj) {
        if (null == obj) {
            return "null";
        } else {
            return String.format("%s", obj);
        }
    }

    String buildUnchanged(Map<String, Object> record) {
        String key = record.get(KEY_ID_KEY).toString();
        String val = makeString(record.get(KEY_ID_VALUE));

        return String.format("    %s: %s", key, val);
    }

    String buildChanged(Map<String, Object> record) {
        StringJoiner result = new StringJoiner("\n");

        String key = record.get(KEY_ID_KEY).toString();
        String from = makeString(record.get(KEY_ID_FROM));
        String to = makeString(record.get(KEY_ID_TO));
        result.add(String.format("  - %s: %s", key, from));
        result.add(String.format("  + %s: %s", key, to));

        return result.toString();
    }

    String buildAdded(Map<String, Object> record) {
        String key = record.get(KEY_ID_KEY).toString();
        String val = makeString(record.get(KEY_ID_VALUE));

        return String.format("  + %s: %s", key, val);
    }

    String buildDeleted(Map<String, Object> record) {
        String key = record.get(KEY_ID_KEY).toString();
        String val = makeString(record.get(KEY_ID_VALUE));

        return String.format("  - %s: %s", key, val);
    }

    public RecordMaker[] builders = new RecordMaker[RecordStatus.LIMIT.ordinal()];

    public Stylish() {
        builders[RecordStatus.UNCHANGED.ordinal()] = this::buildUnchanged;
        builders[RecordStatus.CHANGED.ordinal()] = this::buildChanged;
        builders[RecordStatus.ADDED.ordinal()] = this::buildAdded;
        builders[RecordStatus.DELETED.ordinal()] = this::buildDeleted;
    }
}

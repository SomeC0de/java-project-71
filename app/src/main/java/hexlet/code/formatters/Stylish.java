package hexlet.code.formatters;

import hexlet.code.FieldId;
import hexlet.code.Parser;
import hexlet.code.RecordStatus;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import static hexlet.code.Comparator.STATUS_UNCHANGED;
import static hexlet.code.Comparator.STATUS_CHANGED;
import static hexlet.code.Comparator.STATUS_ADDED;
import static hexlet.code.Comparator.STATUS_DELETED;

import static hexlet.code.Comparator.KEY_ID_KEY;
import static hexlet.code.Comparator.KEY_ID_STATE;
import static hexlet.code.Comparator.KEY_ID_VALUE;
import static hexlet.code.Comparator.KEY_ID_FROM;
import static hexlet.code.Comparator.KEY_ID_TO;

public final class Stylish implements Style {
    @Override
    public String format(List<Map<String, Object>> compared) {
        final StringJoiner result = new StringJoiner("\n", "{\n", "\n}");

        compared.forEach(value -> {
            String key = value.get(FieldId.KEY.name()).toString();
            String state = value.get(FieldId.STATE.name()).toString();

            return Arrays.stream(RecordStatus.values())
                    .filter(e -> e.name().equals(state))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException(String.format("Unknown record status %s.", state)))
                    .parse(content);

            switch (state) {
                case RecordStatus.UNCHANGED.name() -> {
                    String val = makeString(value.get(KEY_ID_VALUE));
                    result.add(String.format("    %s: %s", key, val));
                }
                case STATUS_CHANGED -> {
                    String from = makeString(value.get(KEY_ID_FROM));
                    String to = makeString(value.get(KEY_ID_TO));
                    result.add(String.format("  - %s: %s", key, from));
                    result.add(String.format("  + %s: %s", key, to));
                }
                case STATUS_ADDED -> {
                    String val = makeString(value.get(KEY_ID_VALUE));
                    result.add(String.format("  + %s: %s", key, val));
                }
                case STATUS_DELETED -> {
                    String val = makeString(value.get(KEY_ID_VALUE));
                    result.add(String.format("  - %s: %s", key, val));
                }
                default -> throw new RuntimeException("Unknown record state!");
            }
        });

        return result.toString();
    }

    private static String makeString(Object obj) {
        if (null == obj) {
            return "null";
        } else {
            return String.format("%s", obj);
        }
    }
}

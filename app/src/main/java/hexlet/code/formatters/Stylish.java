package hexlet.code.formatters;

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
    public String apply(List<Map<String, Object>> compared) {
        final StringJoiner result = new StringJoiner("\n", "{\n", "\n}");

        compared.forEach(value -> {
            String key = value.get(KEY_ID_KEY).toString();
            String state = value.get(KEY_ID_STATE).toString();

            switch (state) {
                case STATUS_UNCHANGED -> {
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

package hexlet.code.formatters;

import hexlet.code.CompareRecord;

import java.util.Map;
import java.util.StringJoiner;

public final class Stylish implements Style {
    @Override
    public String format(Map<String, CompareRecord> compared) {
        final StringJoiner result = new StringJoiner("\n", "{\n", "\n}");

        compared.forEach((key, value) -> {
            switch (value.getEntityState()) {
                case NOT_CHANGED -> result.add(String.format("    %s: %s", key, value.getValueFrom()));
                case CHANGED -> {
                    result.add(String.format("  - %s: %s", key, value.getValueFrom()));
                    result.add(String.format("  + %s: %s", key, value.getValueTo()));
                }
                case ADDED -> result.add(String.format("  + %s: %s", key, value.getValueTo()));
                case REMOVED -> result.add(String.format("  - %s: %s", key, value.getValueFrom()));
                default -> throw new RuntimeException("Unknown record state!");
            }
        });

        return result.toString();
    }
}

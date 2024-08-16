package hexlet.code;

import java.util.Map;
import java.util.StringJoiner;

enum EntityState {
    NOT_CHANGED {
        public String buildReport(String key, Object valueFrom, Object valueTo) {
            return String.format("    %s: %s", key, valueFrom);
        }
    },
    CHANGED {
        public String buildReport(String key, Object valueFrom, Object valueTo) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("  - %s: %s\n", key, valueFrom));
            sb.append(String.format("  + %s: %s", key, valueTo));

            return sb.toString();
        }
    },
    REMOVED {
        public String buildReport(String key, Object valueFrom, Object valueTo) {
            return String.format("  - %s: %s", key, valueFrom);
        }
    },
    ADDED {
        public String buildReport(String key, Object valueFrom, Object valueTo) {
            return String.format("  + %s: %s", key, valueTo);
        }
    };

    public abstract String buildReport(String key, Object valueFrom, Object valueTo);
}

public class StylishFormatter {
    public static String format(Map<String, CompareEntity> compared) {
        final StringJoiner result = new StringJoiner("\n", "{\n", "\n}");

        compared.forEach((key, value) -> {
            switch (value.getEntityState()) {
                case NOT_CHANGED ->
                        result.add(EntityState.NOT_CHANGED.buildReport(key, value.getValueFrom(), value.getValueTo()));
                case CHANGED ->
                        result.add(EntityState.CHANGED.buildReport(key, value.getValueFrom(), value.getValueTo()));
                case ADDED ->
                        result.add(EntityState.ADDED.buildReport(key, value.getValueFrom(), value.getValueTo()));
                case REMOVED ->
                        result.add(EntityState.REMOVED.buildReport(key, value.getValueFrom(), value.getValueTo()));
                default -> throw new RuntimeException("Unknown record state!");
            }
        });

        return result.toString();
    }
}

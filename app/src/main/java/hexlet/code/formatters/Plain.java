package hexlet.code.formatters;

import hexlet.code.CompareRecord;
import org.apache.commons.lang3.ClassUtils;

import java.util.Map;
import java.util.StringJoiner;

public class Plain implements Style {
    @Override
    public String format(Map<String, CompareRecord> compared) {
        final StringJoiner result = new StringJoiner("\n");

        compared.forEach((key, value) -> {
            String objFromVal = calcReport(value.getValueFrom());
            String objToVal = calcReport(value.getValueTo());

            switch (value.getEntityState()) {
                case NOT_CHANGED -> {
                }
                case CHANGED -> {
                    result.add(String.format("Property '%s' was updated. From %s to %s", key, objFromVal, objToVal));
                }
                case ADDED -> result.add(String.format("Property '%s' was added with value: %s", key, objToVal));
                case REMOVED -> result.add(String.format("Property '%s' was removed", key));
                default -> throw new RuntimeException("Unknown record state!");
            }
        });

        return result.toString();
    }

    private static String calcReport(Object obj) {
        if (null == obj) {
            return "null";
        }

        if (obj instanceof String) {
            return String.format("'%s'", obj);
        }

        if (ClassUtils.isPrimitiveOrWrapper(obj.getClass())) {
            return obj.toString();
        } else {
            return "[complex value]";
        }
    }
}

package hexlet.code.formatters;

import org.apache.commons.lang3.ClassUtils;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Plain implements Style {
    @Override
    public String format(List<Map<String, Object>> compared) {
        final StringJoiner result = new StringJoiner("\n");

        compared.forEach(value -> {
            String key = value.get("key").toString();
            String state = value.get("state").toString();

            switch (state) {
                case "unchanged" -> {
                }
                case "changed" -> {
                    String from = makeString(value.get("from"));
                    String to = makeString(value.get("to"));
                    result.add(String.format("Property '%s' was updated. From %s to %s", key, from, to));
                }
                case "added" -> {
                    String val = makeString(value.get("value"));
                    result.add(String.format("Property '%s' was added with value: %s", key, val));
                }
                case "deleted" -> {
                    result.add(String.format("Property '%s' was removed", key));
                }
                default -> throw new RuntimeException("Unknown record state!");
            }
        });

        return result.toString();
    }

    private static String makeString(Object obj) {
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

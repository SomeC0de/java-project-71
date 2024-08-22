package hexlet.code.formatters;

import org.apache.commons.lang3.ClassUtils;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import static hexlet.code.RecordStatus.*;

public class Stylish implements Style {
    @Override
    public String format(List<Map<String, Object>> compared) {
        final StringJoiner result = new StringJoiner("\n", "{\n", "\n}");

        compared.forEach(value -> {
            String key = value.get("key").toString();
            String state = value.get("state").toString();

            switch (state) {
                case "unchanged" ->{
                    String val = makeString(value.get("value"));
                    result.add(String.format("    %s: %s", key, val));
                }
                case "changed" -> {
                    String from = makeString(value.get("from"));
                    String to = makeString(value.get("to"));
                    result.add(String.format("  - %s: %s", key, from));
                    result.add(String.format("  + %s: %s", key, to));
                }
                case "added" -> {
                    String val = makeString(value.get("value"));
                    result.add(String.format("  + %s: %s", key, val));
                }
                case "deleted" -> {
                    String val = makeString(value.get("value"));
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

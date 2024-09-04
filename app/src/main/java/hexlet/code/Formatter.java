package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import static hexlet.code.Comparator.*;
import static hexlet.code.RecordStatus.UNCHANGED;

public class Formatter {
    public static String formatWithEnum(List<Map<String, Object>> compareResult, String style) {
        final StringJoiner result = new StringJoiner("\n", "{\n", "\n}");

        compareResult.forEach(value -> {
            var state = value.get(FieldId.STATE.name());
            String s = Arrays.stream(RecordStatus.values())
                    .filter(e -> e.name().equals(state))
                    .findFirst()
                    .orElseThrow(() ->
                            new IllegalStateException(String.format("Unknown record state %s.", state.toString())))
                    .buildJson();

            result.add(s);
        });

        return result.toString();
    }

    public static String formatWith(List<Map<String, Object>> compareResult, String style) {
        return switch (style) {
            case "stylish" -> new Stylish().format(compareResult);
            case "plain" -> new Plain().format(compareResult);
            case "json" -> new Json().format(compareResult);
            default -> throw new RuntimeException("Unsupported style type!");
        };
    }
}

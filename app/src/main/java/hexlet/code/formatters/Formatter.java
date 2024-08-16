package hexlet.code.formatters;

import hexlet.code.CompareRecord;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String formatWith(Map<String, CompareRecord> compareResult, String style) {
        return switch (style) {
            case "stylish" -> new Stylish.format(compareResult);
            default -> throw new RuntimeException("Unsupported style type!");
        };
    }
}

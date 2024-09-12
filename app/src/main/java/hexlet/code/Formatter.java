package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Style;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatWith(List<Map<String, Object>> compareResult, Style formater) {
        // TBD: add here exception for non-null formatter value; possibly replace here formatter extraction
        return formater.apply(compareResult);
    }
}

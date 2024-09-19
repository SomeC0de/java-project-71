package hexlet.code;

import hexlet.code.formatters.*;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatWith(List<Map<String, Object>> compareResult, String format) {
        return RecordStyle.getFormatter(format).apply(compareResult);
    }
}

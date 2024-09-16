package hexlet.code.builders;

import hexlet.code.formatters.RecordStatus;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import static hexlet.code.Comparator.*;

public class Common {
    public static String build(List<Map<String, Object>> records, RecordMaker[] generators) {
        final StringJoiner result = new StringJoiner("\n", "{\n", "\n}");

        records.forEach(value -> {
            String status = value.get(KEY_ID_STATE).toString().toUpperCase();
            String s = generators[RecordStatus.valueOf(status).ordinal()].generate(value);
            result.add(s);
        });

        return result.toString();
    }
}

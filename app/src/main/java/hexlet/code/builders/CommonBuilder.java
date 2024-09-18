package hexlet.code.builders;

import hexlet.code.RecordStatus;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import static hexlet.code.Comparator.*;

public class CommonBuilder {
    public static String build(List<Map<String, Object>> records, RecordMaker[] generators, StringJoiner template) {
        final StringJoiner result = template;

        records.forEach(value -> {
            RecordStatus status = (RecordStatus) value.get(KEY_ID_STATE);
            String s = generators[status.ordinal()].generate(value);
            if (!s.equals("")) {
                result.add(s);
            }
        });

        return result.toString();
    }
}

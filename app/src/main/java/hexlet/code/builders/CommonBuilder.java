package hexlet.code.builders;

import hexlet.code.RecordKey;
import hexlet.code.RecordStatus;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class CommonBuilder {
    public static String build(List<Map<String, Object>> records, RecordMaker[] generators, StringJoiner template) {
        final StringJoiner result = template;

        records.forEach(value -> {
            String status = value.get(RecordKey.STATE.name()).toString();
            int generatorId = RecordStatus.valueOf(status).ordinal();
            String s = generators[generatorId].generate(value);
            if (!s.isEmpty()) { result.add(s); }
        });

        return result.toString();
    }
}

package hexlet.code.formatters.builders;

import hexlet.code.formatters.RecordStatus;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import static hexlet.code.Comparator.*;

public class Common {
    public String build(List<Map<String, Object>> records, Status builders) {
        final StringJoiner result = new StringJoiner("\n", "{\n", "\n}");

        records.forEach(value -> {
            String status = value.get(KEY_ID_STATE).toString();
            String s;

            switch (status) {
                case STATUS_UNCHANGED -> s = builders.buildUnchanged(value);
                case STATUS_CHANGED -> s = builders.buildChanged(value);
                case STATUS_ADDED -> s = builders.buildAdded(value);
                case STATUS_DELETED -> s = builders.buildDeleted(value);
                default -> throw new RuntimeException("Unknown record state!");
            }

            result.add(s);
        });

        return result.toString();
    }
}

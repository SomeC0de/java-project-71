package hexlet.code.formatters;

import hexlet.code.RecordKey;
import hexlet.code.RecordStatus;
import hexlet.code.builders.JsonBuilder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Json implements Style {
    @Override
    public String apply(List<Map<String, Object>> compared) {
        List<Map<String, Object>> normalized = compared.stream().map(element -> {
            Map<String, Object> lowercasedRecord = new LinkedHashMap<>();
            element.forEach((key, value) -> {
                if (key.equals(RecordKey.STATE.name())) {
                    lowercasedRecord.put(key.toLowerCase(), value.toString().toLowerCase());
                } else {
                    lowercasedRecord.put(key.toLowerCase(), value);
                }
            });
            return lowercasedRecord;
        }).toList();
        return JsonBuilder.build(normalized);
    }
}

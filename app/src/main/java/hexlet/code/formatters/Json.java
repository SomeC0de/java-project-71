package hexlet.code.formatters;

import hexlet.code.RecordKey;
import hexlet.code.builders.JsonBuilder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Json implements Style {
    @Override
    public String apply(List<Map<String, Object>> compared) {
        List<Map<String, Object>> prepared = compared.stream().map(element -> {
            Map<String, Object> record = new LinkedHashMap<>();
            element.forEach((key, value) -> {
                if (key.equals(RecordKey.STATE.name())) {
                    record.put(key.toLowerCase(), value.toString().toLowerCase());
                } else {
                    record.put(key.toLowerCase(), value);
                }
            });
            return record;
        }).toList();
        return JsonBuilder.build(prepared);
    }
}

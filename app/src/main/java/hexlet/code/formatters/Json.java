package hexlet.code.formatters;

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
                lowercasedRecord.put(key.toLowerCase(), value);
            });
            return null;
        }).toList();
        return JsonBuilder.build(normalized);
    }
}

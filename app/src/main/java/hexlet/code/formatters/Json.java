package hexlet.code.formatters;

import hexlet.code.builders.JsonBuilder;

import java.util.List;
import java.util.Map;

public final class Json implements Style {
    @Override
    public String apply(List<Map<String, Object>> compared) {
        return JsonBuilder.build(compared);
    }
}

package hexlet.code;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface RecordGenerator {
    String generate(List<Map<String, Object>> input, RecordStyle style);
}

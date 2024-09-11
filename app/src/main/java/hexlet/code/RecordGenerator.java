package hexlet.code;

import java.util.List;
import java.util.Map;
@FunctionalInterface
public interface RecordGenerator {
    String generateUnchanged(Map<String, Object> input);
}

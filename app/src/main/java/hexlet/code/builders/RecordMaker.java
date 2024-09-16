package hexlet.code.builders;

import java.util.Map;

@FunctionalInterface
public interface RecordMaker {
    String generate(Map<String, Object> record);
}

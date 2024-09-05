package hexlet.code;

import java.util.Map;

public interface RecordGenerator {
    public String generateUnchanged(Map<Object, String> input);
    public String generateChanged(Map<Object, String> input);
    public String generateAdded(Map<Object, String> input);
    public String generateDeleted(Map<Object, String> input);
}

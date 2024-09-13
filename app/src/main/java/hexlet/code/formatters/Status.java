package hexlet.code.formatters;

import java.util.Map;

public interface Status {
    String buildUnchanged(Map<String, Object> record);
    String buildChanged(Map<String, Object> record);
    String buildAdded(Map<String, Object> record);
    String buildDeleted(Map<String, Object> record);
}

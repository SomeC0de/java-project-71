package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface Style {
    String format(List<Map<String, Object>> compared);
}

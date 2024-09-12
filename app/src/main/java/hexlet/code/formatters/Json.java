package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public final class Json implements Style {
    @Override
    public String apply(List<Map<String, Object>> compared) {
        ObjectMapper om = new ObjectMapper();
        try {
            return om.writerWithDefaultPrettyPrinter().writeValueAsString(compared);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

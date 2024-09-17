package hexlet.code.builders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class JsonBuilder {
    public static String build(List<Map<String, Object>> records) {
        ObjectMapper om = new ObjectMapper();
        try {
            return om.writerWithDefaultPrettyPrinter().writeValueAsString(records);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class Decomposer {
    static final String FILETYPE_JSON = "json";
    public static Map<String, Object> parse(String content, String filetype) {
        // TBD: use external libraries for different formats
        switch (filetype.toLowerCase()) {
            default:
                throw new RuntimeException("Unknown filetype!");
            case FILETYPE_JSON:
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.readValue(content, new TypeReference<>() {
                    });
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
        }
    }
}

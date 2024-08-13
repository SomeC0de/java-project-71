package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class Decomposer {
    static final String FILETYPE_JSON = "json";
    public static Map<String, Object> parse(File content, String filetype) {
        Objects.requireNonNull(content);
        Objects.requireNonNull(filetype);

        ObjectMapper mapper;

        switch (filetype.toLowerCase()) {
            default -> throw new RuntimeException("Unknown filetype!");
            case FILETYPE_JSON -> {
                try {
                    mapper = new ObjectMapper();
                    Objects.requireNonNull(mapper);
                    return mapper.readValue(content, new TypeReference<>() { });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
                try {
                    throw new RuntimeException(e);
                }
        }
    }
}

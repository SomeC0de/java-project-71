package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class Decomposer {
    static final String FILETYPE_JSON = "json";
    static final String FILETYPE_YML = "yml";
    static final String FILETYPE_YAML = "yaml";
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
            case FILETYPE_YML, FILETYPE_YAML -> {
                try {
                    mapper = new YAMLMapper();
                    Objects.requireNonNull(mapper);
                    return mapper.readValue(content, new TypeReference<>() { });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

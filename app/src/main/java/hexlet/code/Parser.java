package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Arrays;

public class Parser {
    private enum Extensions {
        JSON {
            @Override
            public Map<String, Object> parse(File content) {
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    Objects.requireNonNull(mapper);
                    return mapper.readValue(content, new TypeReference<>() { });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        },
        YML {
            @Override
            public Map<String, Object> parse(File content) {
                try {
                    ObjectMapper mapper = new YAMLMapper();
                    Objects.requireNonNull(mapper);
                    return mapper.readValue(content, new TypeReference<>() { });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        },
        YAML {
            @Override
            public Map<String, Object> parse(File content) {
                try {
                    ObjectMapper mapper = new YAMLMapper();
                    Objects.requireNonNull(mapper);
                    return mapper.readValue(content, new TypeReference<>() { });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        public abstract Map<String, Object> parse(File content);
    }
    public static Map<String, Object> parse(File content, String filetype) {
        Objects.requireNonNull(content);
        Objects.requireNonNull(filetype);

        return Arrays.stream(Extensions.values())
                .filter(e -> e.name().equals(filetype.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Unsupported filetype %s.", filetype)))
                .parse(content);
    }
}

package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class Parser {
    private enum Filetypes {
        JSON {
            public ObjectMapper generateMapper() {
                return new ObjectMapper();
            }
        },
        YML {
            public ObjectMapper generateMapper() {
                return new YAMLMapper();
            }
        },
        YAML {
            public ObjectMapper generateMapper() {
                return new YAMLMapper();
            }
        };

        public abstract ObjectMapper generateMapper();
    }

    private static Map<String, Object> extract(File input, Filetypes filetype) {
        ObjectMapper mapper;

        try {
            mapper = filetype.generateMapper();
            Objects.requireNonNull(mapper);
            return mapper.readValue(input, new TypeReference<>() { });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static Map<String, Object> parse(File content, String filetype) {
        Objects.requireNonNull(content);
        Objects.requireNonNull(filetype);

        return extract(content, Filetypes.valueOf(filetype.toUpperCase()));
    }
}

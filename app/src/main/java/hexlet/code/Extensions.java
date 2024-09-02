package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public enum Extensions {
    JSON("json") {
        @Override
        public ObjectMapper generateParser() {
            return new ObjectMapper();
        }
    },
    YML("yml") {
        @Override
        public ObjectMapper generateParser() {
            return new YAMLMapper();
        }
    },
    YAML("yaml") {
        @Override
        public ObjectMapper generateParser() {
            return new YAMLMapper();
        }

    };

    private final String extension;

    public String getExtension() {
        return this.extension;
    }

    Extensions(String name) { this.extension = name; }

    @Override
    public String toString() {
        return "extension is '" + extension + '\'' + '}';
    }

    abstract public ObjectMapper generateParser();
}
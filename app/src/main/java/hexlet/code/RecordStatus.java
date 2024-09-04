package hexlet.code;

import java.util.Map;
import java.util.StringJoiner;

import static hexlet.code.Comparator.*;
import static hexlet.code.Comparator.KEY_ID_STATE;

public enum RecordStatus {
    UNCHANGED {
        public String buildStylish(Map<Object, String> input)
        {
            String key = input.get(FieldId.KEY.name()).toString();
            var value = input.get(FieldId.VALUE.name());
            String val = RecordStyle.STYLISH.makeString(value);

            return String.format("    %s: %s", key, val);
        }
        public String buildPlain(Map<Object, String> input)
        {

            return "";
        }
        public String buildJson(Map<Object, String> input)
        {
            return "";
        }
    },
    CHANGED {
        public String buildStylish(Map<Object, String> input)
        {
            StringJoiner result = new StringJoiner("/n");

            String key = input.get(FieldId.KEY.name()).toString();
            var value = input.get(FieldId.FROM.name());
            String from = RecordStyle.STYLISH.makeString(value);
            result.add(String.format("  - %s: %s", key, from));

            value = input.get(FieldId.TO.name());
            String to = RecordStyle.STYLISH.makeString(value);
            result.add(String.format("  + %s: %s", key, to));

            return result.toString();
        }
        public String buildPlain(Map<Object, String> input)
        {
            StringJoiner result = new StringJoiner("/n");

            String key = input.get(FieldId.KEY.name()).toString();
            var value = input.get(FieldId.FROM.name());
            String from = RecordStyle.STYLISH.makeString(value);
            result.add(String.format("  - %s: %s", key, from));

            value = input.get(FieldId.TO.name());
            String to = RecordStyle.STYLISH.makeString(value);
            result.add(String.format("  + %s: %s", key, to));

            result.add(String.format("Property '%s' was updated. From %s to %s", key, from, to));
            return result.toString();
        }
        public String buildJson(Map<Object, String> input)
        {
            return "";
        }
    },
    ADDED {
        public String buildStylish(Map<Object, String> input)
        {
            String key = input.get(FieldId.KEY.name()).toString();
            var value = input.get(FieldId.VALUE.name());
            String val = RecordStyle.STYLISH.makeString(value);

            return String.format("    %s: %s", key, val);
        }
        public String buildPlain(Map<Object, String> input)
        {
            return "";
        }
        public String buildJson(Map<Object, String> input)
        {
            return "";
        }
    },
    DELETED {
        public String buildStylish(Map<Object, String> input)
        {
            return "";
        }
        public String buildPlain(Map<Object, String> input)
        {
            return "";
        }
        public String buildJson(Map<Object, String> input)
        {
            return "";
        }
    },
    LIMIT {
        public String buildStylish(Map<Object, String> input)
        {
            return "";
        }
        public String buildPlain(Map<Object, String> input)
        {
            return "";
        }
        public String buildJson(Map<Object, String> input)
        {
            return "";
        }
    };

    public abstract String buildStylish(Map<Object, String> input);
    public abstract String buildPlain(Map<Object, String> input);
    public abstract String buildJson(Map<Object, String> input);
}

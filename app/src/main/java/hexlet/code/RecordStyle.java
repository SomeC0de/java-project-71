package hexlet.code;

import org.apache.commons.lang3.ClassUtils;

public enum RecordStyle {
    STYLISH {
        public String makeString(Object obj) {
            if (null == obj) {
                return "null";
            } else {
                return String.format("%s", obj);
            }
        }
    },
    PLAIN {

        public String makeString(Object obj) {
            if (null == obj) {
                return "null";
            }

            if (obj instanceof String) {
                return String.format("'%s'", obj);
            }

            if (ClassUtils.isPrimitiveOrWrapper(obj.getClass())) {
                return obj.toString();
            } else {
                return "[complex value]";
            }
        }
    },
    JSON {
        public String makeString(Object obj) {
            return "";
        }
    },
    LIMIT {
        public String makeString(Object obj) {
            return "";
        }
    };

    public abstract String makeString(Object obj);
}

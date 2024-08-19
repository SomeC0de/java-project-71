package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.CompareRecord;
import org.apache.commons.lang3.ClassUtils;

import java.util.Map;
import java.util.StringJoiner;

public class Json implements Style {
    @Override
    public String format(Map<String, CompareRecord> compared) {
        final StringJoiner result = new StringJoiner("\n", "[", "]");
        compared.forEach((key, value) -> {
            ObjectMapper objectMapper = new ObjectMapper();
            String objFromVal = calcReport(value.getValueFrom());
            String objToVal = calcReport(value.getValueTo());

            switch (value.getEntityState()) {
                case NOT_CHANGED -> {
                }
                case CHANGED -> {
                }
                case ADDED -> {
                }
                case REMOVED -> {
                }
                default -> throw new RuntimeException("Unknown record state!");
            }
        });

        return "";
    }

    private static String calcReport(Object obj) {
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
}

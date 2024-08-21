package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import hexlet.code.CompareRecord;
import hexlet.code.RecordStatus;
import org.apache.commons.lang3.ClassUtils;

import java.util.*;

public class Json implements Style {
    private List<Map<String, String>> prepareDiff(Map <String, CompareRecord> rawDiff) {
        List<Map<String, String>> prepared = new ArrayList<>();

        rawDiff.forEach((key, value) -> {
            Map<String, String> record = new LinkedHashMap<>();
            record.put("key", key);
            record.put("state", value.getEntityState().getState());

            switch (value.getEntityState()) {
                case CHANGED -> {
                    record.put("from", getStringValue(value.getValueFrom()));
                    record.put("to", getStringValue(value.getValueTo()));
                }
                case NOT_CHANGED, REMOVED -> record.put("value", getStringValue(value.getValueFrom()));
                case ADDED -> record.put("value", getStringValue(value.getValueTo()));
                default ->  throw new RuntimeException("Unknown record state!");
            }
            prepared.add(record);
        });

        return prepared;
    }

    private static String getStringValue(Object obj) {
        if (null == obj) {
            return "null";
        }

        if (obj instanceof String) {
            return String.format("'%s'", obj);
        }

        return obj.toString();
    }

    @Override
    public String format(Map<String, CompareRecord> compared) {
        final StringJoiner result = new StringJoiner(", ", "[ ", " ]");
        List<Map<String, String>> preparedDiff = prepareDiff(compared);

        preparedDiff.forEach(value -> {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            try {
                result.add(String.format(ow.writeValueAsString(value)));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });

        return result.toString();
    }
}

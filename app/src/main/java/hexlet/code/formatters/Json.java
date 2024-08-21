package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.CompareRecord;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;

public class Json implements Style {
    private List<Map<String, Object>> prepareDiff(Map<String, CompareRecord> rawDiff) {
        List<Map<String, Object>> prepared = new ArrayList<>();

        rawDiff.forEach((key, value) -> {
            Map<String, Object> record = new LinkedHashMap<>();
            record.put("key", key);
            record.put("state", value.getEntityState().getState());

            switch (value.getEntityState()) {
                case CHANGED -> {
                    record.put("from", value.getValueFrom());
                    record.put("to", value.getValueTo());
                }
                case NOT_CHANGED, REMOVED -> record.put("value", value.getValueFrom());
                case ADDED -> record.put("value", value.getValueTo());
                default ->  throw new RuntimeException("Unknown record state!");
            }
            prepared.add(record);
        });

        return prepared;
    }

    @Override
    public String format(Map<String, CompareRecord> compared) {
        List<Map<String, Object>> preparedDiff = prepareDiff(compared);

        ObjectMapper om = new ObjectMapper();
        try {
            return om.writerWithDefaultPrettyPrinter().writeValueAsString(preparedDiff);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

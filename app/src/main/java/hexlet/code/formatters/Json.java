package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import hexlet.code.CompareRecord;
import hexlet.code.RecordStatus;
import org.apache.commons.lang3.ClassUtils;

import java.util.Map;
import java.util.StringJoiner;

public class Json implements Style {
    @Override
    public String format(Map<String, CompareRecord> compared) {
        final StringJoiner result = new StringJoiner("\n", "[", "]");
        compared.forEach((key, value) -> {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            try {
                result.add(String.format("key : %s\n %s", key, ow.writeValueAsString(value)));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });

        return result.toString();
    }
}

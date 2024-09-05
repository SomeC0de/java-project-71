package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.FieldId;
import hexlet.code.RecordGenerator;
import hexlet.code.RecordStyle;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public final class Json implements RecordGenerator {
    @Override
    public String generateUnchanged(Map<Object, String> input) { return ""; }

    @Override
    public String generateChanged(Map<Object, String> input) { return ""; }

    @Override
    public String generateAdded(Map<Object, String> input) { return ""; }

    @Override
    public String generateDeleted(Map<Object, String> input) { return ""; }
}

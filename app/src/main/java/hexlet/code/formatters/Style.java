package hexlet.code.formatters;

import hexlet.code.CompareRecord;

import java.util.Map;

public interface Style {
    String format(Map<String, CompareRecord> compared);
}

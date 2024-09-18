package hexlet.code.formatters;

import hexlet.code.RecordKey;
import hexlet.code.RecordStatus;
import hexlet.code.builders.CommonBuilder;
import hexlet.code.builders.RecordMaker;
import org.apache.commons.lang3.ClassUtils;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public final class Plain implements Style {
    @Override
    public String apply(List<Map<String, Object>> compared) {
        return CommonBuilder.build(compared, builders, new StringJoiner("\n"));
    }

    private static String makeString(Object obj) {
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

    String buildUnchanged(Map<String, Object> record) {
        return "";
    }

    String buildChanged(Map<String, Object> record) {
        String key = record.get(RecordKey.KEY.name()).toString();
        String from = makeString(record.get(RecordKey.FROM.name()));
        String to = makeString(record.get(RecordKey.TO.name()));

        return String.format("Property '%s' was updated. From %s to %s", key, from, to);
    }

    String buildAdded(Map<String, Object> record) {
        String key = record.get(RecordKey.KEY.name()).toString();
        String val = makeString(record.get(RecordKey.VALUE.name()));

        return String.format("Property '%s' was added with value: %s", key, val);
    }

    String buildDeleted(Map<String, Object> record) {
        String key = record.get(RecordKey.KEY.name()).toString();
        return String.format("Property '%s' was removed", key);
    }

    private RecordMaker[] builders = new RecordMaker[RecordStatus.LIMIT.ordinal()];

    public Plain() {
        builders[RecordStatus.UNCHANGED.ordinal()] = this::buildUnchanged;
        builders[RecordStatus.CHANGED.ordinal()] = this::buildChanged;
        builders[RecordStatus.ADDED.ordinal()] = this::buildAdded;
        builders[RecordStatus.DELETED.ordinal()] = this::buildDeleted;
    }
}

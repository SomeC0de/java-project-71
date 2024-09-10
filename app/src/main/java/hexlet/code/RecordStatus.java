package hexlet.code;
import hexlet.code.RecordGenerator;

import java.util.List;
import java.util.Map;

public enum RecordStatus {
    UNCHANGED,
    CHANGED,
    ADDED,
    DELETED,
    LIMIT;

    private interface PseudoPointer {
        String generate(List<Map<String, Object>> input, RecordStyle style);
    }

    PseudoPointer[] functionPointersArray = new PseudoPointer[3];
}

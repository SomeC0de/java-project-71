package hexlet.code;

import java.util.Map;
import java.util.StringJoiner;

public enum RecordStatus {
    // TBD: make array of function pointers here
    UNCHANGED (),
    CHANGED (),
    ADDED (),
    DELETED(),
    LIMIT ();

    public RecordGenerator[] builders = new RecordGenerator[RecordStyle.LIMIT.ordinal()];

    RecordStatus( RecordGenerator[] buildersSet) {
        this.builders = buildersSet;
    }
}

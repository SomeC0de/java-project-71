package hexlet.code;

public class CompareRecord {
    final RecordStatus state;
    final Object valueFrom;
    final Object valueTo;

    CompareRecord(RecordStatus newState, Object newValueFrom, Object newValueTo) {
        state = newState;
        valueFrom = newValueFrom;
        valueTo = newValueTo;
    }
    CompareRecord(RecordStatus newState, Object newValue) {
        state = newState;
        valueFrom = newValue;
        valueTo = newValue;
    }

    public final RecordStatus getEntityState() {
        return state;
    }

    public final Object getValueFrom() {
        return valueFrom;
    }

    public final Object getValueTo() {
        return valueTo;
    }
}

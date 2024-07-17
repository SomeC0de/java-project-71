package hexlet.code;

public class CompareEntity {
    public enum entityState {
        NOT_CHANGED,
        REMOVED,
        ADDED
    };
    final entityState state;
    final Object valueFrom;
    final Object valueTo;

    CompareEntity(entityState newState, Object newValueFrom, Object newValueTo) {
        state = newState;
        valueFrom = newValueFrom;
        valueTo = newValueTo;
    }

    public final entityState getEntityState() {
        return state;
    }

    public final Object getValueFrom() {
        return valueFrom;
    }

    public final Object getValueTo() {
        return valueTo;
    }
}

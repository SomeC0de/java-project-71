package hexlet.code;

public class CompareEntity {
    final EntityState state;
    final Object valueFrom;
    final Object valueTo;

    CompareEntity(EntityState newState, Object newValueFrom, Object newValueTo) {
        state = newState;
        valueFrom = newValueFrom;
        valueTo = newValueTo;
    }
    CompareEntity(EntityState newState, Object newValue) {
        state = newState;
        valueFrom = newValue;
        valueTo = newValue;
    }

    public final EntityState getEntityState() {
        return state;
    }

    public final Object getValueFrom() {
        return valueFrom;
    }

    public final Object getValueTo() {
        return valueTo;
    }
}

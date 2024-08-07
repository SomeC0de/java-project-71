package hexlet.code;

import java.util.Map;
import java.util.stream.Collectors;

public class StylishFormatter {
    private static final String MARK_UNCHANGED = "  ";
    private static final String MARK_ADDED = "+ ";
    private static final String MARK_REMOVED = "- ";
    public static String format(Map<String, CompareEntity> compared) {
        StringBuilder result = new StringBuilder("{\n");

        String formated = compared.keySet().stream()
                .map(key -> {
                    CompareEntity record =  compared.get(key);
                    StringBuilder s = new StringBuilder("\t");

                    switch (record.getEntityState()) {
                        default:
                            throw new RuntimeException("Unknown record state!");

                        case NOT_CHANGED:
                            s.append(MARK_UNCHANGED + key + " : " + record.getValueFrom());
                            break;

                        case CHANGED:
                            s.append(MARK_REMOVED + key + " : " + record.getValueFrom() + "\n");
                            s.append("\t" + MARK_ADDED + key + " : " +  record.getValueTo());
                            break;

                        case ADDED:
                            s.append(MARK_ADDED + key + " : " +  record.getValueTo());
                            break;

                        case REMOVED:
                            s.append(MARK_REMOVED + key + " : " + record.getValueFrom());
                            break;
                    }
                    return s;
                }).collect(Collectors.joining("\n"));

        result.append(formated);
        result.append("\n}\n");

        return result.toString();
    }
}

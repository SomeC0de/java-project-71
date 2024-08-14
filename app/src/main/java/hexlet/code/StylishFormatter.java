package hexlet.code;

import java.util.Map;
import java.util.stream.Collectors;

public class StylishFormatter {
    private static final String MARK_UNCHANGED = "  ";
    private static final String MARK_ADDED = "+ ";
    private static final String MARK_REMOVED = "- ";
    private static final String INDENT = "  ";
    private static final String SEPARATOR = ": ";
    public static String format(Map<String, CompareEntity> compared) {
        StringBuilder result = new StringBuilder("{\n");

        String formated = compared.keySet().stream()
                .map(key -> {
                    CompareEntity record =  compared.get(key);
                    StringBuilder s = new StringBuilder();

                    switch (record.getEntityState()) {
                        default:
                            throw new RuntimeException("Unknown record state!");

                        case NOT_CHANGED:
                            s.append(INDENT + MARK_UNCHANGED + key + SEPARATOR + record.getValueFrom());
                            break;

                        case CHANGED:
                            s.append(INDENT + MARK_REMOVED + key + SEPARATOR + record.getValueFrom() + "\n");
                            s.append(INDENT + MARK_ADDED + key + SEPARATOR +  record.getValueTo());
                            break;

                        case ADDED:
                            s.append(INDENT + MARK_ADDED + key + SEPARATOR +  record.getValueTo());
                            break;

                        case REMOVED:
                            s.append(MARK_REMOVED + key + SEPARATOR + record.getValueFrom());
                            break;
                    }
                    return s;
                }).collect(Collectors.joining("\n"));

        result.append(formated);
        result.append("\n}");

        return result.toString();
    }
}

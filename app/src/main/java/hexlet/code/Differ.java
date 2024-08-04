package hexlet.code;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String pathFrom, String pathTo, String format) {
        // TBD:
        String contentFrom = null;
        try {
            contentFrom = Extractor.readFile(pathFrom);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String contentTo = null;
        try {
            contentTo = Extractor.readFile(pathTo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String typeFrom = Extractor.getFileType(pathFrom);
        String typeTo = Extractor.getFileType(pathTo);

        Map<String, Object> parsedFrom = Decomposer.parse(contentFrom, typeFrom);
        Map<String, Object> parsedTo = Decomposer.parse(contentTo, typeTo);

        Map<String, CompareEntity> compared = ContentComparator.compare(parsedFrom, parsedTo);

        return stylish(compared, format);
    }

    public static String stylish(Map<String, CompareEntity> compareResult, String style) {
        // TBD:
        return switch (style) {
            case "stylish" -> StylishFormatter.format(compareResult);
            default -> throw new RuntimeException("Unsupported style type!");
        };
    }
}

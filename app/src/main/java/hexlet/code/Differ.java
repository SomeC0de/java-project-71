package hexlet.code;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Differ {
    public static String generate(String pathFrom, String pathTo, String format) {
        File fileFrom = new File(pathFrom);
        File fileTo = new File(pathTo);

        String typeFrom =  FilenameUtils.getExtension(pathFrom);
        String typeTo = FilenameUtils.getExtension(pathTo);

        Map<String, Object> parsedFrom = Decomposer.parse(fileFrom, typeFrom);
        Map<String, Object> parsedTo = Decomposer.parse(fileTo, typeTo);

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

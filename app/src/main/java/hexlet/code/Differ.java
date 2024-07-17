package hexlet.code;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) {
        // TBD:
        String file1Content = null;
        try {
            file1Content = Extractor.readFile(filepath1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String file2Content = null;
        try {
            file2Content = Extractor.readFile(filepath2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String file1Type = Extractor.getFileType(filepath1);
        String file2Type = Extractor.getFileType(filepath2);

        Map<String, Object> file1Parsed = Decomposer.parse(file1Content, file1Type);
        Map<String, Object> file2Parsed = Decomposer.parse(file2Content, file2Type);

        Map<String, CompareEntity> compared = ContentComparator.compare(file1Parsed, file2Parsed);

        return stylish(compared, format);
    }

    public static String stylish(Map<String, CompareEntity> compareResult, String style) {
        // TBD:
        return switch (style) {
            case "stylish" -> StylishFormatter.format(compareResult);
            default -> throw new RuntimeException("Unsupported extention!");
        };
    }
}

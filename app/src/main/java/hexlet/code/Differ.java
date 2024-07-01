package hexlet.code;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws FileNotFoundException {
        // TBD:
        String file1Content = Extractor.decomposeInputFile(filepath1);
        String file2Content = Extractor.decomposeInputFile(filepath2);

        String file1Type = Extractor.getFileType(filepath1);
        String file2Type = Extractor.getFileType(filepath2);

        Map <String, Object> file1Parsed = Decomposer.parse(file1Content, file1Type);
        Map<String, Object> file2Parsed = Decomposer.parse(file2Content, file2Type);

        List<Map<String, Object>> compared = ContentComparator.compare(file1Parsed, file2Parsed);

        return stylish(compared, format);
    }

    public static String stylish(List<Map<String, Object>> compareResult, String style) {
        // TBD:
        return switch (style) {
            case "stylish" -> StylishFormatter.format(compareResult);
            default -> throw new RuntimeException("Unsupported extention!");
        };
    }
}

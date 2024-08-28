package hexlet.code;

import org.apache.commons.io.FilenameUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

import static hexlet.code.App.DEFAULT_FORMAT;

public class Differ {
    public static String generate(String pathFrom, String pathTo) {
        return generate(pathFrom, pathTo, DEFAULT_FORMAT);
    }

    public static String generate(String pathFrom, String pathTo, String format) {
        File fileFrom = new File(pathFrom);
        File fileTo = new File(pathTo);

        String typeFrom =  FilenameUtils.getExtension(pathFrom);
        String typeTo = FilenameUtils.getExtension(pathTo);

        Map<String, Object> parsedFrom = Parser.parse(fileFrom, typeFrom);
        Map<String, Object> parsedTo = Parser.parse(fileTo, typeTo);

        List<Map<String, Object>> compared = Comparator.compare(parsedFrom, parsedTo);

        String diff = Formatter.formatWith(compared, format);
        saveToFile(diff, format);

        return diff;
    }
    private static void saveToFile(String diff, String format) {
        String pathToFolder = createDiffFolder();
        String fullName = generateFileName(diff, format, pathToFolder);

        File file = new File(fullName);
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(diff);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String createDiffFolder() {
        File folderDiff = new File(System.getProperty("user.home") + File.separator + "Differ");

        if (!folderDiff.exists()) {
            if (!folderDiff.mkdir()) {
                throw new RuntimeException("Error: failed to create output files directory");
            }
        }

        return folderDiff.toString();
    }

    private static String generateFileName(String diff, String format, String pathToDiffFolder) {
        StringBuilder fullName = new StringBuilder(pathToDiffFolder).append(File.separator);

        byte[] inputAsBytes = diff.getBytes();
        Checksum checksum = new CRC32();
        checksum.update(inputAsBytes, 0, inputAsBytes.length);
        fullName.append(String.format("%s_%s_%s", "diff", format, checksum.getValue()));

        switch (format) {
            case "stylish", "plain" -> fullName.append(String.format(".txt", format));
            case "json" -> fullName.append(".json");
            default -> throw new RuntimeException("Unsupported style type!");
        }

        return fullName.toString();
    }
}

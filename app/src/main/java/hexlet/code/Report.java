package hexlet.code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class Report {
    private static final File DIFF_FOLDER =
            new File(System.getProperty("user.home") + File.separator + "Differ");
    private static final String EXTENTION_FOR_PLAIN = ".txt";
    private static final String EXTENTION_FOR_STYLISH = ".txt";
    private static final String EXTENTION_FOR_JSON = ".json";
    public static void toFile(String diff, String format) {
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
        if (!DIFF_FOLDER.exists()) {
            if (!DIFF_FOLDER.mkdir()) {
                throw new RuntimeException("Error: failed to create output files directory");
            }
        }

        return DIFF_FOLDER.toString();
    }

    private static String generateFileName(String diff, String format, String pathToDiffFolder) {
        StringBuilder fullName = new StringBuilder(pathToDiffFolder).append(File.separator);

        byte[] inputAsBytes = diff.getBytes();
        Checksum checksum = new CRC32();
        checksum.update(inputAsBytes, 0, inputAsBytes.length);
        fullName.append(String.format("%s_%s_%s", "diff", format, checksum.getValue()));

        switch (format) {
            case "stylish" -> fullName.append(EXTENTION_FOR_STYLISH);
            case "plain" -> fullName.append(EXTENTION_FOR_PLAIN);
            case "json" -> fullName.append(EXTENTION_FOR_JSON);
            default -> throw new RuntimeException("Unsupported style type!");
        }

        return fullName.toString();
    }
}

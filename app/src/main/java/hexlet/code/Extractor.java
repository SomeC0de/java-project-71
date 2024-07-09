package hexlet.code;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Extractor {
    public static String getFileType(String path) {
        return FilenameUtils.getExtension(path);
    }

    public static String readFile(String pathToFile) throws IOException {
        String result = null;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(pathToFile))) {
            result = reader.readLine();

            while (result != null) {
                result = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}

package hexlet.code;
import org.apache.commons.io.FilenameUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Extractor {
    public static String getFileType(String path) {
        return FilenameUtils.getExtension(path);
    }

    public static String readFile(String pathToFile) throws IOException {
        StringBuilder fileContent = new StringBuilder();
        String line;

        Path absolutePath = Paths.get(pathToFile).toAbsolutePath();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(absolutePath.toUri()))) {
            while ((line = reader.readLine()) != null) {
                fileContent.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent.toString();
    }
}

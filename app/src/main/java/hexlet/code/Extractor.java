package hexlet.code;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Extractor {
    private static String readFile(String path) throws FileNotFoundException {
        if ((path != null) && !path.isEmpty()) {
            File file = new File(path);
            if (file.exists() && file.canRead()) {
                StringBuilder result = new StringBuilder();
                Scanner sc = new Scanner(new FileReader(path));
                String str;

                while (sc.hasNext()) {
                    result.append(sc.next());
                }

                return result.toString();
            } else {
                throw new FileNotFoundException();
            }
        } else {
            throw new FileNotFoundException();
        }
    }

    public static String getFileType(String filepath) {
        // TBD:
        return "";
    }

    public static String decomposeInputFile(String pathToFile) throws FileNotFoundException {
        return readFile(pathToFile);
    }
}

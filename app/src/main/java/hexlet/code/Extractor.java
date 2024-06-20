package hexlet.code;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Extractor {
    public static boolean isFileExists(String path) {
        if ((path != null) && !path.isEmpty()) {
            File file = new File(path);
            return file.exists() & file.canRead();
        } else {
            return false;
        }
    }

    public static List<String> readFile(String path) throws FileNotFoundException {
        if ((path != null) && !path.isEmpty()) {
            File file = new File(path);
            if (file.exists() && file.canRead()) {
                List<String> result = new ArrayList<String>();
                Scanner sc = new Scanner(new FileReader(path));
                String str;

                while (sc.hasNext()) {
                    str = sc.next();
                    result.add(str);
                }

                return result;
            } else {
                throw new FileNotFoundException();
            }
        } else {
            throw new FileNotFoundException();
        }
    }
}

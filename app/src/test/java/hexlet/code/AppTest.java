package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private static String diffFlat;
    private static String diffNested;

    @BeforeEach
    public void beforeEach() throws IOException {
        diffFlat = Files.readString(Paths.get("src/test/resources/diffFlat"));
        diffNested = Files.readString(Paths.get("src/test/resources/diffNested"));
    }

    @Test
    public void stylishJsonTest() throws IOException {
        String actual = Differ.generate("src/test/resources/flat_list0.json",
                "src/test/resources/flat_list1.json", "stylish");
        assertEquals(diffFlat, actual);
    }

    @Test
    public void stylishYmlTest() throws IOException {
        String actual = Differ.generate("src/test/resources/flat_list0.yml",
                "src/test/resources/flat_list1.yml", "stylish");
        assertEquals(diffFlat, actual);
    }

    @Test
    public void stylishJsonNestedTest() throws IOException {
        String actual = Differ.generate("src/test/resources/nested_0.json",
                "src/test/resources/nested_1.json", "stylish");
        assertEquals(diffNested, actual);
    }

    @Test
    public void stylishYmlNestedTest() throws IOException {
        String actual = Differ.generate("src/test/resources/nested_0.yml",
                "src/test/resources/nested_1.yml", "stylish");
        assertEquals(diffNested, actual);
    }
}

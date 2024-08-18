package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private static String diffStylish;
    private static String diffPlain;

    @BeforeEach
    public void beforeEach() throws IOException {
        diffStylish = Files.readString(Paths.get("src/test/resources/diffStylish"));
        diffPlain = Files.readString(Paths.get("src/test/resources/diffPlain"));
    }

    @Test
    public void stylishJsonNestedTest() throws IOException {
        String actual = Differ.generate("src/test/resources/nested_0.json",
                "src/test/resources/nested_1.json", "stylish");
        assertEquals(diffStylish, actual);
    }

    @Test
    public void stylishYmlNestedTest() throws IOException {
        String actual = Differ.generate("src/test/resources/nested_0.yml",
                "src/test/resources/nested_1.yml", "stylish");
        assertEquals(diffStylish, actual);
    }

    @Test
    public void defaultYmlNestedTest() throws IOException {
        String actual = Differ.generate("src/test/resources/nested_0.yml",
                "src/test/resources/nested_1.yml");
        assertEquals(diffStylish, actual);
    }

    @Test
    public void plainJsonNestedTest() throws IOException {
        String actual = Differ.generate("src/test/resources/nested_0.json",
                "src/test/resources/nested_1.json", "plain");
        assertEquals(diffPlain, actual);
    }

    @Test
    public void plainYmlNestedTest() throws IOException {
        String actual = Differ.generate("src/test/resources/nested_0.yml",
                "src/test/resources/nested_1.yml", "plain");
        assertEquals(diffPlain, actual);
    }
}

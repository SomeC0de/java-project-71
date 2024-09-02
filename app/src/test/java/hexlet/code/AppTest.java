package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class AppTest {
    private static String diffStylish;
    private static String diffPlain;
    private static String diffJson;

    @BeforeEach
    public void beforeEach() throws IOException {
        diffStylish = Files.readString(Paths.get("src/test/resources/diffStylish.txt"));
        diffPlain = Files.readString(Paths.get("src/test/resources/diffPlain.txt"));
        diffJson = Files.readString(Paths.get("src/test/resources/diffJson.json"));
    }

    @Test
    public void wrongParametersTest() {
        assertThrows(RuntimeException.class, () ->
                Differ.generate("src/test/resources/nested_0.json",
                        "src/test/resources/nested_1.json", "blahblahblah"));
    }

    @Test
    public void nullParametersTest() {
        assertThrows(NullPointerException.class, () ->
                Differ.generate(null,
                        "src/test/resources/nested_1.json", "json"));
    }

    @Test
    public void wrongPathTest() {
        assertThrows(RuntimeException.class, () ->
                Differ.generate("nested_0.json",
                        "src/test/resources/nested_1.json", "plain"));
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

    @Test
    public void jsonJsonNestedTest() throws IOException {
        String actual = Differ.generate("src/test/resources/nested_0.json",
                "src/test/resources/nested_1.json", "json");
        assertEquals(diffJson, actual);
    }

    @Test
    public void jsonYmlNestedTest() throws IOException {
        String actual = Differ.generate("src/test/resources/nested_0.yml",
                "src/test/resources/nested_1.yml", "json");
        assertEquals(diffJson, actual);
    }
}

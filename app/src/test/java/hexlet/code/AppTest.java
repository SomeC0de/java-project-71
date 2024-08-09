package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AppTest {
    private static String diffFlat;

    @BeforeEach
    public void beforeEach() throws IOException {
        diffFlat = Files.readString(Paths.get("src/test/resources/diffFlat"));
    }
    @Test
    public void dummyTest() {
        assertEquals(true, true);
    }

    @Test
    public void stylishJsonTest() throws IOException {
        String actual = Differ.generate("src/test/resources/flat_list0.json",
                "src/test/resources/flat_list1.json", "stylish");
    }
}

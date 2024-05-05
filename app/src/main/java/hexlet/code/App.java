package hexlet.code;

//import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference")
public class App {
    @Option(
            names = {"-h", "--help"},
            description = "Show this help message and exit.")
    private String helpContent = "blahblah";

    @Option(
            names = {"-V", "--version"},
            description = "Print version information and exit.")
    private String version = "1.0";

    @Parameters(index = "0", description = "First file to compare.")
    private File file1;

    @Parameters(index = "1", description = "Second file to compare")
    private File file2;

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

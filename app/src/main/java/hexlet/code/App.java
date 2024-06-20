package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;

import hexlet.code.Extractor;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference")
public class App {
    private static final String DEFAULT_FORMAT = "stylish";

    @Option(
            names = {"-f", "--format"},
            defaultValue = DEFAULT_FORMAT,
            description = "output format [default: ${DEFAULT-VALUE}]")
    private String format = DEFAULT_FORMAT;

    @Parameters(index = "0", description = "path to first file")
    private File filepath1;

    @Parameters(index = "1", description = "path to second file")
    private File filepath2;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}

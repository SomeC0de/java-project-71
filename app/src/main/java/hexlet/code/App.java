package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(name = "gendiff",
        version = "1.0",
        description = "Compares two configuration files and shows a difference. " +
                "Generates report file to /user/Differ directory",
        mixinStandardHelpOptions = true)
public final class App implements Callable<Integer> {
    public static final String DEFAULT_FORMAT = "stylish";

    @Option(
            names = {"-f", "--format"},
            defaultValue = DEFAULT_FORMAT,
            description = "output format [default: ${DEFAULT-VALUE}]")
    private String format = DEFAULT_FORMAT;

    @Parameters(index = "0", description = "path to first file")
    private String filepathFrom;

    @Parameters(index = "1", description = "path to second file")
    private String filepathTo;

    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate(filepathFrom, filepathTo, format));
        return 0;

    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}

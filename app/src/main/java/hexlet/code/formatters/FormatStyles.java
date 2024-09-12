package hexlet.code.formatters;

public enum FormatStyles {
    STYLISH(new Stylish()::apply),
    PLAIN(new Plain()::apply),
    JSON(new Json()::apply);

    FormatStyles(Style style) {
        this.formatter = style;
    }

    final Style formatter;
}

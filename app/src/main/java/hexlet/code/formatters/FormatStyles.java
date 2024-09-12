package hexlet.code.formatters;

public enum FormatStyles {
    STYLISH(new Stylish()::apply),
    PLAIN(new Plain()::apply),
    JSON(new Json()::apply);

    final Style formatter;

    FormatStyles(Style style) {
        this.formatter = style;
    }

    public static Style getFormater(String format) {
        return FormatStyles.valueOf(format.toUpperCase()).formatter;
    }
}

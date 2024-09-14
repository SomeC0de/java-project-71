package hexlet.code.formatters;

public enum RecordStyle {
    STYLISH(new Stylish()::apply),
    PLAIN(new Plain()::apply),
    JSON(new Json()::apply);

    final Style formatter;

    RecordStyle(Style style) {
        this.formatter = style;
    }

    public static Style getFormater(String format) {
        return RecordStyle.valueOf(format.toUpperCase()).formatter;
    }
}

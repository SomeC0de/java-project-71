package hexlet.code;

import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Generators {

    public RecordGenerator[][] generatorsMatrix;

    Generators() {
        generatorsMatrix =
            new RecordGenerator[RecordStyle.LIMIT.ordinal()][RecordStatus.LIMIT.ordinal()];

        generatorsMatrix[RecordStyle.STYLISH.ordinal()][RecordStatus.UNCHANGED.ordinal()] = Stylish::generateChanged;
    }

}
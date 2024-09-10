package hexlet.code;

import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Generators {

    public RecordGenerator[][] generatorsMatrix;

    /*public void fillMatrix(RecordGenerator method1, RecordGenerator method2, RecordGenerator method3,
                           RecordGenerator method4, RecordGenerator method5, RecordGenerator method6,
                           RecordGenerator method7, RecordGenerator method8, RecordGenerator method9,
                           RecordGenerator method10, RecordGenerator method11, RecordGenerator method12) {
        generatorsMatrix[0][0] = method1;
    }*/

    Generators() {
        generatorsMatrix =
            new RecordGenerator[RecordStyle.LIMIT.ordinal()][RecordStatus.LIMIT.ordinal()];

        generatorsMatrix[RecordStyle.STYLISH.ordinal()][RecordStatus.UNCHANGED.ordinal()] = Stylish.generateUnchanged;
    }

}

}
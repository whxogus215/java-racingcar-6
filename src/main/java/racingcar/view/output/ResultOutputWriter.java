package racingcar.view.output;

import java.util.List;
import racingcar.dto.Result;

public class ResultOutputWriter extends OutputWriter{
    private static final String DISTANCE_FORMAT = "-";

    private ResultOutputWriter() {
    }

    public static void printCarState(List<Result> results) {
        for (Result result : results) {
            System.out.print(result.getCarName() + " : ");
            System.out.println(DISTANCE_FORMAT.repeat(result.getDistance()));
        }
        System.out.println();
    }
}

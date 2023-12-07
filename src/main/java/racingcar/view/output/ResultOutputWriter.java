package racingcar.view.output;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import racingcar.config.OutputMessage;
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

    public static void printWinners(List<Result> results) {
        System.out.print(OutputMessage.WINNERS.getMessage() + " : ");
        /*
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (Result result : results) {
            stringJoiner.add(result.getCarName());
        }
        System.out.print(stringJoiner);
        */
        String winners = results.stream()
                .map(Result::getCarName)
                .collect(Collectors.joining(","));
        System.out.print(winners);
    }
}

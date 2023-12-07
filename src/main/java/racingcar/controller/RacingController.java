package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.config.ErrorMessage;
import racingcar.config.OutputMessage;
import racingcar.config.Regex;
import racingcar.domain.RacingCarFactory;
import racingcar.dto.Result;
import racingcar.exception.ExceptionHandler;
import racingcar.service.RacingService;
import racingcar.utils.Parser;
import racingcar.view.input.InputReader;
import racingcar.view.output.OutputWriter;
import racingcar.view.output.ResultOutputWriter;

public class RacingController {
    public void gameStart() {
        RacingCarFactory racingCarFactory = requestCarNames();
        Integer gameCount = requestCount();

        ResultOutputWriter.println("\n" + OutputMessage.RESULT.getMessage());
//        for (int i = 0; i < gameCount; i++) {
//            List<Result> results = RacingService.updateCarState(racingCarFactory);
//            ResultOutputWriter.printCarState(results);
//        }
        IntStream.range(0, gameCount)
                .mapToObj(i -> RacingService.updateCarState(racingCarFactory))
                .forEach(ResultOutputWriter::printCarState);

        List<Result> winners = RacingService.getWinners(racingCarFactory);
        ResultOutputWriter.printWinners(winners);
        Console.close();
    }

    private RacingCarFactory requestCarNames() {
        OutputWriter.println(OutputMessage.START.getMessage());
        return ExceptionHandler.retryOnException(RacingController::createRacingCarByNames);
    }

    private static RacingCarFactory createRacingCarByNames() {
        String input = InputReader.getValue();
        List<String> carNames = Parser.getParsedNames(input);
        return new RacingCarFactory(carNames);
    }

    private Integer requestCount() {
        OutputWriter.println(OutputMessage.COUNT.getMessage());
        return ExceptionHandler.retryOnException(RacingController::createGameCount);
    }

    private static Integer createGameCount() {
        String input = InputReader.getValue();
        validateCount(input);
        return Integer.parseInt(input);
    }

    private static void validateCount(String input) {
        if (!input.matches(Regex.ONLY_NATURAL_NUMBER.getRegex())) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NATURAL_NUMBER.getMessage());
        }
    }
}

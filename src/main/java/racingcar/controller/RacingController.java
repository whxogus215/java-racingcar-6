package racingcar.controller;

import java.util.List;
import racingcar.config.ErrorMessage;
import racingcar.config.OutputMessage;
import racingcar.config.Regex;
import racingcar.domain.RacingCarFactory;
import racingcar.exception.ExceptionHandler;
import racingcar.utils.Parser;
import racingcar.view.input.InputReader;
import racingcar.view.output.OutputWriter;

public class RacingController {
    public void gameStart() {
        RacingCarFactory racingCarFactory = requestCarNames();
        Integer gameCount = requestCount();

//        System.out.println("출력 끝!");
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

package racingcar.controller;

import java.util.List;
import racingcar.config.OutputMessage;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarFactory;
import racingcar.exception.ExceptionHandler;
import racingcar.utils.Parser;
import racingcar.view.input.InputReader;
import racingcar.view.output.OutputWriter;

public class RacingController {
    public void gameStart() {
        RacingCarFactory racingCarFactory = requestCarNames();

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
}

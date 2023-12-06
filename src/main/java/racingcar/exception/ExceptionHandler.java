package racingcar.exception;

import java.util.function.Function;
import java.util.function.Supplier;
import racingcar.view.output.OutputWriter;

public class ExceptionHandler {
    private ExceptionHandler() {

    }

    public static <T> T retryOnException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                OutputWriter.println(exception.getMessage());
            }
        }
    }
}

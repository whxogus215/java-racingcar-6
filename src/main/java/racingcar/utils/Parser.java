package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import racingcar.config.ErrorMessage;

public class Parser {
    private static final String COMMA = ",";
    private static final String WHITE_SPACE = " ";

    public static List<String> getParsedNames(String input) {
        validateInputFormat(input);
        return Arrays.stream(input.split(",")).toList();
    }

    private static void validateInputFormat(String input) {
        /**
         * 잘못된 입력 값 예시 : "abc,df," or "abc,df, "
         */
        if (input.endsWith(COMMA) || input.endsWith(WHITE_SPACE)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_END_COMMA.getMessage());
        }
    }
}

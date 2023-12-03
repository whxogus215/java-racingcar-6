package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> getParsedNames(String input) {
        validateInputFormat(input);
        return Arrays.stream(input.split(",")).toList();
    }

    private static void validateInputFormat(String input) {
        /**
         * 잘못된 입력 값 예시 : "abc,df," or "abc,df, "
         */
        if (input.endsWith(",") || input.endsWith(" ")) {
            throw new IllegalArgumentException("입력된 값 형식이 올바르지 않습니다.");
        }
    }
}

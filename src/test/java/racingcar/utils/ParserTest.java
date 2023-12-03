package racingcar.utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    @DisplayName("입력 값 뒤에 , 붙을 경우 예외 발생하는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abc,df,", "abc,df, "})
    void getParsedNamesTest(String input) {
        assertThatThrownBy(() -> Parser.getParsedNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

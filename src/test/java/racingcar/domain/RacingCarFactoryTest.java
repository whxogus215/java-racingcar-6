package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.config.ErrorMessage;

class RacingCarFactoryTest {

    @DisplayName("자동차 중복 여부 테스트")
    @Test
    void createCarsTest() {
        List<String> carNames = List.of("aaa", "bbb", "bbb", "ccc");
        assertThatThrownBy(() -> new RacingCarFactory(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_DUPLICATED_CARNAME.getMessage());
    }
}

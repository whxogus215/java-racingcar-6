package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

    @DisplayName("랜덤 값이 4이상일 경우, 전진 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void goTest(int number) {
        String name = "aaa";
        RacingCar car = RacingCar.createCar(name);

        car.goOrStop(number);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @DisplayName("랜덤 값이 4미만일 경우, 정지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void stopTest(int number) {
        String name = "aaa";
        RacingCar car = RacingCar.createCar(name);

        car.goOrStop(number);
        assertThat(car.getDistance()).isEqualTo(0);
    }
}

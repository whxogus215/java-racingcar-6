package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.RacingCarFactory;
import racingcar.dto.Result;

public class RacingService {
    public static List<Result> updateCarState(RacingCarFactory racingCarFactory) {
        return racingCarFactory.updateCar(() -> Randoms.pickNumberInRange(0, 9));
    }
}

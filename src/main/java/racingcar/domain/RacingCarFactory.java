package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.config.ErrorMessage;

public class RacingCarFactory {
    private final List<RacingCar> cars;

    public RacingCarFactory(List<String> names) {
        List<String> namesExcludedBlank = removeBlank(names);
        validateDuplicatedName(namesExcludedBlank);
        this.cars = createCars(namesExcludedBlank);
    }

    private void validateDuplicatedName(List<String> names) {
        Set<String> notValidatedNames = new HashSet<>(names);
        if (notValidatedNames.size() != names.size()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DUPLICATED_CARNAME.getMessage());
        }
    }

    private List<String> removeBlank(List<String> names) {
        return names.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private List<RacingCar> createCars(List<String> names) {
        return names.stream()
                .map(RacingCar::createCar)
                .collect(Collectors.toList());
    }
}

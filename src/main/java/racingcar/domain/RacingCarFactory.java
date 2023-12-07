package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import racingcar.config.ErrorMessage;
import racingcar.dto.Result;

public class RacingCarFactory {
    private final List<RacingCar> cars;

    public RacingCarFactory(List<String> names) {
        List<String> namesExcludedBlank = removeBlank(names);
        validateDuplicatedName(namesExcludedBlank);
        this.cars = createCars(namesExcludedBlank);
    }

    public List<Result> updateCar(Supplier<Integer> supplier) {
        return cars.stream()
                .peek(racingCar -> racingCar.goOrStop(supplier.get()))
                .map(racingCar -> {
                    Result result = new Result();
                    result.setCarName(racingCar.getName());
                    result.setDistance(racingCar.getDistance());
                    return result;
                })
                .collect(Collectors.toList());
    }

    public List<Result> getWinners() {
        int maxDistance = cars.stream().mapToInt(RacingCar::getDistance).max().getAsInt();
        return cars.stream()
                .filter(cars -> cars.getDistance() == maxDistance)
                .map(racingCar -> {
                    Result result = new Result();
                    result.setCarName(racingCar.getName());
                    result.setDistance(racingCar.getDistance());
                    return result;
                })
                .collect(Collectors.toList());
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

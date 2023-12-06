package racingcar.domain;

import racingcar.config.ErrorMessage;

public class RacingCar {
    private static final int LIMIT = 4;
    private static final int MAX_SIZE = 5;
    private final String name;
    private int distance;

    private RacingCar(String name) {
        this.name = name;
        this.distance = 0;
    }

    public static RacingCar createCar(String name) {
        validateNameSize(name);
        return new RacingCar(name);
    }

    private static void validateNameSize(String name) {
        if (name.length() > MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_OVER_NAME_SIZE.getMessage());
        }
    }

    public void goOrStop(int number) {
        if (number >= LIMIT) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}

package racingcar.domain;

public class RacingCar {
    private final int LIMIT = 4;
    private final String name;
    private int distance;

    private RacingCar(String name) {
        this.name = name;
        this.distance = 0;
    }

    public static RacingCar createCar(String name) {
        return new RacingCar(name);
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

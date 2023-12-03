package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {
    private InputReader() {

    }

    public static String getValue() {
        return Console.readLine();
    }
}

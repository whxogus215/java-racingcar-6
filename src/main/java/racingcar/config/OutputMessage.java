package racingcar.config;

public enum OutputMessage {
    START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    COUNT("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    WINNERS("최종 우승자");

    private String message;

    OutputMessage(String detail) {
        this.message = detail;
    }

    public String getMessage() {
        return message;
    }
}

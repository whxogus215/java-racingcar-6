package racingcar.view;

public enum ViewFormat {

    DISTANCE("-"),
    INPUT_CARNAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_COUNT("시도할 회수는 몇회인가요?");

    private final String formatContent;

    ViewFormat(String formatContent) {
        this.formatContent = formatContent;
    }

    public String getFormatContent() {
        return formatContent;
    }
}

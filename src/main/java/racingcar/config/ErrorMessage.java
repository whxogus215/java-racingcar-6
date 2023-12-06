package racingcar.config;

public enum ErrorMessage {
    NOT_END_COMMA("입력 값이 ,로 끝나면 안됩니다."),
    NOT_DUPLICATED_CARNAME("자동차 이름이 중복되어선 안됩니다."),
    NOT_OVER_NAME_SIZE("자동차 이름은 5자 이하이어야만 합니다.");

    ErrorMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}

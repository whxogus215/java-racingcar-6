package racingcar.config;

public enum ErrorMessage {
    NOT_END_COMMA("입력 값이 ,로 끝나면 안됩니다.");

    ErrorMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}

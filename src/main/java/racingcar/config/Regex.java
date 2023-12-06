package racingcar.config;

public enum Regex {
    ONLY_NATURAL_NUMBER("^[1-9][0-9]*$");

    private String regex;

    Regex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}

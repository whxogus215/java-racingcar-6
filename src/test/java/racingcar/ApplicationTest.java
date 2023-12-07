package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.config.ErrorMessage;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

//    @Test
//    void 이름에_대한_예외_처리() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    @Test
    void 자동차이름_중복_예외_처리() {
        assertSimpleTest(() -> {
            runException("aaa,aaaa,aaaa");
            assertThat(output()).contains(ErrorMessage.NOT_DUPLICATED_CARNAME.getMessage());
        });
    }

    @Test
    void 자동차이름_5자_이상_예외_처리() {
        assertSimpleTest(() -> {
            runException("aaa,bbb,bbbbbbb");
            assertThat(output()).contains(ErrorMessage.NOT_OVER_NAME_SIZE.getMessage());
        });
    }

    @Test
    void 시도횟수_문자입력_예외_처리() {
        assertSimpleTest(() -> {
            runException("aaa,bbb,ccc", "test");
            assertThat(output()).contains(ErrorMessage.ONLY_NATURAL_NUMBER.getMessage());
        });
    }

    @Test
    void 시도횟수_1미만_예외_처리() {
        assertSimpleTest(() -> {
            runException("aaa,bbb,ccc", "0");
            assertThat(output()).contains(ErrorMessage.ONLY_NATURAL_NUMBER.getMessage());
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

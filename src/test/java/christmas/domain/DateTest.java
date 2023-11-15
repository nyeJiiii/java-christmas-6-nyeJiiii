package christmas.domain;

import static christmas.exception.ErrorMessage.WRONG_DATE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class DateTest {
    
    @ParameterizedTest
    @ValueSource(strings = {"k", "1 ", "*"})
    @DisplayName("방문날짜: 숫자가 아닐 때 예외")
    void test_newDate_1(String numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Date((numbers)))
                .withMessage(WRONG_DATE);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"0", "32"})
    @DisplayName("방문날짜: 1~31 범위의 숫자가 아닐 때")
    void test_newDate_2(String numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Date((numbers)))
                .withMessage(WRONG_DATE);
    }
    
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("방문날짜: Null 또는 Empty 일 때`")
    void test_newDate_3(String numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Date((numbers)))
                .withMessage(WRONG_DATE);
    }
}
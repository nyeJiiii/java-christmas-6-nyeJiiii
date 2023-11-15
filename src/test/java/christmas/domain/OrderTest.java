package christmas.domain;

import static christmas.exception.ErrorMessage.CANNOT_ORDER_ONLY_DRINK;
import static christmas.exception.ErrorMessage.OVER_MAXIMUM_COUNT_OF_ORDER;
import static christmas.exception.ErrorMessage.WRONG_ORDER;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderTest {
    
    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-1,", ",티본스테이크-1"})
    @DisplayName("주문메뉴: 앞뒤가 ,로 이루어질 때 예외")
    void test_newOrder_1(String order) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(order))
                .withMessage(WRONG_ORDER);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"감자뇨끼-1", "로제파스타-1"})
    @DisplayName("주문메뉴: 메뉴에 없는 내용 주문 시 예외")
    void test_newOrder_2(String order) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(order))
                .withMessage(WRONG_ORDER);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"감자뇨끼-1", "로제파스타-1"})
    @DisplayName("주문메뉴: 메뉴에 없는 내용 주문 시 예외")
    void test_newOrder_3(String order) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(order))
                .withMessage(WRONG_ORDER);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크1,바비큐립-1", "티본스테이크-2-1,바비큐립-1", "티본스테이크-,바비큐립-1"})
    @DisplayName("주문메뉴: '-'로 분리되는 배열의 길이가 2가 아닐 때 예외")
    void test_newOrder_4(String order) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(order))
                .withMessage(WRONG_ORDER);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-k,바비큐립-1", "티본스테이크-1,바비큐립-0"})
    @DisplayName("주문메뉴: 메뉴의 수가 1 이상의 숫자가 아닐 때 예외")
    void test_newOrder_5(String order) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(order))
                .withMessage(WRONG_ORDER);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-1,바비큐립-20", "티본스테이크-10,바비큐립-11"})
    @DisplayName("주문메뉴: 메뉴 수의 합이 21개 이상일 때 예외")
    void test_newOrder_6(String order) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(order))
                .withMessage(OVER_MAXIMUM_COUNT_OF_ORDER);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-1,티본스테이크-3", "바비큐립-1,바비큐립-3"})
    @DisplayName("주문메뉴: 중복되는 메뉴를 주문할 때 예외")
    void test_newOrder_7(String order) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(order))
                .withMessage(WRONG_ORDER);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-1,레드와인-3", "레드와인-1,샴페인-3"})
    @DisplayName("주문메뉴: 음료만 주문할 때 예외")
    void test_newOrder_8(String order) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(order))
                .withMessage(CANNOT_ORDER_ONLY_DRINK);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-1,레드와인-3", "레드와인-1,샴페인-3"})
    @DisplayName("주문메뉴: 음료만 주문할 때 예외")
    void test_newOrder_9(String order) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(order))
                .withMessage(CANNOT_ORDER_ONLY_DRINK);
    }
    
}
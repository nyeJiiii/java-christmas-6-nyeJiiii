package christmas.exception;

import static christmas.view.InputView.readDate;
import static christmas.view.InputView.readOrder;

import christmas.domain.Date;
import christmas.domain.Order;

public class ExceptionCatcher {
    
    public static Date catchExceptionWithNewDate() {
        try {
            return new Date(readDate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static Order catchExceptionWithNewOrder() {
        try {
            return new Order(readOrder());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

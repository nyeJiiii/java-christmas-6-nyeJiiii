package christmas;

import static christmas.exception.ExceptionCatcher.catchExceptionWithNewDate;
import static christmas.exception.ExceptionCatcher.catchExceptionWithNewOrder;

import christmas.domain.Date;
import christmas.domain.Order;

public class ChristmasEvent {
    
    Date date = null;
    Order order = null;
    
    public void getDateFromConsole() {
        do {
            date = catchExceptionWithNewDate();
        } while (date == null);
    }
    
    public void getOrderFromConsole() {
        do {
            order = catchExceptionWithNewOrder();
        } while (order == null);
    }
}

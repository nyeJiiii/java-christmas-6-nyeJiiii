package christmas.exception;

import static christmas.view.InputView.readDate;

import christmas.domain.Date;

public class ExceptionCatcher {
    
    public static Date catchExceptionWithNewDate() {
        try {
            return new Date(readDate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

package christmas;

import static christmas.exception.ExceptionCatcher.catchExceptionWithNewDate;

import christmas.domain.Date;

public class ChristmasEvent {
    
    Date date = null;
    
    public void getDateFromConsole() {
        do {
            date = catchExceptionWithNewDate();
        } while (date == null);
    }
    
}

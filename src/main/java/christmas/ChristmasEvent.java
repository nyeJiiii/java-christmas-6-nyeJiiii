package christmas;

import static christmas.view.InputView.readDate;

import christmas.domain.Date;
import christmas.domain.User;

public class ChristmasEvent {
    
    User user = new User();
    
    public void getRightDate() {
        boolean success;
        do {
            success = getDate();
        } while (!success);
    }
    
    private boolean getDate() {
        try {
            user.setDate(new Date(readDate()));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}

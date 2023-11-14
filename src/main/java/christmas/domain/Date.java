package christmas.domain;

import static christmas.exception.ErrorMessage.WRONG_DATE;

public class Date {
    
    private static final int START_OF_DATE = 1;
    private static final int END_OF_DATE = 31;
    
    private int date;
    
    public Date(String stringDate) {
        int intDate = parseInt(stringDate);
        validateDate(intDate);
        this.date = intDate;
    }
    
    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_DATE);
        }
    }
    
    private void validateDate(int input) {
        if (!(START_OF_DATE <= input && input <= END_OF_DATE)) {
            throw new IllegalArgumentException(WRONG_DATE);
        }
    }
    
    
}

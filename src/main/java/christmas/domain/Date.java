package christmas.domain;

import static christmas.exception.ErrorMessage.WRONG_DATE;

public class Date {
    
    private static final int START_OF_DATE = 1;
    private static final int END_OF_DATE = 31;
    private static final int CHRISTMAS = 25;
    private static final int NUMBER_OF_WEEK = 7;
    private static final int FRIDAY = 1;
    private static final int SATURDAY = 2;
    private static final int SUNDAY = 3;
    
    private int date;
    
    public Date(String stringDate) {
        int intDate = parseInt(stringDate);
        validateRange(intDate);
        this.date = intDate;
    }
    
    public int getDate() {
        return date;
    }
    
    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_DATE);
        }
    }
    
    private void validateRange(int input) {
        if (!(START_OF_DATE <= input && input <= END_OF_DATE)) {
            throw new IllegalArgumentException(WRONG_DATE);
        }
    }
    
    public boolean isWeekend() {
        return date % NUMBER_OF_WEEK == FRIDAY ||
                date % NUMBER_OF_WEEK == SATURDAY;
    }
    
    public boolean isChristmas() {
        return date == CHRISTMAS;
    }
    
    public boolean isSunday() {
        return date % NUMBER_OF_WEEK == SUNDAY;
    }
    
    public boolean beforeChristmas() {
        return date <= CHRISTMAS;
    }
    
}

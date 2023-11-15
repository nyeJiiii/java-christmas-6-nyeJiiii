package christmas.domain;

public class Discount {
    
    public static final int MINIMUM_COST_FOR_BENEFIT = 10000;
    
    private ChristmasDiscount chistmasDiscount;
    private WeekdayDiscount weekdayDiscount;
    private WeekendDiscount weekendDiscount;
    private SpecialDiscount specialDiscount;
    
    public Discount(Date date, Order order) {
        int checkDate = date.getDate();
        if (date.beforeChristmas()) {
            chistmasDiscount = new ChristmasDiscount(checkDate);
        }
        if (!date.isWeekend()) {
            weekdayDiscount = new WeekdayDiscount(order);
        }
        if (date.isWeekend()) {
            weekendDiscount = new WeekendDiscount(order);
        }
        if (date.isSunday() || date.isChristmas()) {
            specialDiscount = new SpecialDiscount();
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (chistmasDiscount != null) {
            sb.append(chistmasDiscount);
        }
        if (weekdayDiscount != null) {
            sb.append(weekdayDiscount);
        }
        if (weekendDiscount != null) {
            sb.append(weekendDiscount);
        }
        if (specialDiscount != null) {
            sb.append(specialDiscount);
        }
        return sb.toString();
    }
}

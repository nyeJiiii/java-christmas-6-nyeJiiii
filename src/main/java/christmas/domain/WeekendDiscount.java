package christmas.domain;

import christmas.util.MenuType;

public class WeekendDiscount {
    
    private static final int DISCOUNT = -2023;
    
    private final int cost;
    
    public WeekendDiscount(Order order) {
        this.cost = order.countMenuType(MenuType.메인) * DISCOUNT;
    }
    
    @Override
    public String toString() {
        return String.format("주말 할인: %,d원\n", cost);
    }
}

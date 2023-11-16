package christmas.domain;

import christmas.util.MenuType;

public class WeekdayDiscount {
    
    private static final int DISCOUNT = -2023;
    
    private final int cost;
    
    public WeekdayDiscount(Order order) {
        this.cost = order.countMenuType(MenuType.디저트) * DISCOUNT;
    }
    
    public int getCost() {
        return cost;
    }
    
    @Override
    public String toString() {
        return String.format("평일 할인: %,d원\n", cost);
    }
}

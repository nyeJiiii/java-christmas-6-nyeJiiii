package christmas.domain;

public class SpecialDiscount {
    
    private static final int SPECIAL_DISCOUNT = -1000;
    
    private final int cost;
    
    public SpecialDiscount() {
        this.cost = SPECIAL_DISCOUNT;
    }
    
    public int getCost() {
        return cost;
    }
    
    @Override
    public String toString() {
        return String.format("특별 할인: %,d원\n", cost);
    }
}

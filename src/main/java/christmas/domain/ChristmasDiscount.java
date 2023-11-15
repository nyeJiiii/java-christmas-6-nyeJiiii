package christmas.domain;

public class ChristmasDiscount {
    
    private static final int CHRISTMAS = 25;
    private static final int BASE_DISCOUNT = -1000;
    private static final int DISCOUNT_PER_DAY = -100;
    
    private int cost;
    
    public ChristmasDiscount(int date) {
        if (date <= CHRISTMAS) {
            this.cost = BASE_DISCOUNT + DISCOUNT_PER_DAY * (date - 1);
        }
    }
    
    @Override
    public String toString() {
        return String.format("크리스마스 디데이 할인: %,d원\n", cost);
    }
}

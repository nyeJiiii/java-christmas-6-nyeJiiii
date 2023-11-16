package christmas.domain;

import static christmas.ChristmasEvent.NULL;

import christmas.util.Menu;
import java.util.HashMap;

public class GiftMenu {
    
    private static final int MINIMUM_COST_FOR_GIFT = 120000;
    private static final String NAME_OF_GIFT = "샴페인";
    private static final int COUNT_OF_GIFT = 1;
    private HashMap<Menu, Integer> menu;
    
    public GiftMenu(int totalCost) {
        if (totalCost >= MINIMUM_COST_FOR_GIFT) {
            HashMap<Menu, Integer> temp = new HashMap<>();
            temp.put(Menu.valueOf(NAME_OF_GIFT), COUNT_OF_GIFT);
            this.menu = temp;
        }
    }
    
    public String printCost() {
        return String.format("증정 이벤트: %,d원\n", calculateDiscountPrice());
    }
    
    public int returnDiscountPrice() {
        if (menu != null) {
            return calculateDiscountPrice();
        }
        return 0;
    }
    
    private int calculateDiscountPrice() {
        return menu.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue() * -1)
                .sum();
    }
    
    @Override
    public String toString() {
        if (menu == null) {
            return NULL;
        }
        StringBuilder sb = new StringBuilder();
        menu.forEach((menu, count) -> sb.append(menu.name()).append(" ").append(count).append("개"));
        return sb.toString();
    }
}
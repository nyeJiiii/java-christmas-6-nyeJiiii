package christmas.domain;

import christmas.util.Menu;
import java.util.HashMap;

public class GiftMenu {
    
    private static final int MINMUM_COST_FOR_GIFT = 120000;
    private static final String NAME_OF_GIFT = "샴페인";
    private static final int COUNT_OF_GIFT = 1;
    private static final String NULL = "없음";
    private HashMap<Menu, Integer> giftMenu;
    
    public GiftMenu(int totalCost) {
        if (totalCost >= MINMUM_COST_FOR_GIFT) {
            HashMap<Menu, Integer> temp = new HashMap<>();
            temp.put(Menu.valueOf(NAME_OF_GIFT), COUNT_OF_GIFT);
            this.giftMenu = temp;
        }
    }
    
    @Override
    public String toString() {
        if (giftMenu == null) {
            return NULL;
        }
        StringBuilder sb = new StringBuilder();
        giftMenu.forEach((menu, count) -> sb.append(menu.name()).append(" ").append(count).append("개\n"));
        return sb.toString();
    }
}
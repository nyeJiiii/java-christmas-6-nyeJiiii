package christmas;

import static christmas.domain.Badge.returnBadge;
import static christmas.domain.Discount.MINIMUM_COST_FOR_BENEFIT;
import static christmas.exception.ExceptionCatcher.catchExceptionWithNewDate;
import static christmas.exception.ExceptionCatcher.catchExceptionWithNewOrder;
import static christmas.view.OutputView.printBadge;
import static christmas.view.OutputView.printBenefit;
import static christmas.view.OutputView.printCost;
import static christmas.view.OutputView.printCostAfterDiscount;
import static christmas.view.OutputView.printGift;
import static christmas.view.OutputView.printOrder;
import static christmas.view.OutputView.printTotalBenefit;

import christmas.domain.Date;
import christmas.domain.Discount;
import christmas.domain.GiftMenu;
import christmas.domain.Order;

public class ChristmasEvent {
    
    public static final String NULL = "없음";
    
    Date date = null;
    Order order = null;
    GiftMenu giftMenu = null;
    Discount discount = null;
    int cost;
    int totalBenefit;
    
    public void getDateFromConsole() {
        do {
            date = catchExceptionWithNewDate();
        } while (date == null);
    }
    
    public void getOrderFromConsole() {
        do {
            order = catchExceptionWithNewOrder();
        } while (order == null);
    }
    
    public void showOrders() {
        printOrder();
        System.out.println(order);
    }
    
    public void showCost() {
        printCost();
        cost = order.calculateTotalPrice();
        System.out.printf("%,d원%n", cost);
    }
    
    public void showGift() {
        printGift();
        giftMenu = new GiftMenu(cost);
        System.out.println(giftMenu);
    }
    
    public void showBenefit() {
        printBenefit();
        if (cost < MINIMUM_COST_FOR_BENEFIT) {
            System.out.println(NULL);
        }
        if (cost >= MINIMUM_COST_FOR_BENEFIT) {
            discount = new Discount(date, order);
            System.out.print(discount);
            System.out.print(giftMenu.printCost());
        }
    }
    
    public void showTotalBenefit() {
        printTotalBenefit();
        totalBenefit = 0;
        if (giftMenu != null) {
            totalBenefit += giftMenu.returnDiscountPrice();
        }
        if (discount != null) {
            totalBenefit += discount.getTotalBenefit();
        }
        System.out.println(String.format("%,d원\n", totalBenefit));
    }
    
    public void showCostAfterDiscount() {
        printCostAfterDiscount();
        int costAfterDiscount = cost + totalBenefit;
        System.out.println(String.format("%,d원\n", costAfterDiscount));
    }
    
    public void showBadge() {
        printBadge();
        System.out.println(returnBadge(-totalBenefit));
    }
    
}

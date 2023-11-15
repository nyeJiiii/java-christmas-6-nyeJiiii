package christmas;

import static christmas.domain.Discount.MINIMUM_COST_FOR_BENEFIT;
import static christmas.exception.ExceptionCatcher.catchExceptionWithNewDate;
import static christmas.exception.ExceptionCatcher.catchExceptionWithNewOrder;
import static christmas.view.OutputView.printBenefit;
import static christmas.view.OutputView.printCost;
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
        System.out.printf("%,d원%n", order.calculateTotalPrice());
    }
    
    public void showGift() {
        printGift();
        giftMenu = new GiftMenu(order.calculateTotalPrice());
        System.out.println(giftMenu);
    }
    
    public void showBenefit() {
        printBenefit();
        if (order.calculateTotalPrice() < MINIMUM_COST_FOR_BENEFIT) {
            System.out.println(NULL);
        }
        if (order.calculateTotalPrice() >= MINIMUM_COST_FOR_BENEFIT) {
            discount = new Discount(date, order);
            System.out.print(discount);
            System.out.print(giftMenu.printCost());
        }
    }
    
    public void showTotalBenefit() {
        printTotalBenefit();
        int totalBenefit = 0;
        if (giftMenu != null) {
            totalBenefit += giftMenu.returnDiscountPrice();
        }
        if (discount != null) {
            totalBenefit += discount.getTotalBenefit();
        }
        System.out.println(String.format("%,d원\n", totalBenefit));
    }
    
}

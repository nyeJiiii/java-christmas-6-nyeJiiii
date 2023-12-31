package christmas;

import static christmas.view.OutputView.printHello;

public class Application {
    public static void main(String[] args) {
        ChristmasEvent christmasEvent = new ChristmasEvent();
        
        printHello();
        christmasEvent.getDateFromConsole();
        christmasEvent.getOrderFromConsole();
        
        christmasEvent.showOrders();
        christmasEvent.showCost();
        christmasEvent.showGift();
        christmasEvent.showBenefit();
        christmasEvent.showTotalBenefit();
        christmasEvent.showCostAfterDiscount();
        christmasEvent.showBadge();
    }
}

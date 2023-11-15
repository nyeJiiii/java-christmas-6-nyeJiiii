package christmas.view;

public class OutputView {
    public static void printHello() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }
    
    public static void printOrder() {
        System.out.println("\n<주문 메뉴>");
    }
    
    public static void printCost() {
        System.out.println("<할인 전 총주문 금액>");
    }
    
    public static void printGift() {
        System.out.println("\n<증정 메뉴>");
    }
    
    public static void printBenefit() {
        System.out.println("\n<혜택 내역>");
    }
    
    public static void printTotalBenefit() {
        System.out.println("\n<총혜택 금액>");
    }
    
    public static void printCostAfterDiscount() {
        System.out.println("<할인 후 예상 결제 금액>");
    }
    
    public static void printBadge() {
        System.out.println("<12월 이벤트 배지>");
    }
}

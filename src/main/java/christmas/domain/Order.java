package christmas.domain;

import static christmas.exception.ErrorMessage.WRONG_ORDER;

import christmas.util.Menu;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class Order {
    
    private static final String FIRST_ORDER_SPLITER = ",";
    private static final String SECOND_ORDER_SPLITER = "-";
    private static final int PAIR_OF_ORDER = 2;
    private static final int PART_OF_ORDER_NAME = 0;
    private static final int PART_OF_ORDER_COUNT = 1;
    private static final int MININUM_COUNT_OF_ORDER = 1;
    private HashMap<Menu, Integer> order;
    
    public Order(String stringOrder) {
        validateEnd(stringOrder, FIRST_ORDER_SPLITER);
        Stream<String[]> splittedOrders = splitOrder(stringOrder);
        this.order = validateOrders(splittedOrders);
    }
    
    private static void validateEnd(String order, String spliter) {
        if (order.endsWith(spliter)) {
            throw new IllegalArgumentException(WRONG_ORDER);
        }
    }
    
    private Stream<String[]> splitOrder(String input) {
        return Arrays.stream(
                        checkSplittedOrder(input.split(FIRST_ORDER_SPLITER))
                )
                .map(order -> order.split(SECOND_ORDER_SPLITER));
    }
    
    private String[] checkSplittedOrder(String[] orders) {
        for (String order : orders) {
            validateEnd(order, SECOND_ORDER_SPLITER);
        }
        return orders;
    }
    
    private HashMap<Menu, Integer> validateOrders(Stream<String[]> input) {
        try {
            return getOrders(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(WRONG_ORDER);
        }
    }
    
    private HashMap<Menu, Integer> getOrders(Stream<String[]> input) {
        HashMap<Menu, Integer> orderMap = input.collect(
                HashMap::new,
                (map, parts) -> {
                    checkLengthOfParts(parts);
                    putOrdersToMap(map, parts);
                },
                HashMap::putAll
        );
        return orderMap;
    }
    
    private static void putOrdersToMap(HashMap<Menu, Integer> map, String[] parts) {
        Menu menu = Menu.valueOf(parts[PART_OF_ORDER_NAME].trim());
        checkDuplicatedMenu(map.containsKey(menu));
        
        int count = Integer.parseInt(parts[PART_OF_ORDER_COUNT].trim());
        checkIsOverZero(count < MININUM_COUNT_OF_ORDER);
        
        map.put(menu, count);
    }
    
    private static void checkIsOverZero(boolean count) {
        if (count) {
            throw new IllegalArgumentException(WRONG_ORDER);
        }
    }
    
    private static void checkDuplicatedMenu(boolean map) {
        if (map) {
            throw new IllegalArgumentException(WRONG_ORDER);
        }
    }
    
    private static void checkLengthOfParts(String[] parts) {
        if (parts.length != PAIR_OF_ORDER) {
            throw new IllegalArgumentException(WRONG_ORDER);
        }
    }
    
    @Override
    public String toString() {
        return "Order{" +
                "order=" + order +
                '}';
    }
    
}

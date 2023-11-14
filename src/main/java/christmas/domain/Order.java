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
        return input.collect(
                () -> new HashMap<>(),
                (map, parts) -> {
                    checkLengthOfParts(parts);
                    map.put(
                            Menu.valueOf(parts[PART_OF_ORDER_NAME].trim()),
                            Integer.parseInt(parts[PART_OF_ORDER_COUNT].trim())
                    );
                },
                HashMap::putAll
        );
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

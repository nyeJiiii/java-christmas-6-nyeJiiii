package christmas.domain;

public class Badge {
    
    private static final String NOTHING = "없음";
    private static final String STAR = "별";
    private static final String TREE = "트리";
    private static final String SANTA = "산타";
    
    private static final int FIRST_RANGE = 5000;
    private static final int SECOND_RANGE = 10000;
    private static final int THIRD_RANGE = 20000;
    
    public static String returnBadge(int benefit) {
        if (THIRD_RANGE <= benefit) {
            return SANTA;
        }
        if (SECOND_RANGE <= benefit) {
            return TREE;
        }
        if (FIRST_RANGE <= benefit) {
            return STAR;
        }
        return NOTHING;
    }
}

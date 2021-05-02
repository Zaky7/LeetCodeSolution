package src.tree.verticalorder;


import java.util.*;

public class VerticalOrder {

    public static void main(String[] args) {

        Map<Integer, List<Integer>> sortedColMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        sortedColMap.put(-1, new ArrayList<>());
        sortedColMap.put(-2, new ArrayList<>());
        sortedColMap.put(0, new ArrayList<>());


        System.out.println(sortedColMap.toString());
    }

}

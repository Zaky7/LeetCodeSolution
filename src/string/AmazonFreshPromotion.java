package string;

import java.util.ArrayList;
import java.util.List;

public class AmazonFreshPromotion {

    private static final int WIN = 1;
    private static final int LOSE = 0;

    public int isReceivePrize(List<List<String>> codeList, List<String> shoppingList) {
        if(codeList.isEmpty() || shoppingList.isEmpty()) {
            return LOSE;
        }

        int result = LOSE;
        int start = 0;
        for(List<String> codeListGroup: codeList) {

            int patternIndex = groupPresent(codeListGroup, shoppingList, start);

            if(patternIndex == -1) {
                result = LOSE;
                break;
            } else {
                result = WIN;
                start = patternIndex + codeListGroup.size();
            }

        }

        return result;
    }

    private int groupPresent(List<String> codeListGroup, List<String> shoppingList, int start) {
        if(start > shoppingList.size() || codeListGroup.size() == 0) {
            return -1;
        }

        int fruitIndex = 0;
        for(int i=0; i<codeListGroup.size(); i++) {
            if(codeListGroup.get(i) != "anything") {
                fruitIndex = i;
                break;
            }
        }

        if(fruitIndex == codeListGroup.size()) {
            return start;
        }

        int i = start;
        int result = -1;

        while (i<shoppingList.size()) {
            if(codeListGroup.get(fruitIndex) == shoppingList.get(i)) {
                boolean matched = false;
                int k = fruitIndex;

                for(int j=i; j<(i + codeListGroup.size() - fruitIndex); j++) {
                    if(codeListGroup.get(k) == shoppingList.get(j)) {
                        matched = true;
                        k++;
                    } else if(codeListGroup.get(k) == "anything") {
                        matched = true;
                        k++;
                    } else {
                        matched = false;
                        break;
                    }
                }

                if(matched == true && k == codeListGroup.size()) {
                    return i;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        return -1;
     }

     private static void test(String[][] codeList1, String[] shoppingCart1, int expectedResult) {
         AmazonFreshPromotion afp = new AmazonFreshPromotion();
         List<List<String>> codeList = getCodeList(codeList1);
         List<String> shoppingList = getShoppingList(shoppingCart1);
//         int result = afp.isReceivePrize(codeList, shoppingList);
         int result = winner(codeList1, shoppingCart1);

         if(result == expectedResult) {
             System.out.println("Pass!!");
         } else {
             System.out.println("Fail for: " + codeList1.toString() + " " + shoppingCart1.toString());
         }
         

     }

    public static void main(String[] args) {
        String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList2 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
        String[][] codeList3 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
        String[][] codeList4 = { { "apple", "apple" }, { "apple", "apple", "banana" } };
        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
        String[][] codeList5 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList6 = { { "apple", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList7= { { "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList8 = {{"apple", "orange"}, {"orange", "banana", "orange"}};
        String[] shoppingCart8 = {"apple", "orange", "banana", "orange", "orange", "banana", "orange", "grape"};
        String[][] codeList9= { { "anything", "anything", "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart9 = {"orange", "apple", "banana", "orange", "apple", "orange", "orange", "banana", "apple", "banana"};

        // test
        test(codeList1, shoppingCart1, 1);
        test(codeList2, shoppingCart2, 0);
        test(codeList3, shoppingCart3, 0);
        test(codeList4, shoppingCart4, 0);
        test(codeList5, shoppingCart5, 1);
        test(codeList6, shoppingCart6, 1);
        test(codeList7, shoppingCart7, 1);
        test(codeList8, shoppingCart8, 1);
        test(codeList9, shoppingCart9, 1);
    }


    public static int winner(String[][] codes, String[] shoppingCart){
        StringBuilder regex = new StringBuilder(".*");

        for(String[] code : codes){
            for(String str : code){
                regex.append(str.equals("anything") ? ".+" : str);
            }
            regex.append(".*");
        }

        StringBuilder cart = new StringBuilder();

        for(String str : shoppingCart){
            cart.append(str);
        }

        System.out.println(regex.toString());
        System.out.println(cart.toString());


        return cart.toString().matches(regex.toString()) ? 1 : 0;
    }


    private static List<List<String>> getCodeList(String[][] codeList1) {
        List<List<String>> list = new ArrayList<>();

        for(String[] string: codeList1) {
            List<String> subList = new ArrayList<>();
            for(String str: string) {
                subList.add(str);
            }

            list.add(subList);
        }
        return list;
    }

    private static List<String> getShoppingList(String[] shoppingCart1) {
        List<String> list = new ArrayList<>();
        for(String str: shoppingCart1) {
            list.add(str);
        }
        return list;
    }
}

package recursion;

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> parenthesisList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateParenthesisUtil(parenthesisList, sb, 0, 0, n);

        return parenthesisList;
    }

    private void generateParenthesisUtil(List<String> parenthesisList, StringBuilder sb, int openingCount, int closingCount, int n) {
        System.out.println(sb.toString() + " opening: " + openingCount + " closing: " + closingCount);
        if(closingCount == n) {
            parenthesisList.add(sb.toString());
            return;
        } else {
            if(openingCount > closingCount) {
                sb.append(")");
                generateParenthesisUtil(parenthesisList, sb, openingCount, closingCount + 1, n);
                sb.deleteCharAt(sb.length() - 1);
            }

            if(openingCount < n) {
                sb.append("(");
                generateParenthesisUtil(parenthesisList, sb, openingCount + 1, closingCount, n);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        List<String> parenthesisList = gp.generateParenthesis(3);
        System.out.println(parenthesisList.toString());
    }
}
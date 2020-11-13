package string;

import java.util.Stack;

class DecodeString {

    public String decodeString(String s) {
        Stack<String> stk = new Stack<>();
        int n = s.length();
        int i = 0;

        while(i < n) {

            // System.out.println(" Current char: " + s.charAt(i));

            if(s.charAt(i) == '[') {
                stk.push("[");
                i++;
            } else if(isDigit(s.charAt(i))) {
                StringBuilder sb = new StringBuilder();

                while(i<n && isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }

                // push resultant num string in the stack
                stk.push(sb.toString());
            } else if(isAlpha(s.charAt(i))) {
                StringBuilder sb = new StringBuilder();

                while(i<n && isAlpha(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }

                // push resultant num string in the stack
                stk.push(sb.toString());
            } else if(s.charAt(i) == ']') {
                StringBuilder alphabetBuilder = new StringBuilder();
                int digit = 0;


                while(!stk.isEmpty() && stk.peek() != "[") {
                    String popStr = stk.pop();
                    // System.out.println("String: " + popStr + " isAlpha: " + isAlpha(popStr.charAt(0)) + " peek: " + stk.peek());
                    if(isAlpha(popStr.charAt(0))) {
                        alphabetBuilder.insert(0,popStr);
                    }
                }

                if(stk.peek() == "[") {
                    stk.pop();
                }


                if(!stk.isEmpty() && isDigit(stk.peek().charAt(0))) {
                    digit = Integer.parseInt(stk.pop());
                }


                String decodeStr = repeat(alphabetBuilder, digit);

                // System.out.println("DecodeString Length: " + decodeStr.trim().length());

                if(decodeStr.length() > 0) {
                    stk.push(decodeStr);
                }
                i++;

            } else {
                System.out.println("String is not valid at index: " + i + " char: " + s.charAt(i));
            }

        }

        StringBuilder sb = new StringBuilder();

        while(!stk.isEmpty()) {
            sb.insert(0, stk.pop());
        }


        return sb.toString();
    }

    private static String repeat(StringBuilder singleBuilder, int repetition) {
        StringBuilder resultBuilder = new StringBuilder();

        if(singleBuilder.length() > 0) {
            while(repetition > 0) {
                resultBuilder.append(singleBuilder);
                repetition--;
            }
        }

        return resultBuilder.toString();
    }

    private static boolean isDigit(char ch) {
        int code = (int) ch;
        return code >= 48 && code <= 57;
    }

    private static boolean isAlpha(char ch) {
        int code = (int) ch;
        boolean isLower = code >= 97 && code <= 122;
        boolean isUpper = code >= 65 && code <= 90;
        return isLower || isUpper;
    }

    public static void main(String[] args) {
        String  str = "2[abc]3[cd]ef";
        DecodeString ds = new DecodeString();
        String decodedString = ds.decodeString(str);
        System.out.println(decodedString);
    }
}
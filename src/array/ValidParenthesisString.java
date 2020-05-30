import java.util.Stack;

class ValidParentThesisString {

  public boolean checkValidString(String s) {
    Stack<Character> stack = new Stack<>();
    int n = s.trim().length();

    System.out.println(s);

    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);

      System.out.println("Index: " + i + " StacSize " + stack.size() + " Character: " + ch);
      // Push into the stack if it empty
      if (stack.isEmpty()) {
        stack.push(ch);
      } else {
        // If left parenthesis always push to the stack
        switch (ch) {
          case '(':
            stack.push(ch);
            break;
          case ')':
            if (stack.peek() == '(' || stack.peek() == '*') {
              stack.pop();
            } else {
              stack.push(ch);
            }
            break;
          default:
            // (*) consider * as ''
            if (stack.peek() == '(') {
              if (isIndexWithRange(i, n) == true && s.charAt(i + 1) == ')') {
                // skip x is empty String
              } else {
                // case (*
                stack.pop();
              }
            } else if (stack.peek() == '*') {
              // case **
              stack.pop();
            } else {
              // case )*
              stack.push(ch);
            }
            break;
        }
      }
    }

    return stack.empty();
  }

  private boolean isIndexWithRange(int i, int n) {
    return i > 0 && i < (n - 1);
  }

  public static void main(String[] args) {
    ValidParentThesisString vts = new ValidParentThesisString();
    String[] str = { "()", "*((", "**", "((*))", "(", " ", "(*" };

    for (int i = 0, n = str.length; i < n; i++) {
      System.out.println("String: " + str[i] + " is valid " + vts.checkValidString(str[i]));
    }
  }
}

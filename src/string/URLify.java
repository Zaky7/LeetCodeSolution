package string;

public class URLify {

    private String URLifyString(String str) {
        String trimedString = str.trim();
        char[] charArr = trimedString.toCharArray();
        str = str.replaceAll("\\s", "%20");
        return str;
    }

    public static void main(String[] args) {
        URLify u = new URLify();
//        String ans = u.URLifyString("My Name is Zakir");
//        System.out.println(ans);

          System.out.println(factorial(5));
    }

    private static int factorial(int num) {
        if(num == 0 || num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    private void swap(StringBuilder sb, int i, int j)
    {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
        System.out.println(sb.toString());
    }
}

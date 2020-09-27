package stack;

public class TwoStackWithArr {

    private static class Stack {
        int[] arr;
        int p1, p2, n;
        final static String STACK_OVER_FLOW_ERROR = "Stack is Full!!!";
        final static String STACK_EMPTY_ERROR = "Stack is Empty!!!";

        Stack(int n) {
            arr = new int[n];
            p1 = -1;
            p2 = n;
            this.n = n;
        }

        public void push1(int ele) {
            if(p1 < p2) {
                arr[++p1] = ele;
            } else {
                throw new IllegalStateException(STACK_OVER_FLOW_ERROR);
            }
        }

        public int pop1() {
            if(p1 > -1) {
                int ele = arr[p1];
                arr[p1--]= 0;
                return ele;
            } else {
                throw new IllegalStateException(STACK_EMPTY_ERROR);
            }
        }

        public void push2(int ele) {
            if(p2 > p1) {
                arr[--p2] = ele;
            } else {
                throw new IllegalStateException(STACK_OVER_FLOW_ERROR);
            }
        }

        public int pop2() {
            if(p2 < n) {
                int ele = arr[p2];
                arr[p2++] = 0;
                return ele;
            } else {
                throw new IllegalStateException(STACK_EMPTY_ERROR);
            }
        }

        public void print1() {
            for(int i=p1; i>-1; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        public void print2() {
            for(int i=p2; i<n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack(10);
        s.push1(1);
        s.push1(2);
        s.push1(3);
        s.push1(4);
        s.push1(5);
        s.push1(7);
        s.push1(8);
        s.push1(9);

        s.print1();

        s.push2(6);
        s.push2(7);
        s.push2(8);


        s.print2();
    }
}

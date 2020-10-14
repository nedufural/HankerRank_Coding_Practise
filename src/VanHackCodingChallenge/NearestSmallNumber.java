package VanHackCodingChallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallNumber {
    public static void prevSmallerNumber(int[] a) {
        Stack<Integer> s = new Stack<Integer>();
        List<Integer> arr = new ArrayList<>();
        int popped = 0;

        for (int i = 0; i < a.length; i++) {
            while (!s.isEmpty() && s.peek() >= a[i]) {
                popped = s.pop();
            }
            if (s.isEmpty()) {
                System.out.print("_, ");
                arr.add(-1);
            } else {
                System.out.print(s.peek() + ", ");
                arr.add(s.peek());
            }

            s.push(a[i]);
        }
        System.out.println("");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) +",");

        }
    }

    public static void main(String[] args) {
        int[] a = {1, 6, 4, 10, 2, 5};
        prevSmallerNumber(a);
    }
}

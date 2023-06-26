package medium;

import java.util.Iterator;
import java.util.Stack;

public class RemoveStars {

    public static void main(String[] args) {
        String s = "leet**cod*e";

        RemoveStars removeStars = new RemoveStars();
        System.out.println(removeStars.removeStars(s));

    }

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Character> it = stack.stream().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }

        return sb.toString();
    }
}

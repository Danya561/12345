package lab1_1;

import java.util.ArrayDeque;

public class lab1_1 {

    public static void main(String[] args) {
        String str = "{[()]}";
        System.out.println(provStrok(str));
    }

    static boolean provStrok(String str) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                // открывающую скобку кладём в стек
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                // закрывающая скобка: достаём последнюю открытую и сверяем
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();

                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
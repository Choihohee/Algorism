package ch01.Beakjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;

        while (true) {
            s = br.readLine();

            if (s.equals("."))
                break;
            sb.append(check(s)).append("\n");
        }
        System.out.println(sb);
    }
    public static String check(String s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //'(' 또는 '[' 일 경우 stack에 push
            if (c == '(' || c == '['){
                stack.push(c);
            }

            //')'일 경우
            else if (c == ')') {
                //stack이 비었거나 pop 할 문자가 (가 아닌 경우
                if (stack.empty() || stack.peek() != '(')
                    return "no";
                else
                    stack.pop();
            }
            //']'일 경우
            else if (c == ']') {
                //stack이 비었거나 pop 할 문자가 [가 아닌 경우
                if (stack.empty() || stack.peek() != '[')
                    return "no";
                else
                    stack.pop();
            }
        }
        if (stack.empty())
            return "yes";
        else
            return "no";
    }
}

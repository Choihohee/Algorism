package ch01.Beakjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            sb.append(check(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }
    public static String check(String x){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            // '(' 일 경우 스택에 push
            if (c == '(')
                stack.push(c);
            //')' 이 나왔지만 스택이 비어있는 경우
            else if (stack.empty())
                return "NO";
            else
                stack.pop();
        }
        if (stack.empty())
            return "YES";
        else
            return "NO";
    }
}

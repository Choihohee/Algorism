package ch01.Beakjoon.stack;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        Stack<Character> stack = new Stack<>();
        
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(')
                stack.push(c);
            if (c == ')'){
                stack.pop();
                if (s.charAt(i - 1) == '('){
                    count += stack.size();
                }else
                    count++;
            }
        }
        System.out.println(count + "\n");
    }
}

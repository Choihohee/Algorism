package ch01.Beakjoon.stack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Stack<String> left = new Stack<>();
            Stack<String> right = new Stack<>();
            String input = br.readLine();

            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);

                switch (ch){
                    case '-':
                        if (!left.empty())
                            left.pop();
                        break;
                    case '<':
                        if (!left.isEmpty())
                            right.push(left.pop());
                        break;

                    case '>':
                        if (!right.isEmpty())
                            left.push(right.pop());
                        break;

                    default:
                        left.push(String.valueOf(ch));
                }
            }

            while (!left.isEmpty())
                right.push(left.pop());
            while (!right.isEmpty())
                sb.append(right.pop());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

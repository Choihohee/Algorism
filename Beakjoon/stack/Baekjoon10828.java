package ch01.Beakjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon10828 {
    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command){
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (stack.isEmpty())
                        stringBuilder.append(-1).append("\n");
                    else
                        stringBuilder.append(stack.pop()).append("\n");
                    break;
                case "size":
                    stringBuilder.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if (stack.isEmpty())
                        stringBuilder.append(1).append("\n");
                    else
                        stringBuilder.append(0).append("\n");
                    break;
                case "top":
                    if (stack.isEmpty())
                        stringBuilder.append(-1).append("\n");
                    else
                        stringBuilder.append(stack.peek()).append("\n");
                    break;
            }
        }
        System.out.println(stringBuilder);
    }
}

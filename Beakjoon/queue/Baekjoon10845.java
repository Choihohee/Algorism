package ch01.Beakjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon10845 {

    static Queue<Integer> queue = new LinkedList<>();
    static int last = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(pop()).append("\n");
                    break;

                case "size":
                    sb.append(size()).append("\n");
                    break;

                case "empty":
                    sb.append(empty()).append("\n");
                    break;

                case "front":
                    sb.append(front()).append("\n");
                    break;

                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
    public static void push(int x){
        queue.add(x);
        last = x;
    }
    public static int pop(){
        if (queue.isEmpty())
            return -1;
        else
            return queue.poll();
    }
    public static int size(){
        return queue.size();
    }
    public static int empty(){
        if (queue.isEmpty())
            return 1;
        else
            return 0;
    }
    public static int front(){
        if (queue.isEmpty())
            return -1;
        else
            return queue.peek();
    }
    public static int back(){
        if (queue.isEmpty())
            return -1;
        else
            return last;
    }
}

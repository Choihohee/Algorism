package ch01.Beakjoon.deque;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baekjoon1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        int count =0;

        for (int i = 0; i < N; i++) {
            deque.offer(i);
        }
        int[] rotating_queue = new int[M];   //뽑을 수를 넣은 배열
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            rotating_queue[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            int target = deque.indexOf(rotating_queue[i]);
            int half_index;

            if (deque.size() % 2 == 0)
                half_index =deque.size() / 2-1;
            else
                half_index = deque.size() / 2;

            if (target <= half_index){
                for (int j = 0; j < target; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
            }
            else {
                for (int j = 0; j < deque.size() - target; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}

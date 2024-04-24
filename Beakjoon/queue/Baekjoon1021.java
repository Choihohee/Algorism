package ch01.Beakjoon.queue;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baekjoon1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        LinkedList<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;

        // 큐에 1부터 N까지의 수를 삽입
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        // 뽑을 수를 입력받아 순회하면서 회전 횟수를 계산
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            // 뽑을 수의 인덱스를 찾아서 회전 횟수를 계산
            int index = deque.indexOf(target);

            // 인덱스에 따라 회전 횟수 계산
            int rotateCount = Math.min(index, deque.size() - index);

            // 회전 후 뽑기
            for (int j = 0; j < rotateCount; j++) {
                if (deque.peekFirst() == target) {
                    deque.pollFirst();
                } else if (deque.peekLast() == target) {
                    deque.pollLast();
                } else {
                    int first = deque.pollFirst();
                    deque.offerLast(first);
                    count++;
                }
            }
            // 뽑기
            deque.pollFirst();
        }

        System.out.println(count);
    }
}
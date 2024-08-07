package ch01.Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [][] times = new int[N][2];
        /*
        times[][0] 은 시작시점
        times[][1] 은 종료시점
         */

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {

                //종료 시간이 같은 경우 시작시간이 빠른 순으로 정렬
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int prev_end_time = 0;

        for (int i = 0; i < N; i++) {
            //직전의 종료시간이 다음 회의 시작 시간보다 작거나 같을시 갱신해줌
            if (prev_end_time <= times[i][0]) {
                prev_end_time = times[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}

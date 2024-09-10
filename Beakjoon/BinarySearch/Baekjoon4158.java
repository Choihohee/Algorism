package ch01.Beakjoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon4158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            int arr1[] = new int[N];
            int arr2[] = new int[M];

            for (int i = 0; i < N; i++) {
                arr1[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < M; i++) {
                arr2[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);

            int count = 0;  //동시에 가지고 있는 CD 수
            int i = 0, j = 0;
            while (i < N && j < M) {
                if (arr1[i] == arr2[j]) {
                    count++;
                    i++;
                    j++;
                } else if (arr1[i] > arr2[j]) {
                    j++;
                } else
                    i++;
            }
            System.out.println(count);
        }
    }
}

package ch01.Beakjoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        long arr[] = new long[n+1]; //일급 배열

        //누적합
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }
        long sum = 0;   //정한 구간의 합
        long res = 0;   //합들을 비교해야하니까 res 선언

        //슬라이딩 윈도우
        for (int i = 0; i <= n-m; i++) {
            sum = arr[i+m] - arr[i];
            res = Math.max(res, sum);
        }
        System.out.println(res);
    }
}

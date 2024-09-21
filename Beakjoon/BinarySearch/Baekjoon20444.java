package ch01.Beakjoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon20444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long left = 0;
        long right = n / 2;

        while(left <= right) {
            long row = (left + right) / 2;
            long col = n - row;

            long total = cuttingPaper(row, col);
            if(total == k) {
                System.out.println("YES");
                return;
            } else if(total > k) { //row col의 차이가 더 커야한다.
                right = row - 1;
            } else if (total < k){
                left = row + 1;
            }
        }
        System.out.println("NO");
    }

    public static long cuttingPaper(long row, long col) {
        return (row + 1) * (col + 1);
    }
}

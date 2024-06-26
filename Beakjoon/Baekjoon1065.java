package ch01.Beakjoon;

import java.util.Scanner;
//한수 구하기
public class Baekjoon1065 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print(arithmetic_sequence(in.nextInt()));
        in.close();
    }

    public static int arithmetic_sequence(int n) {
        int cnt = 0; // 한수 카운트

        if (n < 100)
            return n;
        else {
            cnt = 99;
            for (int i = 100; i <= n; i++) {
                int hun = i / 100;	// 백의 자릿수
                int ten = (i / 10) % 10; // 십의 자릿수
                int one = i % 10;

                if ((hun - ten) == (ten - one))	// 각 자릿수가 수열을 이루면
                    cnt++;
            }
        }
        return cnt;
    }
}

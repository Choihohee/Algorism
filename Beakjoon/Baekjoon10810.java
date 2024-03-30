package ch01.Beakjoon;

import java.util.Scanner;

public class Baekjoon10810 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //이만큼 바구니가 있다.
        int Basket[] = new int[N];
        int M = sc.nextInt();

        for (int i = 0; i < M; i++) {   //t = try라는 뜻
            int I = sc.nextInt();   //i번 바구니부터
            int J = sc.nextInt();   //j번 바구니까지
            int K = sc.nextInt();   //k 번호가 적힌 공을 넣을 것임
            for (int o = I-1; o < J; o++) {
                Basket[o] = K;
            }
        }
        for (int j = 0; j <= Basket.length ; j++) {
            System.out.print(Basket[j] + " ");

        }

    }
}

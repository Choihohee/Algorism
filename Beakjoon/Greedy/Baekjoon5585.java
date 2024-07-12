package ch01.Beakjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = Integer.parseInt(br.readLine());  //지불할 금액
        int change = 1000 - money; //거스름돈

        int[] coins = {500, 100, 50, 10, 5, 1};  //잔돈으로 줄 수 있는 돈 종류

        int count = 0;  //잔돈의 갯수

        for (int i = 0; i < coins.length; i++) {

            //현재의 돈 종류로 거슬러 줄 수 있는 최대의 갯수를 결과에 더함
            count += change / coins[i];
            //남은 거스름돈을 현재의 돈 종류로 나눈 나머지로 갱신
            change = change % coins[i];
        }
        System.out.print(count);
    }
}

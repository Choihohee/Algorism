package ch01.Beakjoon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num[] = new int[9];
        int MAX_NUM = 0;

        for (int i = 0; i < num.length; i++) {
            num[i] = scanner.nextInt();
        }
        for (int j = 1; j < num.length; j++) {
            MAX_NUM = num[0];
            if (MAX_NUM < num[j]) {
                MAX_NUM = num[j];
            }
            //System.out.println(MAX_NUM);
            //System.out.println(MIN_NUM);
        }
    }
}

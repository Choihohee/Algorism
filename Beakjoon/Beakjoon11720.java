package ch01.Beakjoon;

import java.util.Scanner;

public class Beakjoon11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String inputNumber = scanner.next();
        scanner.close();
        int sum=0;

        for (int i = 0; i < n; i++) {
            sum += inputNumber.charAt(i) - '0';
        }
        System.out.println(sum);
    }
}

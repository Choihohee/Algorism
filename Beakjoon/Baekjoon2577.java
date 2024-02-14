package ch01.Beakjoon;

import java.util.Scanner;

public class Baekjoon2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int num = (A*B*C);
        String str = Integer.toString(num); //형변환
        sc.close();

        for (int i = 0; i < 10; i++) {
            int count = 0;
            for (int j = 1; j <= str.length(); j++) {
                if ((str.charAt(j)) == i )
                    count++;
            }
            System.out.println(count);
        }
    }
}

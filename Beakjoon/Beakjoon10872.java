package ch01.Beakjoon;
import java.util.Scanner;
//팩토리얼

public class Beakjoon10872 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.close();

        int sum = factorial(N);
        System.out.println(sum);

    }

    public static int factorial(int N) {
        if(N <= 1) return 1;	// 재귀 종료조건
        return N * factorial(N - 1);
    }
}

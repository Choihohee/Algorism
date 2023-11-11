package ch01.Beakjoon;
import java.util.Scanner;
//코딩은 체육과목 입니다
// 1-4바이트까지 long 5-8바이트 까지 long long ..

public class Baekjoon25314 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n / 4; i++) {
            System.out.print("long ");
        }
        System.out.print("int");
    }
}

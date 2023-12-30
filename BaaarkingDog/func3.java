package ch01.BaaarkingDog;

import java.util.Scanner;

public class func3 {
    public static int fun_3(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 1; i * i <= N; i++) {
            if (i * i == N ){
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(fun_3());
    }
}

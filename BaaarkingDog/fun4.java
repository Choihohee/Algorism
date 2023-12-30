package ch01.BaaarkingDog;

import java.util.Scanner;

public class fun4 {

    public static int func_4(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int val = 1;
        while (2 * val <= N) {
            val = val / 2;
            return val;
        }
    }
    public static void main(String[] args) {
        System.out.println(func_4());
    }
}

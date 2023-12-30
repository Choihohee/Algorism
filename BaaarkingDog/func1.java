package ch01.BaaarkingDog;

import java.util.Scanner;

public class func1 {

    public static int func(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum=0;

        for (int i = 1; i <= N; i++) {
            if (i % 3 == 0 || i % 5 == 0) sum += i;
        } return sum;
    }

    public static void main(String[] args) {
        System.out.println(func());
    }
}
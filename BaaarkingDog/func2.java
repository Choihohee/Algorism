package ch01.BaaarkingDog;

import java.util.Scanner;


public class func2 {
    public static int func_2() {
        Scanner sc = new Scanner(System.in);
        int N;
        N= sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            for (int j = i+1; j <N; j++) {
                if (arr[i] + arr[j] == 100) return 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(func_2());
    }
}

package ch01.Beakjoon;

import java.util.Scanner;

public class Baekjoon2018 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        int sum = 1;
        int start = 1;
        int end = 1;
        int count = 1;

        while (start!=input){

            if(sum < input){
                end++;
                sum += end;
            } else if (sum > input) {
                sum -= start;
                start++;
            }else {
                count++;
                end++;
                sum += end;
            }
        }
        System.out.println(count);
}

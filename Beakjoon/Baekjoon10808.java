package ch01.Beakjoon;

import java.util.Scanner;

public class Baekjoon10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int arr[] = new int[26];    //알파벳 갯수 저장

        //아스키코드 값 사용
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            arr[c - 97]++;  //갯수 1 늘려줌
        }
        //출력
        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

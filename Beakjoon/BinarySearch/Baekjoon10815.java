package ch01.Beakjoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10815 {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); //상근이의 카드 개수

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++){
            int num = Integer.parseInt(st.nextToken());
            System.out.println(BinarySeach(num) + " ");
        }
    }

    public static int BinarySeach(int num){
        int left = 0;
        int right = n-1;

        while(left <= right){
            int middle = (left + right)/2;
            int middleValue = arr[middle];

            if(num > middleValue){
                left = middle +1;
            }else if(num < middleValue){
                right = middle -1;
            }else
                return 1;
        }
        return 0;
    }
}

package ch01.Beakjoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Baekjoon11687 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        int left = 1;
        int right = M*5;

        boolean check = false;

        while(left <= right){
            int middle = (left+right) / 2;
            if(binary(middle) > M){
                right = middle-1;
            } else if(binary(middle) == M){
                right = middle-1;
                check = true;
            }
            else{
                left = middle+1;
            }
        }

        if(check){
            System.out.println(left);
        }else{
            System.out.println(-1);
        }
    }

    private static int binary(int mid){
        int count=0;

        for(int i=5; i<=mid; i*=5){
            count+=(mid/i);
        }
        return count;
    }
}
package ch01.Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2003 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //투포인터 핵심로직
        int sum = 0;    //누적합
        int start = 0, end = 0, count=0;

        while(true) {
            if(sum >= m) {  //sum이 m보다 크거나 같은 경우
                sum = sum - arr[start++];   //현재까지의 누적합에서 arr[start++] 배열을 뺀다.
            }else if(end == n) {  // end가 맨 끝에 도착했을 경우
                break; //반복문 끝
            } else {    //sum이 m보다 작을 경우
                sum = sum + arr[end++]; //현재까지의 누적합에서 arr[end++] 배열을 합한다.
            }
            if(sum == m) {
                count++;    // sum과 m이 일치하는 경우 count를 증가시킨다
            }
        }
        System.out.println(count);
    }
}
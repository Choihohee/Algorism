package ch01.Beakjoon.DFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15658 {

    static int N;
    static int arr[];
    static int operator[] = new int[4];

    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);
        System.out.println(max + "\n" + min);
    }

    private static void dfs(int count, long result) {
        //연산 끝난 경우 최대값 최솟값 갱신
        if(count == N){
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }

        for (int command = 0; command < 4; command++) {
            if (operator[command] > 0){
                operator[command] -= 1;
                switch (command){

                    case 0: //+
                        dfs(count + 1, result + arr[count]);
                        break;
                    case 1: //-
                        dfs(count + 1, result - arr[count]);
                        break;
                    case 2: //*
                        dfs(count + 1, result * arr[count]);
                        break;
                    case 3: // /
                        dfs(count + 1, result / arr[count]);
                        break;
                }
                operator[command] += 1;
            }
        }
    }
}

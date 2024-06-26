package ch01.Beakjoon.DFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15650 {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static boolean[] visit;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        arr = new int[M];
        dfs(0,0);

        System.out.println(sb);

    }
    public static void dfs(int depth, int start){
        if(depth == M){
            for (int val : arr) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            if (!visit[i]){
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}

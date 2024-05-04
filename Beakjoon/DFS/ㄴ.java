package ch01.Beakjoon.DFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4963 {
    static int[][] arr;
    static boolean[][] visitied;

    static int[] dx = {-1, -1, 0, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 0, -1, -1, -1};

    static int w;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        while(true){

            w = Integer.parseInt(stringTokenizer.nextToken());
            h = Integer.parseInt(stringTokenizer.nextToken());
            int count = 0;

            arr = new int[w][h]; // 0
            visitied = new boolean[w][h]; //모두 false

            for(int i=0; i<w; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j=0; j<h; j++){
                    arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            for(int i=0; i<w; i++){
                for(int j=0; j<h; j++){
                    if(arr[i][j] == 1 && !visitied[i][j]){
                        DFS(i,j);
                        count++;
                    }
                }
            }



        }
    }

    private static void DFS(int x, int y){
        visitied[x][y] = true;

        for(int i=0; i<8; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(//새로운 좌표값이 배열 안에 있거나, 방문하지 않앗을때){
            DFS(newX, newY);
        }

    }
}
}
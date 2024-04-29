package ch01.Beakjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());    //테스트 케이스 몇 번

        Queue<Integer>queue = new LinkedList<>();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());    //문서의 갯수
            String M = br.readLine();   //중요도
        }
    }
}

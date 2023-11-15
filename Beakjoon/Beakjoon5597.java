package ch01.Beakjoon;

import java.util.Scanner;

public class Beakjoon5597 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int students[] = new int[30];

		for (int j = 0; j < 28; j++) {
			int check = sc.nextInt();
			students[check-1] = 1;

		}
		for (int i = 0; i < 30; i++) {
			if (students[i] == 0){
				System.out.println(i+1);
			}
		}
	}
}


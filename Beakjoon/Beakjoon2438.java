package ch01.Beakjoon;

import java.util.Scanner;
//별 찍기(1)
public class Beakjoon2438 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();	//총 금액
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}

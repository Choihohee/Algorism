package ch01.Beakjoon;

import java.util.Scanner;
//상수
public class Beakjoon2908 {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
        
		a = Integer.parseInt(new StringBuilder().append(a).reverse().toString());
		b = Integer.parseInt(new StringBuilder().append(b).reverse().toString());
		
		System.out.print(a > b ? a : b);
	}
}

package ch01.Beakjoon;

import java.util.Scanner;
//주사위 세 개
class Beakjoon2480 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		int a=in.nextInt();
		int b=in.nextInt();
		int c=in.nextInt();
		
	// 모든 변수가 다른 경우
	if (a != b && b != c && a != c) {
		int max;
		if (a > b) {	// 만약 a > b 라면
			if (c > a)	// c > a > b 라면
				max = c;
			else	// a > (b, c)
				max = a;
		}	
		else {	// a > (b, c)
			if (c > b)	// c > b > a 라면
				max = c;
			else	// b > (a, c)
				max = b;
		}
		System.out.println(max * 100);
	}
	else {	// 적어도 한 쌍 이상의 서로 같은 변수가 존재할 경우
		if (a == b && a == c) {	// 적어도 한 쌍 이상의 서로 같은 변수가 존재할 경우
			System.out.println(10000 + a * 1000);
		}
		else {
			if(a == b || a == c) {	// a가 b혹은 c랑만 같은 경우
				System.out.println(1000 + a * 100);
			}
			else {	// b가 c랑 같은 경우
				System.out.println(1000 + b * 100);
			}
		}
	}
}
}

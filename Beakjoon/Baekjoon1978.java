package ch01.Beakjoon;

import java.util.Scanner;
//소수 찾기
public class Baekjoon1978 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			// 소수인경우 true, 아닌경우 false   
			boolean isPrime = true;
			int num = in.nextInt();
			
			if(num == 1)	// 1 인경우 다음 반복문으로
				continue;
			for(int j = 2; j <= Math.sqrt(num); j++) {
				if(num % j == 0) {
					isPrime = false;	// 소수가 아니므로 false 로 바꿔줌
					break;
				}
			}
			if(isPrime)	// 소수인경우 count 값 1 증가
				count++;
		}
		System.out.println(count);
	} 
}

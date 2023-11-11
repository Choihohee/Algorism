package ch01.Beakjoon;

import java.util.Scanner;
//알람 시계
public class Beakjoon2884 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int H=sc.nextInt();	//시간
		int M=sc.nextInt();	//분
		sc.close();
		
		if(M < 45) {
			H--;		// 시(hour) 1 감소
			M= 60 - (45 - M); 	// 분(min) 감소
			if(H < 0) {
				H = 23;
			}
			System.out.println(H + " " + M);
		}
		else {
			M-=45;
			System.out.println(H + " " + M);
		}
	}
}

package ch01.Beakjoon;

import java.util.Scanner;
//그룹 단어 체커
public class Beakjoon1316 {
	static Scanner in = new Scanner(System.in);
 
	public static boolean check() {
		boolean[] check = new boolean[26];
		int prev = 0;
		String str = in.next();
		
		for(int i = 0; i < str.length(); i++) {
			int now = str.charAt(i);	// i 번째 문자 저장 (현재 문자)
			
			if (prev != now) {	// 앞선 문자와 i 번째 문자가 같지 않다면?
				if ( check[now - 'a'] == false ) {	// 해당 문자가 처음 나오는 경우 (false 인 경우)
					check[now - 'a'] = true;	
					prev = now;	// 다음 턴을 위해 바꿔줌
				}
				else {	// 해당 문자가 이미 나온 적이 있는 경우 (그룹단어가 아니게 됨) 
					return false;	
				}
			}
		}    
		return true;
	}
	public static void main(String[] args) {
		int count = 0;
		int n = in.nextInt();
		
		for (int i = 0; i < n; i++) {
			if (check() == true)
				count++;
		}
		System.out.println(count);
	}
}

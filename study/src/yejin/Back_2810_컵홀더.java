package yejin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_2810_컵홀더 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//값 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//자리 수
		int N = Integer.parseInt(br.readLine());
		//사람 값
		String str = br.readLine();
		int nocup = 0;
		
		for(int i=0; i<N; i++) {
			switch(str.charAt(i)) {
			case 'S':
				break;
			case 'L':
				//L이 나올 경우 다음도 L이므로 패스
				i++;
				//컵을 놓을 수 없는 사람 증가
				nocup++;
				break;
			}
		}
		//커플석이 없을 경우
		if(nocup==0) N--;
		
		//커플석이 있을 경우 총 컵 놓을 수 있는 사람 수 - 컵을 놓을 수 없는 사람
		System.out.println(N+1-nocup);
		
	}
}

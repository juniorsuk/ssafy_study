package back_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_13300_방배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//값 입력 받기
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int room = 0; //방 수 넣을 변수
		int[][] arr = new int[2][7]; //여자,남자 행으로 구분, 열로 학년구분
		
		//학생들 입력받기
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
		}
		
		//2차원배열 순회하며 K로 나누어떨어지면 room에 몫을 더하고 아니면 몫+1을 더한다.
		for (int r = 0; r < 2; r++) {
			for (int c = 1; c <= 6; c++) {
				if (arr[r][c] % K == 0) {
					room += arr[r][c] / K;
					continue;
				}
				room += (arr[r][c] / K) + 1;
			}
		}
		
		//출력
		System.out.println(room);
		

	}
}

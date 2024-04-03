package back_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_14891_톱니바퀴 {
	// 바퀴 클래스
	static class Gear {
		int left; // 왼쪽 포인터
		int right; // 오른쪽 포인터

		char[] info = new char[8]; // N S 정보 담을 배열

		Gear() {
		}
	}

	static Gear[] gears = new Gear[4]; // 바퀴 4개 담을 것

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 톱니바퀴 값 입력받기
		for (int i = 0; i < 4; i++) {
			gears[i] = new Gear();
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				gears[i].info[j] = str.charAt(j);
			}
			// 포인터 초기화
			gears[i].right = 2;
			gears[i].left = 6;
		}

		int turnCnt = Integer.parseInt(br.readLine());
		for (int t = 0; t < turnCnt; t++) {
			st = new StringTokenizer(br.readLine());
			int turnGear = Integer.parseInt(st.nextToken()) - 1; // -1 해주기. 1부터 시작하는데 나는 0부터 시작!
			int turnDirection = Integer.parseInt(st.nextToken());
			turnMove(turnGear, turnDirection); // 회전 시켜준다
		}

		// 회전 다하면 더해준다
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			int idx = (gears[i].left + 2) % 8;
			if (gears[i].info[idx] == '1') {
				sum += 1 << i; // 비트연산
			}
		}
		System.out.println(sum);

	}

	public static void turnMove(int turnGear, int turnDirection) {

		int leftGear = turnGear - 1; //왼쪽으로 이동하며 회전할 바퀴 찾기
		int rightGear = turnGear + 1; //오른쪽으로 이동하며 회전할 바퀴 찾기
		int currD = turnDirection;

		// 회전 방향 저장할 배열
		int[] turnD = new int[4];
		turnD[turnGear] = turnDirection;
		
		//왼쪽으로 계속 이동
		//언제 stop?
		//1. 인덱스 벗어나는 순간
		//2. 회전이 멈춘 순간
		while (leftGear >= 0) {
			int l = gears[leftGear + 1].left;
			int r = gears[leftGear].right;
			if (gears[leftGear + 1].info[l] == gears[leftGear].info[r])
				break;
			currD *= -1;
			turnD[leftGear--] = currD;
		}
		
		currD = turnDirection; //오른쪽 가기 전 방향 재할당
		//오른쪽으로 계속 이동
		//위와 동일한 로직
		while (rightGear < 4) {
			int l = gears[rightGear].left;
			int r = gears[rightGear - 1].right;
			if (gears[rightGear - 1].info[r] == gears[rightGear].info[l])
				break;
			currD *= -1;
			turnD[rightGear++] = currD;
		}

		// 회전 해야하는 친구들 회전한다.
		for (int i = 0; i < 4; i++) {
			if (turnD[i] == 0)
				continue;
			turn(i, turnD[i]);
		}

	}

	public static void turn(int turnGear, int direction) {
		if (direction == 1) {
			// 시계방향 회전
			gears[turnGear].right--;
			gears[turnGear].left--;
			if (gears[turnGear].right == -1) gears[turnGear].right = 7;
			if (gears[turnGear].left == -1) gears[turnGear].left = 7;
		} else {
			// 반시계방향 회전
			gears[turnGear].right++;
			gears[turnGear].left++;
			if (gears[turnGear].right == 8) gears[turnGear].right = 0;
			if (gears[turnGear].left == 8) gears[turnGear].left = 0;
		}
	}
}

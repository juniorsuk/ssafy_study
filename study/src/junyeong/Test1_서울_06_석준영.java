import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1_서울_06_석준영 {
	// 가로로 연속 4개인지 확인하는 함수
	static boolean rowchk(int[][] b) {
		for (int i = 0; i<6; i++) {
			// out of index 방지
			for (int j = 0; j<4; j++) {
				// 해당 돌이 빨간색일 때
				if (b[i][j] == 1) {
					// 연속으로 3개 더 빨간색이면 true
					if (b[i][j+1] == 1 && b[i][j+2] == 1 && b[i][j+3] == 1) return true;
				}
			}
		}
		// 조건 만족하지 않으면 false return
		return false;
	}
	
	// 세로로 연속 4개인지 확인하는 함수
	static boolean colchk(int[][] b) {
		// out of index 방지
		for (int i = 0; i<3; i++) {
			for (int j = 0; j<7; j++) {
				if (b[i][j] == 1) {
					// 연속으로 3개 더 빨간색이면 true
					if (b[i+1][j] == 1 && b[i+2][j] == 1 && b[i+3][j] == 1) return true;
				}
			}
		}
		return false;
	}
	
	// 우상향으로 연속 4개인지 확인하는 함수
	static boolean rupchk(int[][] b) {
		// out of index 방지
		for (int i = 0; i<3; i++) {
			// out of index 방지
			for (int j = 0; j<4; j++) {
				if (b[i][j] == 1) {
					// 연속으로 3개 더 빨간색이면 true
					if (b[i+1][j+1] == 1 && b[i+2][j+2] == 1 && b[i+3][j+3] == 1) return true;
				}
			}
		}
		return false;
	}
	
	// 우하향으로 연속 4개인지 확인하는 함수
	static boolean rdnchk(int[][] b) {
		// out of index 방지
		for (int i = 3; i<6; i++) {
			// out of index 방지
			for (int j = 0; j<4; j++) {
				if (b[i][j] == 1) {
					if (b[i-1][j+1] == 1 && b[i-2][j+2] == 1 && b[i-3][j+3] == 1) return true;
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 정답 작성용 StringBuilder 생성
		StringBuilder sb = new StringBuilder();
		// test case 갯수 저장용 변수 tc
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t<=tc; t++) {
			// 정답 출력 포맷 형성
			sb.append("#").append(t).append(" ");
			// 게임 판 2차원 배열로 선언
			int[][] brd = new int[6][7];
			// 게임 현재 게임 판의 형태 입력 
			for (int i = 0; i<6; i++) {
				// 한 줄 입력을 String 배열로 변환
				String[] row = br.readLine().split(" "); 
				// 맨 밑의 row가 0이 되도록 입력
				for (int j = 0; j<7; j++) brd[5-i][j] = Integer.parseInt(row[j]);
			}
			// 정답 할당용 변수 생성 (디폴트값 -1)
			int ans = -1;			
			// 열마다 빨간돌을 하나씩 넣는 상황 가정
			for (int col = 0; col<7; col++) {
				// 임시 게임 판 생성 및 복제
				int[][] ibrd = new int[6][7];
				for (int i = 0; i<6; i++) {
					for (int j = 0; j<7; j++) ibrd[i][j] = brd[i][j];
				}
				for (int i = 0; i<6; i++) {
					// 돌을 떨어뜨릴 수 있는 곳을 찾아 떨어뜨리기
					if (ibrd[i][col] == 0) {
						ibrd[i][col] = 1;
						// 4칸 연속 만족하는지 확인 후 만족하면 ans에 열 대입
						if (rowchk(ibrd)) ans = Math.max(ans, col);
						if (colchk(ibrd)) ans = Math.max(ans, col);
						if (rupchk(ibrd)) ans = Math.max(ans, col);
						if (rdnchk(ibrd)) ans = Math.max(ans, col);
						// 해당 열 탐색 종료
						break;
					}
				}
			}
			// 정답 출력 업데이트
			sb.append(ans).append("\n");
		}
		// 정답 출력
		System.out.println(sb);
	}
}

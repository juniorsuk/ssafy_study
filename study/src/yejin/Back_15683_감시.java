package back_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back_15683_감시 {
	static List<int[]>[] location;
	static List<int[]>[] direction;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M, min;

	// 5번 cctv부터 돌면서 최소값을 찾아서 색칠하고 넘어가려했는데
	// 최소값이 동일할때는 판별이 어려움. 재귀로 완탐 필요..
	// 푼 방법
	// 1. location 리스트에 각각 cctv의 좌표값을 넣는다.
	// 2. 5번 cctv는 전부 칠해놓고 시작한다.
	// 3. 4번 cctv부터 각각을 돌며 가능한 탐색 케이스를 완전탐색한다.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;

		map = new int[N][M]; // 원본배열
		location = new ArrayList[6]; // 1~5번 cctv 위치 담을 배열
		direction = new ArrayList[6]; // 가능한 탐색 케이스를 담을 배열

		for (int i = 0; i <= 5; i++) {
			location[i] = new ArrayList<>();
			direction[i] = new ArrayList<>();
		}

		// 입력값 받기
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				int num = Integer.parseInt(st.nextToken());
				map[r][c] = num;
				if (num == 0 || num == 6)
					continue;
				int[] arr = { r, c }; 
				location[num].add(arr); //cctv 좌표값 넣어주기
			}
		}

		// direction 배열 채우기
		initD();

		// 5번 cctv 칠하기
		coloring5();

		// 4번 cctv부터 판단
		find(4, location[4].size() - 1); 
			
		System.out.println(min);
	}


	public static void initD() {
		// 1번 cctv 가능한 경우 4가지 상/하/좌/우 0 1 2 3
		// 2번 cctv 가능한 경우 2가지 상하/좌우 01 23
		// 3번 cctv 가능한 경우 4가지 상우/우하/하좌/좌상 03 31 12 02
		// 4번 cctv 가능한 경우 4가지 상좌우/하좌우/우상하/좌상하 023 123 301 201
		
		// 배열에 담기는 숫자는 델타배열의 인덱스를 의미
		
		direction[1].add(new int[] { 0 }); //1번 cctv의 첫번째 방법. 상 탐색
		direction[1].add(new int[] { 1 });
		direction[1].add(new int[] { 2 });
		direction[1].add(new int[] { 3 });

		direction[2].add(new int[] { 0, 1 }); //2번 cctv의 첫번째 방법. 상하 탐색
		direction[2].add(new int[] { 2, 3 }); 

		direction[3].add(new int[] { 0, 3 }); //3번 cctv의 첫번째 방법. 상우 탐색
		direction[3].add(new int[] { 3, 1 });
		direction[3].add(new int[] { 1, 2 });
		direction[3].add(new int[] { 0, 2 });

		direction[4].add(new int[] { 0, 2, 3 }); //4번 cctv의 첫번째 방법. 상좌우 탐색
		direction[4].add(new int[] { 1, 2, 3 });
		direction[4].add(new int[] { 3, 0, 1 });
		direction[4].add(new int[] { 2, 0, 1 });
	}

	public static void coloring5() {
		for (int j = 0; j < location[5].size(); j++) {
			// cctv위치 가져오기
			int r = location[5].get(j)[0];
			int c = location[5].get(j)[1];

			for (int d = 0; d < 4; d++) {
				// 상하좌우 탐색
				int nr = r + dr[d];
				int nc = c + dc[d];
				while (nr >= 0 && nc >= 0 && nr < N && nc < M) {
					if (map[nr][nc] == 6)
						break; // 그 방향 그만가
					if (map[nr][nc] == 0) {
						map[nr][nc] = -1;
					}
					nr += dr[d];
					nc += dc[d];
				}
			}
		}
	}

	public static void find(int cctv, int j) {

		// 기저조건1
		if (cctv == 0) {
			// cctv 전부 돌았다
			
			// 계산
			min = Math.min(min, calculation());
			return;
		}

		// 기저조건2
		if (j == -1) {
			// CCTV없는 경우
			// 다음으로 넘어가기
			find(cctv - 1, location[cctv - 1].size() - 1);
			return;
		}
		
		// cctv 위치 가져오기
		int r = location[cctv].get(j)[0];
		int c = location[cctv].get(j)[1];


		for (int i = 0; i < 4; i++) {
			if (cctv == 2 && i >= 2)
				break;
			
			//칠하기
			coloring(cctv, r, c, i, 10*cctv+j); //10*cctv+j = 지금 시점에 칠한걸 알아볼 수 있을만한 숫자
			find(cctv, j - 1);
			//원복하기
			recoloring(cctv, r, c, i, 10*cctv+j);
		}
	}
	
	
	public static int calculation() {
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	
	/*
	 * coloring(), recoloring()
	 * cctv = 현재 cctv번호
	 * r, c = 현재 cctv의 좌표
	 * i = 현재 cctv에서 탐색할 방법 번호
	 * find = 지금 시점을 구분할 수 있는 번호. 0인 곳에 넣을 것이고, 원복하기 위해서 사용.
	 * 
	 * */
	public static void coloring(int cctv, int r, int c, int i, int find) {
		for (int d : direction[cctv].get(i)) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			while (nr >= 0 && nc >= 0 && nr < N && nc < M) {
				if (map[nr][nc] == 6)
					break; // 그 방향 그만가
				if (map[nr][nc] == 0) {
					map[nr][nc] = find;
				}
				nr += dr[d];
				nc += dc[d];
			}
		}
	}

	public static void recoloring(int cctv, int r, int c, int i, int find) {
		for (int d : direction[cctv].get(i)) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			while (nr >= 0 && nc >= 0 && nr < N && nc < M) {
				if (map[nr][nc] == 6) break; // 그 방향 그만가
				if (map[nr][nc] == find) {
					map[nr][nc] = 0; //원복
				}
				nr += dr[d];
				nc += dc[d];
			}
		}

	}

}

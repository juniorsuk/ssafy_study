package back_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_16724_피리부는사나이2 {
	static int N, M, bool ;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 }; // 상 하 좌 우 0 1 2 3
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int safeZone;

	public static void main(String[] args) throws IOException {
		// 전체를 순회하면서 카운팅을 한다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		safeZone = 0;
		bool = 0;
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				char word = str.charAt(c);
				switch (word) {
				case 'U': { // 상
					map[r][c] = 0;
					break;
				}
				case 'D': { // 하
					map[r][c] = 1;
					break;
				}
				case 'L': { // 좌
					map[r][c] = 2;
					break;
				}
				case 'R': { // 우
					map[r][c] = 3;
					break;
				}
				}
			}
		}
		// 입력받기 완료 --------------
		
		visited = new boolean[N][M];
		find();
		System.out.println(safeZone);

	}

	public static void find() {
		int check = 0;
		int[][] checked2 = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				check++;
				if(bool==N*M) return;
				
//				boolean[][] checked = new boolean[N][M]; --> 시간초과 문제.....ㅋ ㅋ ㅋ 원인...
				if (visited[r][c]) continue;
				int cr = r;// current r
				int cc = c;
				visited[r][c] = true; bool++;
//				checked[r][c] = true;
				checked2[r][c] = check;
				while (true) {
					int d = map[cr][cc];
					int nr = cr + dr[d];
					int nc = cc + dc[d];
					
					if (checked2[nr][nc]==check) {
//						System.out.println("dd");
						// 이번 턴에서 처음 돌았던 곳을 다시 갔다 //거기가 safeZone
						safeZone++;
						break;
					}
					if (visited[nr][nc]) break;
					
//					checked[nr][nc] = true; //방문 처리
					checked2[nr][nc] = check;
					visited[nr][nc] = true;
					// 아니면 갱신해주고 다음 탐방 시작
					cr = nr;
					cc = nc;
					
//					for(int rrr=0; rrr<N; rrr++) {
//						System.out.println(Arrays.toString(checked2[rrr]));
//					}
				}

			}
		}

		// 다 돌았음
	}

}

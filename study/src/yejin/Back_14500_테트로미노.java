package back_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_14500_테트로미노 {
	// 좌 하 우 탐색 --> 상도 해야함. 안하면 
	/*
	 * 000   (0,0)에서 시작할 때 다음 케이스를 고려하지 못한다.
	 * 0
	 * */
	
	// 완전 탐색
	// DFS로 사용

	static int max, N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		max = 0;

		// 입력
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		
		
		int[][] dr2 = {{0,0,0,-1},{0,1,2,1},{0,1,2,1},{0,0,0,1}};
		int[][] dc2 = {{0,1,2,1},{0,0,0,1},{0,0,0,-1},{0,1,2,1}};
		
		// DFS + ㅗ ㅏ ㅓ ㅜ
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				visited[r][c] = true;
				DFS(r, c, 1, map[r][c]); // r, c, d
				out : for(int i=0; i<4; i++) {
					int sum = 0;
					for(int d=0; d<4; d++) {
						int nr = r + dr2[i][d];
						int nc = c + dc2[i][d];
						if(nr<0||nc<0||nr>=N||nc>=M) continue out; //그 케이스 불가능
						sum += map[nr][nc];
					}
					max = Math.max(max, sum);
				}
				visited[r][c] = false;
			}
		}
		System.out.println(max);
	}

	public static void DFS(int r, int c, int d, int sum) {
		if (d == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]) {
				visited[nr][nc] = true; // 이동
				DFS(nr, nc, d + 1, sum + map[nr][nc]);
				visited[nr][nc] = false; // 원복
			}
		}

	}

}

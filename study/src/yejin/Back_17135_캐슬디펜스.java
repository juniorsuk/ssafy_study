package back_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_17135_캐슬디펜스 {

	static class sol {
		int r, c, d;

		public sol(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "sol [r=" + r + ", c=" + c + ", d=" + d + "]";
		}

		public sol(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}

	}

	static int[][] castle;
	static int N, M, D, max, enemy;
	static int[] soldier;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 행의 수
		M = Integer.parseInt(st.nextToken()); // 열의 수
		D = Integer.parseInt(st.nextToken()); // 공격 거리 제한

		soldier = new int[3];
		max = 0;
		enemy = 0;
		castle = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				castle[r][c] = Integer.parseInt(st.nextToken());
				if (castle[r][c] == 1)
					enemy++;
			}
		}
		attack(0, 0);
		System.out.println(max);
	}

	static int[] dr = { 0, -1, 0 }; // 좌 상 우 //왼쪽부터 택해야 함
	static int[] dc = { -1, 0, 1 };

	static void attack(int idx, int num) {
		if (enemy == max)
			return; // 잔가지
		if (num >= 3) {
			calcul();
			return;
		}

		for (int i = idx; i < M - 2 + num; i++) {
			soldier[num] = i;
			attack(i + 1, num + 1);
			soldier[num] = 0;
		}

	}

	static void calcul() {
		int[][] visited = new int[N][M]; // 방문한 시점 조사
		int success = 0;
		for (int r = N - 1; r >= 0; r--) {
			// 한칸씩 올라가며 게임을 진행한다
			s: for (int i = 0; i < 3; i++) {
				int curr = soldier[i];
				// soldier은 인덱스가 작은 순서대로 나오게 되어있음
				Queue<sol> que = new LinkedList<>();
				que.add(new sol(r + 1, curr, 0));
				while (!que.isEmpty()) {
					sol cur = que.poll();
					for (int d = 0; d < 3; d++) {
						int nr = cur.r + dr[d];
						int nc = cur.c + dc[d];
						if (nr >= 0 && nc >= 0 && nr < N && nc < M && cur.d+1 <= D) {
							if (castle[nr][nc] == 1) {
								if (visited[nr][nc] == 0) {
									// 공격하지 않았던 적
									if (nr == r + 1)
										continue; // 이건 나와 같은줄.. 친구들
									success++;
									visited[nr][nc] = r + 1;
									continue s; // 다음 병사

								} else if (visited[nr][nc] == r + 1) {
									// 같은 시점에 공격한 적이면 탐색을 끝내야 함
									continue s; // 다음 병사
								}
								// 다른 시점에 공격한 적
								// 사실은 1이 아닌거임!
								// 그냥 진행
							}
							que.add(new sol(nr, nc, cur.d + 1));
						}
					}
				}
			}
		}
		// 게임이 끝나면 max값 갱신
		max = Math.max(max, success);
	}

}

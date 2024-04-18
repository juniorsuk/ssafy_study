package back_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_16236_아기상어 {
	// 가장 가까이 있는 물고기 구해야하므로 BFS
	// 기본적으로는 상 좌 우 하 탐색 (위가 젤 먼저, 그다음 왼 오른쪽 아래 순으로 먹어야 함) --> 의미 없음
	// 		같은 시점에 다음 단계로 (BFS가 d가 2 이상 탐색할 경우, 가능한 모든 경우를 리스트에 넣고, r과 c값을 비교해서 더 작은 것으로 하는게 필요!!!!)
	// 먹을 수 있는 상어 발견하면 거기서 다시. 발견 못하면 종료
	// 먹은 물고기는 0으로 변환

	static class Shark {
		int r;
		int c;
		int d;
		int eat;
		int size = 2;

		public Shark(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

		public Shark(int r, int c, int d, int eat, int size) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.eat = eat;
			this.size = size;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", d=" + d + ", eat=" + eat + ", size=" + size + "]";
		}

	}

	static int[][] fish;
	static int N, time;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };
	static Shark start;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		time = 0;
		fish = new int[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				fish[r][c] = Integer.parseInt(st.nextToken());
				if (fish[r][c] == 9) { // baby shark 뚜루둡뚜루
					start = new Shark(r, c, 0);
					fish[r][c] = 0;
				}
			}
		}

		eat();

		System.out.println(time);
	}

	public static void eat() {
		Shark shark = start;
		Shark lastS = shark;
		while (shark != null) {
			lastS = shark;
			shark = BFS(shark);
		}
		time = lastS.d;

	}

	public static Shark BFS(Shark shark) {

		Queue<Shark> que = new ArrayDeque<>();
		boolean flag = false;
		List<Shark> list = new ArrayList<>();
		int queoffer = 1; //큐에 들어가는 초기 개수
		que.offer(shark);
		boolean[][] visited = new boolean[N][N];
		visited[shark.r][shark.c] = true;
		
		while (!que.isEmpty()) {
			int currQueoffer = 0; //현재 큐에 들어가는 개수 카운트
			for (int i = 0; i < queoffer; i++) { //한 사이클동안 큐에 들어간 것만큼 돌기 (동일 시점에 먹을 수 있는 물고기들 파악 위해서)
				Shark curr = que.poll();
				int r = curr.r;
				int c = curr.c;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
						if (visited[nr][nc])
							continue; // 이미 왔던 곳이면 패스
						visited[nr][nc] = true;
						if (fish[nr][nc] == 0 || fish[nr][nc] == curr.size) {
							// 비어있다 or 안먹는데 지나간다
							que.offer(new Shark(nr, nc, curr.d + 1, curr.eat, curr.size));
							currQueoffer++;
						} else if (fish[nr][nc] < curr.size) {
							// 먹는다
							int size = curr.size == curr.eat + 1 ? curr.size + 1 : curr.size;
							int eat = size == curr.size + 1 ? 0 : curr.eat + 1;
							Shark newS = new Shark(nr, nc, curr.d + 1, eat, size);
							list.add(newS);
							flag = true;

						}

					}
				}
			}
			if (flag) {
				Shark returnS = list.get(0);
				for (Shark s : list) {
					if (s.r < returnS.r) {
						returnS = s;
					}else if(s.r == returnS.r && s.c < returnS.c) {
						returnS = s;
					}
				}
				fish[returnS.r][returnS.c] = 0; // 여기서 먹기 !!!!!
				return returnS;
			}
			queoffer = currQueoffer;
		}

		return null;
	}

}

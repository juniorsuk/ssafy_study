import java.io.*;
import java.util.*;

public class 응애상어 {
	public static int ans;
	public static int n;
	public static int size;
	public static int eat;
	public static int[] ini;
	public static int[][] sea;
	public static boolean[][] visited;
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {-1, 0, 1, 0};
	
	static class Comp1 implements Comparator<int[]>{
		@Override
		public int compare(int[] a, int[] b) {
			if (a[1]<b[1]) {
				return -1;
			}
			else return 1;
		}
	}
	
	static class Comp2 implements Comparator<int[]>{
		@Override
		public int compare(int[] a, int[] b) {
			if (a[0]<b[0]) {
				return -1;
			}
			else return 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ans = 0;
		size = 2;
		eat = 0;
		sea = new int[n][n];
		visited = new boolean[n][n];
		ini = new int[3];
		for (int i = 0; i<n; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 0; j<n; j++) {
				sea[i][j] = Integer.parseInt(row[j]);
				if (sea[i][j] == 9) {
					ini[0] = j;
					ini[1] = i;
					ini[2] = 0;
					sea[i][j] = 0;
				}
			}
		}
		Queue<int[]> q = new ArrayDeque<>();
		ArrayList<int[]> eats = new ArrayList<>();
		q.offer(ini);
		while (true) {
			int nowd = 0;
			int chk = Integer.MAX_VALUE;
			while (!q.isEmpty()) {
				int[] now = q.poll();
				visited[now[1]][now[0]] = true;
//				System.out.println(now[0]+" "+now[1]+" "+now[2]+" "+ans+" "+size+" "+eat);
				for (int i = 0; i<4; i++) {
					int ax = now[0] + dx[i];
					int ay = now[1] + dy[i];
					if (chk >= now[2] && 0<=ax && ax<n && 0<=ay && ay<n && !visited[ay][ax]) {
						if (sea[ay][ax] < size && sea[ay][ax] > 0) {
							int[] e = {ax, ay};
							visited[ay][ax] = true;
							eats.add(e);
							nowd = now[2]+1;
							chk = now[2];
						}
						else if (sea[ay][ax] == size || sea[ay][ax] == 0) {
							int[] next = {ax, ay, now[2]+1};
							visited[ay][ax] = true;
							q.offer(next);
						}
						else visited[ay][ax] = true;
					}
				}
			}
			if (!eats.isEmpty()) {
//				for (int i = 0; i<eats.size(); i++) {					
//					System.out.print(Arrays.toString(eats.get(i))+" "+nowd);
//				}
//				System.out.println();
				eats.sort(new Comp2());
				eats.sort(new Comp1());
//				for (int i = 0; i<eats.size(); i++) {					
//					System.out.print(Arrays.toString(eats.get(i))+" "+nowd);
//				}
//				System.out.println();
				int x = eats.get(0)[0];
				int y = eats.get(0)[1];
				eat++;
				sea[y][x] = 0;
				ans += nowd;
				if (eat == size) {
					eat = 0;
					size++;
				}
				q = new ArrayDeque<int[]>();
				eats = new ArrayList<>();
				int[] next = {x, y, 0};
				q.offer(next);
				visited = new boolean[n][n];
				chk = Integer.MAX_VALUE;
				continue;
			}
			else break;
		}
//		System.out.println(Arrays.deepToString(sea));
		System.out.println(ans);
	}
}

package solving;

import java.util.*;
import java.io.*;

public class N16234_n {
	public static int n;
	public static int l;
	public static int r;
	public static int[][] popu;
	public static boolean[][] visited;
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static Queue<int[]> q;
	public static boolean chk;
	
	public static void bfs() {
		LinkedList<int[]> uni = new LinkedList<>();
		int psum = 0;
		int con = 0;
		while (!q.isEmpty()) {		
			int[] now = q.poll();
			if (visited[now[1]][now[0]]) continue;
			uni.add(now);
			psum += popu[now[1]][now[0]];
			con++;
			visited[now[1]][now[0]] = true;
			for (int i = 0; i<4; i++) {
				int ax = now[0] + dx[0];
				int ay = now[1] + dy[0];
				if (0<=ax && ax<n && 0<=ay && ay<n && !visited[ay][ax]) {
					if (Math.abs(popu[now[1]][now[0]]-popu[ay][ax])>=l && Math.abs(popu[now[1]][now[0]]-popu[ay][ax])<=r) {
						chk = true;
						int[] next = {ax, ay};
						q.offer(next);
					}
				}
			}
		}
		if (con > 0) {			
			int p = psum/con;
			for (int i = 0; i<uni.size(); i++) {
				popu[uni.get(i)[1]][uni.get(i)[0]] = p;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nlr = br.readLine().split(" ");
		n = Integer.parseInt(nlr[0]);
		l = Integer.parseInt(nlr[1]);
		r = Integer.parseInt(nlr[2]);
		popu = new int[n][n];
		for (int i = 0; i<n; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 0; j<n; j++) popu[i][j] = Integer.parseInt(row[j]);
		}
		int ans = 0;
		q = new ArrayDeque<>();
		while (true) {
			visited = new boolean[n][n];
			chk = false;
			for (int i = 0; i<n; i++) {
				for (int j = 0; j<n; j++) {
					if (!visited[i][j]) {
						int[] ini = {j, i};
						q.offer(ini);
						bfs();
					}
				}
			}
			if (chk) {
				ans++;
			}
			else break;
		}
		System.out.println(ans);
	}
}

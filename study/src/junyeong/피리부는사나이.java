package solving;

import java.util.*;
import java.io.*;

public class 피부사 {
	public static int[][] brd;
	public static int[][] visited;
//	public static int[][] safe;
	public static int n;
	public static int m;
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static void dfs (int x, int y) {
		visited[y][x] = 1;
//		safe[y][x] = 1;
//		System.out.println(brd[y][x]);
		int ax = x + dx[brd[y][x]];
		int ay = y + dy[brd[y][x]];
		if ((visited[ay][ax] & 1) == 0) dfs(ax, ay);
//		System.out.println((brd[y][x]+2)%4 + "ss");
		for (int i = 0; i<4; i++) {			
			int bx = x + dx[i];
			int by = y + dy[i];
			if (0<=bx && bx<m && 0<=by && by<n && brd[by][bx] == (i+2)%4 && (visited[by][bx] & 1) == 0) dfs(bx, by);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		brd = new int[n][m];
		visited = new int[n][m];
//		safe = new int[n][m];
		for (int i = 0; i<n; i++) {
			String row = br.readLine();
			for (int j = 0; j<m; j++) {
				switch (row.charAt(j)) {
				case 'U': brd[i][j] = 3;
				break;
				case 'D': brd[i][j] = 1;
				break;
				case 'L': brd[i][j] = 2;
				break;
				default : brd[i][j] = 0;
				break;
				}
			}
		}
//		System.out.println(Arrays.deepToString(brd));
		int ans = 0;
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				if ((visited[i][j] & 1) == 0) {
					ans++;
					dfs(j, i);
//					visited = new int[n][m];
				}
			}
		}
		System.out.println(ans);
	}
}

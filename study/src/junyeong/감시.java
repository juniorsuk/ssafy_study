import java.io.*;
import java.util.*;

public class Main {
	public static int ans;
	public static int n;
	public static int m;
	public static int c;
	public static int[][] room;
	public static ArrayList<int[]> cc;
	
	public static int count() {
		int ret = 0;
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				if (room[i][j] == 0) ret++;
			}
		}
		return ret;
	}
	
	public static void up(int x, int y, int val) {
		while (y>=0 && room[y][x] != 100) room[y--][x] += val;
	}
	public static void down(int x, int y, int val) {
		while (y<n && room[y][x] != 100) room[y++][x] += val;
	}
	public static void left(int x, int y, int val) {
		while (x>=0 && room[y][x] != 100) room[y][x--] += val;
	}
	public static void right(int x, int y, int val) {
		while (x<m && room[y][x] != 100) room[y][x++] += val;
	}
	
	public static void combi(int now) {
		if (now == c) {
			ans = Math.min(ans, count());
			return;
		}
		int[] nowcc = cc.get(now);
		int nx = nowcc[0];
		int ny = nowcc[1];
		if (nowcc[2] == 1) {
			up(nx, ny, 1);
			combi(now+1);
			up(nx, ny, -1);
			
			down(nx, ny, 1);
			combi(now+1);
			down(nx, ny, -1);
			
			left(nx, ny, 1);
			combi(now+1);
			left(nx, ny, -1);
			
			right(nx, ny, 1);
			combi(now+1);
			right(nx, ny, -1);
		}
		if (nowcc[2] == 2) {
			up(nx, ny, 1);
			down(nx, ny, 1);
			combi(now+1);
			up(nx, ny, -1);
			down(nx, ny, -1);
			
			left(nx, ny, 1);
			right(nx, ny, 1);
			combi(now+1);
			left(nx, ny, -1);
			right(nx, ny, -1);
		}
		if (nowcc[2] == 3) {
			up(nx, ny, 1);
			right(nx, ny, 1);
			combi(now+1);
			up(nx, ny, -1);
			right(nx, ny, -1);
			
			right(nx, ny, 1);
			down(nx, ny, 1);
			combi(now+1);
			right(nx, ny, -1);
			down(nx, ny, -1);
			
			left(nx, ny, 1);
			down(nx, ny, 1);
			combi(now+1);
			left(nx, ny, -1);
			down(nx, ny, -1);
			
			up(nx, ny, 1);
			left(nx, ny, 1);
			combi(now+1);
			up(nx, ny, -1);
			left(nx, ny, -1);
		}
		if (nowcc[2] == 4) {
			up(nx, ny, 1);
			right(nx, ny, 1);
			left(nx, ny, 1);
			combi(now+1);
			up(nx, ny, -1);
			right(nx, ny, -1);
			left(nx, ny, -1);
			
			up(nx, ny, 1);
			right(nx, ny, 1);
			down(nx, ny, 1);
			combi(now+1);
			up(nx, ny, -1);
			right(nx, ny, -1);
			down(nx, ny, -1);
			
			left(nx, ny, 1);
			right(nx, ny, 1);
			down(nx, ny, 1);
			combi(now+1);
			left(nx, ny, -1);
			right(nx, ny, -1);
			down(nx, ny, -1);
			
			left(nx, ny, 1);
			up(nx, ny, 1);
			down(nx, ny, 1);
			combi(now+1);
			left(nx, ny, -1);
			up(nx, ny, -1);
			down(nx, ny, -1);
		}
		if (nowcc[2] == 5) {
			up(nx, ny, 1);
			left(nx, ny, 1);
			right(nx, ny, 1);
			down(nx, ny, 1);
			combi(now+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		ans = Integer.MAX_VALUE;
		cc = new ArrayList<>();
		room = new int[n][m];
		c = 0;
		for (int i = 0; i<n; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 0; j<m; j++) {
				if (row[j].equals("6")) room[i][j] = 100;
				else if (row[j].equals("0")) continue;
				else {
					int[] tv = {j, i, Integer.parseInt(row[j])};
					room[i][j] = tv[2];
					cc.add(tv);
					c++;
				}
			}
		}
		combi(0);
		System.out.println(ans);
	}
}

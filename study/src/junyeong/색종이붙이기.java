import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 색종이붙이기 {
	public static int[][] paper;
	public static int ans;
	public static int[] color_paper = {0, 5, 5, 5, 5, 5};
	
	public static int cp(int x, int y) {
		int ret = 0;
		ii : for (int i = 1; i<=5; i++) {
			for (int j = 0; j<i; j++) {
				for (int k = 0; k<i; k++) {
					if (y+j>=10 || x+k>=10 ||(paper[y+j][x+k] & 1<<0) == 0) break ii;
				}
			}
			ret++;
		}
		return ret;
	}
	
	public static void cover(int x, int y, int n) {
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++) paper[y+i][x+j] = 0;
		}
	}
	
	public static void uncover(int x, int y, int n) {
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++) paper[y+i][x+j] |= 1<<0;
		}
	}
	
	public static void dfs(int x, int y, int now) {
		int max = cp(x, y);
		if (y == 9 && x>9) {
			ans = Math.min(ans, now);
			return;
		}
		if (x > 9) {
			dfs(0, y+1, now);
			return;
		}
		if ((paper[y][x] & 1<<0)>0) {
			for (int i = max; i>0; i--) {
				if (color_paper[i] > 0) {
					cover(x, y, i);
					color_paper[i]--;
					if (ans > now+1) dfs(x+1, y, now+1);
					uncover(x, y, i);
					color_paper[i]++;
				}
			}
		}
		else dfs(x+1, y, now);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		paper = new int[10][10];
		for (int i = 0; i<10; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 0; j<10; j++) {
				if(row[j].equals("1")) paper[i][j] |= 1<<0;
			}
		}
		ans = Integer.MAX_VALUE;
		dfs(0, 0, 0);
		if (ans > 25) ans = -1;
		System.out.println(ans);
	}
}

/*
1 1 1 1 1 1 1 0 0 0
1 1 1 1 1 1 1 0 0 0
1 1 1 1 1 1 1 0 0 0
1 1 1 1 1 1 1 0 0 0
1 1 1 1 1 1 1 0 0 0
1 1 1 1 1 0 0 0 0 0
1 1 1 1 1 0 0 0 0 0
1 1 1 1 1 0 0 0 0 0
1 1 1 1 1 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0

정답 5
*/

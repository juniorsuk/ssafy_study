import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	static int oppo(int i) {
		if (i == 0) return 5;
		else if (i == 1) return 3;
		else if (i == 2) return 4;
		else if (i == 3) return 1;
		else if (i == 4) return 2;
		else return 0;
	}
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] sums = new int[6];
		String[] downs = new String[6];
		String[] ups = new String[6];
		String[] fdice = br.readLine().split(" ");
		for (int i = 0; i<6; i++) {
			downs[i] = fdice[i];
			for (int j = 0; j<6; j++) {
				if (fdice[j] == downs[i]) ups[i] = fdice[oppo(j)];
			}
		}
		for (int i = 0; i<6; i++) {
			int imax = 0;
			for (int j = 1; j<7; j++) {
				if (j==Integer.parseInt(downs[i])||j==Integer.parseInt(ups[i])) continue;
				imax = Math.max(imax, j);
			}
			sums[i] += imax;
		}
		for (int t = 1; t<n; t++) {
			String[] dice = br.readLine().split(" ");
			for (int i = 0; i<6; i++) downs[i] = ups[i];
			for (int i = 0; i<6; i++) {
				for (int j = 0; j<6; j++) {
					if (dice[j].equals(downs[i])) ups[i] = dice[oppo(j)];
				}
			}
			for (int i = 0; i<6; i++) {
				int imax = 0;
				for (int j = 1; j<7; j++) {
					if (j==Integer.parseInt(downs[i])||j==Integer.parseInt(ups[i])) continue;
					imax = Math.max(imax, j);
				}
				sums[i] += imax;
			}
		}
		int maxsum = 0;
		for (int i : sums) maxsum = Math.max(maxsum, i);
		System.out.println(maxsum);
	}
}

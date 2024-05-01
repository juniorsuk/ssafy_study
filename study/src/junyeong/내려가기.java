import java.io.*;
import java.util.*;

public class N2096 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] ip = new int[n][3];
		int[][] xdp = new int[n][3];
		int[][] ndp = new int[n][3];
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<3; j++) ip[i][j] = sc.nextInt();
		}
		xdp[0] = ip[0];
		ndp[0] = ip[0];
		for (int i = 1; i<n; i++) {
			xdp[i][0] = Math.max(xdp[i-1][0], xdp[i-1][1]) + ip[i][0];
			xdp[i][1] = Math.max(Math.max(xdp[i-1][0], xdp[i-1][1]), xdp[i-1][2]) + ip[i][1];
			xdp[i][2] = Math.max(xdp[i-1][1], xdp[i-1][2]) + ip[i][2];
		}
		for (int i = 1; i<n; i++) {
			ndp[i][0] = Math.min(ndp[i-1][0], ndp[i-1][1]) + ip[i][0];
			ndp[i][1] = Math.min(Math.min(ndp[i-1][0], ndp[i-1][1]), ndp[i-1][2]) + ip[i][1];
			ndp[i][2] = Math.min(ndp[i-1][1], ndp[i-1][2]) + ip[i][2];
		}
		System.out.println(Math.max(Math.max(xdp[n-1][0], xdp[n-1][1]), xdp[n-1][2]) + " " + Math.min(Math.min(ndp[n-1][0], ndp[n-1][1]), ndp[n-1][2]));
	}
}

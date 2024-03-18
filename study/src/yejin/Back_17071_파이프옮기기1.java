package back_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_17071_파이프옮기기1 {
	static int N, cnt;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		cnt = 0;
		arr = new int[N][N];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
	
		find(1,0,1);
		System.out.println(cnt);
		
	}
	
	static int[] dr = {-1,0};
	static int[] dc = {0,-1};
	
	
	public static void find(int idx, int r, int c){
		if(r>=N||c>=N||arr[r][c]==1) {
			return;
		}
		if(r==N-1&&c==N-1) {
			if(idx==2) {
				//대각선으로 온 경우 //이거 안넣어서 틀렸음 
				for(int i=0; i<2; i++) {
					//주변 탐색 상, 좌 탐색
					int nr = r+dr[i];
					int nc = c+dc[i];
					if(nr<N&&nc<N) {
						if(arr[nr][nc]==1) return;
					}
				}
			}
			cnt++;
			return;
		}
		if(idx==1) {
			//가로로 온 경우
//			if(c+1<N&&arr[r][c+1]!=1) {
				find(1,r,c+1); //가로로 간다
//			}
//			if(r+1<N&&c+1<N)
			find(2,r+1,c+1); //대각선으로 간다
		}
		if(idx==2) {
			//대각선으로 온 경우
			for(int i=0; i<2; i++) {
				//주변 탐색 상, 좌 탐색
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr<N&&nc<N) {
					if(arr[nr][nc]==1) return;
				}
			}
			find(1,r,c+1); //가로로 간다
			find(2,r+1,c+1); //대각선으로 간다
			find(3,r+1,c); //아래로 간다
		}
		if(idx==3) {
			//아래로 온 경우
			find(2,r+1,c+1); //대각선으로 간다
			find(3,r+1,c); //아래로 간다
		}
	}
	
}

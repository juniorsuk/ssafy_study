package back_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_12100_2048 {
		static int[][] arr;
		static int N, num, max;
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if(arr[r][c]!=0) num++;
			}
		}
		max = 0;
		play(0,0,num,arr);
		System.out.println(max);
		
	}
	
	/*
	 * dir = 방향
	 * idx = 몇 번 이동했는지
	 * num = 현재 남은 숫자 블록 수
	 * playarr = 지금 진행중인 게임판
	 * 
	 * */
	
	public static void play(int dir, int idx, int num, int[][] playarr) {
		if(idx>5) { //기저조건1 //5번일때 까지는 수행해야 함!! 이동을 해야하니까
			//계산
			calculation(playarr);
			return;
		}
		if(num==1) { //기저조건2
			//계산
			calculation(playarr);
			return;
		}
		
		int[][] newarr = new int[N][N];
		Queue<Integer>[] quearr = new ArrayDeque[N];
		for(int i=0; i<N; i++) {
			quearr[i] = new ArrayDeque<>();
		}
		int curnum = 0; //지금 남은 블록 수 cnt
		
		if(dir==1){
			//up
			for(int c=0; c<N; c++) {
				for(int r=0; r<N; r++) {
					if(playarr[r][c]!=0)quearr[c].offer(playarr[r][c]);
				}
			}
			
			for(int c=0; c<N; c++) {
				for(int r=0; !quearr[c].isEmpty();) {
					int tmp = quearr[c].poll();
					newarr[r++][c] = tmp;
					curnum ++;
					if(!quearr[c].isEmpty()&&tmp==quearr[c].peek())newarr[r-1][c]+=quearr[c].poll();
				}
			}
			
		}else if(dir==2) {
			//down
			for(int c=0; c<N; c++) {
				for(int r=N-1; r>=0; r--) {
					if(playarr[r][c]!=0)quearr[c].offer(playarr[r][c]);
				}
			}
			
			for(int c=0; c<N; c++) {
				for(int r=N-1; !quearr[c].isEmpty();) {
					int tmp = quearr[c].poll();
					newarr[r--][c] = tmp;
					curnum ++;
					if(!quearr[c].isEmpty()&&tmp==quearr[c].peek())newarr[r+1][c]+=quearr[c].poll();
				}
			}
		}else if(dir==3) {
			//left
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(playarr[r][c]!=0)quearr[r].offer(playarr[r][c]);
				}
			}
			
			for(int r=0; r<N; r++) {
				for(int c=0; !quearr[r].isEmpty();) {
					int tmp = quearr[r].poll();
					newarr[r][c++] = tmp;
					curnum ++;
					if(!quearr[r].isEmpty()&&tmp==quearr[r].peek())newarr[r][c-1]+=quearr[r].poll();
				}
			}
		}else if(dir==4){
			//right
			for(int r=0; r<N; r++) {
				for(int c=N-1; c>=0; c--) {
					if(playarr[r][c]!=0)quearr[r].offer(playarr[r][c]);
				}
			}
			
			for(int r=0; r<N; r++) {
				for(int c=N-1; !quearr[r].isEmpty();) {
					int tmp = quearr[r].poll();
					newarr[r][c--] = tmp;
					curnum ++;
					if(!quearr[r].isEmpty()&&tmp==quearr[r].peek())newarr[r][c+1]+=quearr[r].poll();
				}
			}
		}else {
			//맨처음 0일 때
			newarr = playarr;
		}
		
		play(1, idx+1, curnum, newarr);
		play(2, idx+1, curnum, newarr);
		play(3, idx+1, curnum, newarr);
		play(4, idx+1, curnum, newarr);
		
	}

	private static void calculation(int[][] playarr) {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				max = Math.max(max, playarr[r][c]);
			}
		}
	}
	
}

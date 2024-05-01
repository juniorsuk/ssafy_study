package back_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_10775_공항 {
	static int[] dockingP;
	static int P, G, ans;
	
	/*
	 * dockingP[i] => i인덱스 이하에서 비행기가 도킹할 수 있는 곳의 인덱스를 의미한다. 
	 * 초기에는 자기 자신을 가리키고 있음.
	 * ->	find 함수로 들어갔을 때, 자기 자신을 가리키고있지 않으면 
	 * 		자기 자신을 가리키고있는 인덱스의 값까지 탐방 한다. 리턴하며 지나온 인덱스의 값들을 갱신해줌. (Path Compression)
	 * 		만일, 자기 자신을 가리키고있는 것이 없으면 -1을 리턴하게 됨. -> 도킹할 수 없게되는 순간.
	 * 
	 * -> 도킹했다면 도킹한 곳의 배열값이 가리키는 인덱스를 -1 해줌.
	 * 
	 * 
	 * -> 반복
	 * */ 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		dockingP = new int[G];
		
		for(int g=0; g<G; g++) {
			dockingP[g] = g;
		}
		
		for(int p=0; p<P; p++) {
			//비행기가 순서대로 도착한다. cur=현재의 gi
			int cur = Integer.parseInt(br.readLine())-1; //인덱스에 맞게 하기 위해서 -1
			cur = find(cur);
			if(cur==-1) break;
			ans++;
			dockingP[cur]--;
		}
		
		System.out.println(ans);
	}
	
	public static int find(int cur) {
		if(cur==-1) return -1;
		if(dockingP[cur]==cur) {
			return cur;
		}else {
			return dockingP[cur]=find(dockingP[cur]);
		}
	}

}

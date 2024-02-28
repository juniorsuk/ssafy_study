package junghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] girls = new int[7]; // 여자 방 배열
		int[] boys = new int[7]; // 남자 방 배열
		int students = Integer.parseInt(st.nextToken()); // 총 학생 수
		int max = Integer.parseInt(st.nextToken()); // 방 최대 인원
		int gender; 
		int grade; 
		int rooms = 0; // 총 필요한 방의 수
		
		for(int i = 0; i < students; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken()); // 성별
			grade = Integer.parseInt(st.nextToken()); // 학년
			
			if(gender == 0) { // 성별에 따라 해당 성별의 배열 +1
				girls[grade]++;
			} else {
				boys[grade]++;
			}
		}

		for(int i = 1; i <=6; i++) { // 방 배열 돌면서 최대 수용인원 넘으면 +1
			if(girls[i] != 0) rooms += ((girls[i]-1) / max)+1;  // 인원제한 6명일 경우 1~6명이 방 하나인데
			if(boys[i] != 0) rooms += ((boys[i]-1) / max)+1; // 5/6과 6/6의 몫이 다른것을 감안하여 1씩 줄여 계산
		}
		
		System.out.println(rooms);
	}
}
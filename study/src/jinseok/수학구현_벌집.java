package jinseok;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 수학구현_벌집 {

	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());

		int hive = 1;
		int i = 1;
		int way = 1;
		
		while(N > hive) {
			
			hive += (6*i);
			
			i++;
			
			way++;
			
		}
		
		bw.write(String.valueOf(way));
		
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
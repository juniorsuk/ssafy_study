import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		br.close();
		
		int[] ball = new int[n];
		
		ball[0] = 1;
		
		int now = 0;
		
		for (int i = 0; i >= 0; i++) {
			if (ball[now]==m) {
				String o = ""+i; 
				bw.write(o); 
				bw.flush(); 
				bw.close(); 
				break;
			}
			else {
				if (ball[now]%2 == 0) now += l;
				else now -= l;
			}
			if (now >= n) now -= n;
			else if (now < 0) now += n;
			ball[now]++;
		}
	}
}

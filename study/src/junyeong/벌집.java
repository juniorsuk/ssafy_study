import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int n = Integer.parseInt(s);
		int h = 1;
		int pass = 1;
		while (true) {
			if (n <= h) break;
			else {
				h += 6*pass;
				pass++;
			}
		}
		String o = ""+pass; 
		bw.write(o); 
		bw.flush(); 
		bw.close();
	}
}

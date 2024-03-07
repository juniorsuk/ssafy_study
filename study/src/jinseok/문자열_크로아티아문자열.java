package jinseok;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 문자열_크로아티아문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		String word = reader.readLine();
		int count = 0;
		int index = 0;

		while (index < word.length()) {

			char ch = word.charAt(index);

			if (ch == 'c' && index + 1 < word.length()) {

				char nextChar = word.charAt(index + 1);

				if (nextChar == '=' || nextChar == '-') {
					index += 2;
					count++;
					continue;
				}

			} else if (ch == 'd' && index + 1 < word.length()) {

				char nextChar = word.charAt(index + 1);

				if (nextChar == 'z' && index + 2 < word.length() && word.charAt(index + 2) == '=') {

					index += 3;

					count++;

					continue;

				} else if (nextChar == '-') {

					index += 2;

					count++;

					continue;

				}

			} else if ((ch == 'l' || ch == 'n') && index + 1 < word.length()) {

				char nextChar = word.charAt(index + 1);

				if ((ch == 'l' && nextChar == 'j') || (ch == 'n' && nextChar == 'j')) {

					index += 2;

					count++;

					continue;

				}

			} else if ((ch == 's' || ch == 'z') && index + 1 < word.length() && word.charAt(index + 1) == '=') {

				index += 2;

				count++;

				continue;

			}

			index++;
			count++;
		}

		writer.write(Integer.toString(count));

		writer.flush();
		writer.close();
		reader.close();
	}
}

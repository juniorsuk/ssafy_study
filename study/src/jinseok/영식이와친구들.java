package jinseok;

import java.util.Scanner;

public class 영식이와친구들 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();

		int[] arr = new int[N];

		arr[0] = 1;

		boolean mCheck = maxCheck(arr, M);
		
		int index = 0;
		int result = 0;
		
		while (mCheck) {
			
			if(arr[index] % 2 != 0) {
				index += L;
				
				if(index >= N) {
					index -= N;
				}
				
				arr[index]++;
			} else {
				index -= L;
				
				if(index < 0) {
					index += N;
				}
				
				arr[index]++;
			}
			
			result++;
			
			mCheck = maxCheck(arr, M);
		}

		System.out.println(result);
		sc.close();
	}

	public static boolean maxCheck(int[] arr, int M) {

		boolean result = true;

		for (int i = 0; i < arr.length; i++) {
			
			if(arr[i] == M) {
				return false;
			}
			
		}

		return result;
	}

}
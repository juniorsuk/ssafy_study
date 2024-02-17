import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        int max = -1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<N; k++) {
                    if(i != j && j != k && k != i) {
                        int sum = arr[i] + arr[j] + arr[k];
                        if(sum> max && sum <= M) max = sum;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
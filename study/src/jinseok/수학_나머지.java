package jinseok;

import java.util.Scanner;

public class 수학_나머지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] A = new int[42];
        
        for (int i = 0; i < 10; i++) {
            int num = sc.nextInt();
            int r = num % 42;
            A[r] = 1;
        }
        
        int count = 0;
        
        for (int a : A) {
            if (a == 1) {
                count++;
            }
        }
        
        System.out.println(count);
        
        sc.close();
    }
}
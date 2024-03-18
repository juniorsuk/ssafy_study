import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int c = scanner.nextInt();
        int n = scanner.nextInt();
        
        int[] cpu = new int[c + 1];
        cpu[1] = 1;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            queue.add(new int[]{a, b});
        }
        
        while (!queue.isEmpty()) {
            int chk = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pair = queue.poll();
                if (cpu[pair[0]] == 1 || cpu[pair[1]] == 1) {
                    cpu[pair[0]] = 1;
                    cpu[pair[1]] = 1;
                    chk++;
                } else {
                    queue.add(pair);
                }
            }
            if (chk == 0) {
                break;
            }
        }
        
        int count = 0;
        for (int i = 2; i <= c; i++) { // 1번 컴퓨터는 제외하고 계산
            if (cpu[i] == 1) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}

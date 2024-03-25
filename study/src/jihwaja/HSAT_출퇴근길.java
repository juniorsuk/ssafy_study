import java.io.*;
import java.util.*;


public class HSAT_출퇴근길 {

    static int N; // 정점의 갯수
    static int M; // 간선의 갯수

    static ArrayList<Integer>[] graph1; // 정순
    static ArrayList<Integer>[] graph2; // 정순

    static boolean[] visited1; // 정순 S출발
    static boolean[] visited2; // 정순 T출발

    static boolean[] visitedR1; // 역순 S출발
    static boolean[] visitedR2; // 역순 T출발

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph1 = new ArrayList[N+1];
        graph2 = new ArrayList[N+1];

        visited1 = new boolean[N+1];
        visited2 = new boolean[N+1];
        visitedR1 = new boolean[N+1];
        visitedR2 = new boolean[N+1];

        for(int i=0; i<N+1; i++) {
            graph1[i] = new ArrayList<>();
            graph2[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {

            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph1[A].add(B); // 정순 graph
            graph2[B].add(A); // 역순 graph
        }

        st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        iterative_BFS(S, T);
        iterative_BFS2(S, T);
        iterative_BFS_R1(S, T);
        iterative_BFS_R2(S, T);

        int cnt = 0;

        for(int i=0; i<N+1; i++) {
            if(visited1[i] == true && visited2[i] == true && visitedR1[i] == true && visitedR2[i] == true && i != S && i != T) {
                cnt += 1;
            }

        }

        System.out.println(cnt);


    }

    public static void iterative_BFS(int start, int end) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited1[start] = true;
        visited1[end] = true;

        while(!q.isEmpty()) {

            int v = q.poll();

            for(int w : graph1[v]) {

                if(visited1[w] == false) {
                    q.add(w);
                    visited1[w] = true;
                }
            }
        }
    }

    public static void iterative_BFS2(int start, int end) {

        Queue<Integer> q = new LinkedList<>();
        q.add(end);
        visited2[end] = true;
        visited2[start] = true;

        while(!q.isEmpty()) {

            int v = q.poll();

            for(int w : graph1[v]) {

                if(visited2[w] == false) {
                    q.add(w);
                    visited2[w] = true;
                }
            }
        }
    }

    public static void iterative_BFS_R1(int start, int end) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visitedR1[start] = true;
//        visitedR1[end] = true;

        while(!q.isEmpty()) {

            int v = q.poll();

            for(int w : graph2[v]) {

                if(visitedR1[w] == false) {
                    q.add(w);
                    visitedR1[w] = true;
                }
            }
        }
    }

    public static void iterative_BFS_R2(int start, int end) {

        Queue<Integer> q = new LinkedList<>();
        q.add(end);
        visitedR2[end] = true;
//        visitedR2[start] = true;

        while(!q.isEmpty()) {

            int v = q.poll();

            for(int w : graph2[v]) {

                if(visitedR2[w] == false) {
                    q.add(w);
                    visitedR2[w] = true;
                }
            }
        }
    }
}
import java.util.*;

public class BOJ_2606바이러스 {
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean[] virus = new boolean[num +1];
        LinkedList<Integer>[] adjList = new LinkedList[num +1]; //링크드 리스트
        int N = sc.nextInt();

        for(int i =0; i<=num ;i++)
            adjList[i] = new LinkedList<Integer>(); //객체 생성

        cnt= 0;

        for(int  i = 0; i< N; i++ ){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjList[v1].add(v2);
            adjList[v2].add(v1);
            }
        bfs_list(1,adjList,virus); //bfs 돌려보장


        System.out.println(cnt);
    }

    public static void bfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited ){
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[v] = true; //왔던 곳 체크!
        queue.add(v);

        while (!queue.isEmpty()){ //안에 하여튼 뭐가 있다는 거야~
            v = queue.poll(); //하여튼 맨 마지막거 꺼내겠다는거야
            Iterator<Integer> iter = adjList[v].listIterator(); //반복자 ( 밥먹자(X) )  리스트 순회객체
            while(iter.hasNext()){ //가지고 있어? 그럼 드가자!
                int w = iter.next();
                if(!visited[w]){ //방문 안했어?
                    visited[w] =true; //했따!
                    cnt++; //기념으로 cnt 한 번 찍자
                    queue.add(w); //이제 이동네 맛집 인거다!
                }
            }
        }
    }
}

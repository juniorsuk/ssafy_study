import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 지환이의경비원{ //경비원의 삶은 어떨까
    static int[] map;
    static int width,height,ShopNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        ShopNum = Integer.parseInt(br.readLine());

        map = new int[width*2 + height*2];

        for(int i =1 ; i<=ShopNum; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st1.nextToken());
            int distance = Integer.parseInt(st1.nextToken());
            mapping(direction,distance,i);
        }
        StringTokenizer st2 =new StringTokenizer(br.readLine());
        int hum_direction = Integer.parseInt(st2.nextToken());
        int hum_distance = Integer.parseInt(st2.nextToken());
        mapping(hum_direction,hum_distance,ShopNum+1);

        int i = 0;
        int humanidx =0;
        int sum = 0;
        while(map[i] != ShopNum+1 ) i++;//닝겐의 위치를 찾는다
        humanidx = i;

        for(int j = 1; j<=ShopNum ; j++){
            int idxshop = 0;
            int cnt =0;
            while(cnt !=1) {
                if(map[idxshop] == j){
                    cnt++;
                    int num;
                    if(idxshop < humanidx)
                        num = map.length - humanidx + idxshop  ;
                    else num = map.length - idxshop + humanidx  ;
                    sum +=Math.min(Math.abs(idxshop - humanidx) , num);
                }
                idxshop++;
            }
        }
        System.out.println(sum);
    }
    static void mapping(int direction, int distance, int i){
        switch (direction) { //북서남동 , 길이 순서는 서북동남
            case 1: map[height + distance] = i; break; //북
            case 3: map[height - distance] = i; break; //서
            case 2: map[(2*width + 2*height) - distance] = i; break; //남
            case 4: map[width + height + distance] = i; break; //동
        }
    }
}
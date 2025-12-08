import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class aoc2025day8 {


    static final int INF = Integer.MAX_VALUE / 2;
    static final int MOD = (int)(1e9+7);
    static int[][] dir = {{1, 0}, {0,1}, {0,-1}, {-1,0}, {-1,1}, {1,-1}, {1, 1}, {-1,-1}};
    //static int[][] dir = {{1, 0}, {0,1}, {0,-1}, {-1,0}};

    public static boolean valid(int x, int y, int n, int m) {
        return x>=0 && x<n && y>=0 && y<m;
    }

    static int[] par;
    static int[] size;
    public static int fpar(int x){
        if(par[x] == x)return x;
        return par[x] = fpar(par[x]);
    }

    public static int union(int x, int y){
        int fx = fpar(x);
        int fy = fpar(y);
        if(fx == fy)return 0;

        if(size[fx] < size[fy]){
            size[fx] += size[fy];
            par[fy] = fx;
        }
        else{
            size[fy] += size[fx];
            par[fx] = fy; 
        }
        return 1;
    }
    public static long dis(long x1, long y1, long z1, long x2, long y2, long z2){
        return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) + (z1-z2)*(z1-z2);
    }


    public static void main(String[] args) throws IOException {

        long ans = 1;
        long sum = 0;

        Scanner scan = new Scanner(new File("t2.txt"));

        List<long[]> list = new ArrayList<>();
        int ind = 0;
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] arr = line.split(",");
            list.add(new long[]{Long.valueOf(arr[0]), Long.valueOf(arr[1]), Long.valueOf(arr[2]), (long)ind++});

        }
        int n = list.size();
        par = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++)par[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            long[] a1 = list.get(x[0]);
            long[] a2 = list.get(x[1]);
            long d1 = dis(a1[0], a1[1], a1[2], a2[0], a2[1], a2[2]);

            long[] a3 = list.get(y[0]);
            long[] a4 = list.get(y[1]);
            long d2 = dis(a3[0], a3[1], a3[2], a4[0], a4[1], a4[2]);
            return Long.compare(d1, d2);
        });
        int comp = n;

        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                pq.offer(new int[]{i, j});
            }
        }

        while(comp != 1){
            long min = (long)1e18;
            int[] a = pq.poll();            
            //System.out.println(Arrays.toString(list.get(a[0]))+"   "+Arrays.toString(list.get(a[1])));
            comp -= union(a[0], a[1]);

            if(comp == 1){
                long[] a1 = list.get(a[0]);
                long[] a2 = list.get(a[1]);
                long d1 = dis(a1[0], a1[1], a1[2], a2[0], a2[1], a2[2]);
                System.out.println(a1[0] * a2[0]);
                break;
            }

        }


        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<n;i++){
            int p = fpar(i);
            m.put(p, m.getOrDefault(p, 0)+1);
        }
        List<Integer> l2 = new ArrayList<>();
        for(int key : m.keySet())
            l2.add(m.get(key));
        Collections.sort(l2);


        


    }


    public static void printMat(int[][] arr) {
        int n = arr.length, m = arr[0].length;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println("");
        }
    }
}
;
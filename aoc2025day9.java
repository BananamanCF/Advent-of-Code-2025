import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class aoc2025day9 {


    static final int INF = Integer.MAX_VALUE / 2;
    static final int MOD = (int)(1e9+7);
    static int[][] dir = {{1, 0}, {0,1}, {0,-1}, {-1,0}, {-1,1}, {1,-1}, {1, 1}, {-1,-1}};
    //static int[][] dir = {{1, 0}, {0,1}, {0,-1}, {-1,0}};

    public static boolean valid(int x, int y, int n, int m) {
        return x>=0 && x<n && y>=0 && y<m;
    }
    public static boolean inbet(long a, long b, long c){
        return b >= a && b <= c;
    }

    public static boolean isValid(long x, long y ,List<long[]> ver, List<long[]> hor){
        boolean l = false, r = false, u = false, d = false;
        for(long[] v : ver){

            if(v[2] <= x && inbet(v[0], y, v[1]))l = true;
            if(v[2] >= x && inbet(v[0], y, v[1]))r = true;
        }
        for(long[] h : hor){
            
            if(h[2] <= y && inbet(h[0], x, h[1]))u = true;
            if(h[2] >= y && inbet(h[0], x, h[1]))d = true;
        }

        return l && r && d && u;
    }
    public static boolean checkHor(long y1, long y2, long x, List<long[]> hor){
        if(y1 > y2){long t = y1;y1=y2;y2=t;}
        int cnt = 0;
        for(long[] h : hor){
            if(h[2] > y1 && h[2] < y2 && h[0]<x && x<h[1])cnt++;
        }
        return cnt==0;
    }
    public static boolean checkVer(long x1, long x2, long y, List<long[]> ver){
        if(x1 > x2){long t = x1;x1=x2;x2=t;}
        int cnt = 0;
        for(long[] v : ver){
            if(v[2] > x1 && v[2] < x2 && v[0]<y && y<v[1])cnt++;
        }
        return cnt==0;
    }


    public static void main(String[] args) throws IOException {

        long ans = 1;
        long sum = 0;

        Scanner scan = new Scanner(new File("t2.txt"));

        List<long[]> list = new ArrayList<>();
        while(scan.hasNextLine()){
            String[] line = scan.nextLine().split(",");
            list.add(new long[]{Long.valueOf(line[0]), Long.valueOf(line[1])});
        }
        int n = list.size();

        List<long[]> ver = new ArrayList<>();
        List<long[]> hor = new ArrayList<>();
        for(int i=0;i<n;i++){
            int i1 = i, i2 = i-1;
            if(i == 0){i1=0;i2=n-1;}

            long[] a = list.get(i1), b = list.get(i2);
            long[] t1 = new long[]{a[0], b[0]};Arrays.sort(t1);
            long[] t2 = new long[]{a[1], b[1]};Arrays.sort(t2);
            if(a[0] == b[0])ver.add(new long[]{t2[0], t2[1], a[0]});
            else hor.add(new long[]{t1[0], t1[1], a[1]});
        }

        //System.out.println(f2(2, 5, 7, 1, ver, hor, -1, -1));


        long max = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(i == j)continue;
                long[] a = list.get(i);
                long[] b = list.get(j);
                long ar = (Math.abs(a[0]-b[0])+1) * (Math.abs(b[1]-a[1])+1);


                boolean b1 = isValid(a[0], a[1], ver, hor) && isValid(a[0], b[1], ver, hor);
                boolean b2 = isValid(b[0], a[1], ver, hor) && isValid(b[0], b[1], ver, hor);
                boolean b3 = checkHor(a[1], b[1], a[0], hor) && checkHor(a[1], b[1], b[0], hor);
                boolean b4 = checkVer(a[0], b[0], a[1], ver) && checkVer(a[0], b[0], b[1], ver);
                if(b1 && b2 && b3 && b4){
                    //System.out.println(Arrays.toString(a)+" "+Arrays.toString(b)+"   "+ar);
                    max = Math.max(max, ar);
                }
            }
        }

        System.out.println(max);
        
        

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
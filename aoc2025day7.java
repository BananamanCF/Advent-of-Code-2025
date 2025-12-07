import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class aoc2025day7 {


    static final int INF = Integer.MAX_VALUE / 2;
    static final int MOD = (int)(1e9+7);
    static int[][] dir = {{1, 0}, {0,1}, {0,-1}, {-1,0}, {-1,1}, {1,-1}, {1, 1}, {-1,-1}};
    //static int[][] dir = {{1, 0}, {0,1}, {0,-1}, {-1,0}};

    public static boolean valid(int x, int y, int n, int m) {
        return x>=0 && x<n && y>=0 && y<m;
    }
    static long[][] dp;
    public static long f(int x, int y, List<char[]> list){

        if(x == list.size()-1)
            return 1;

        if(dp[x][y] != -1)
            return dp[x][y];

        long ans = 0;

        if(list.get(x+1)[y] == '^'){
            ans += f(x+1, y-1, list);
            ans += f(x+1, y+1, list);
        }
        else{
            ans += f(x+1, y, list);
        }
        return dp[x][y] = ans;
    }

    public static void main(String[] args) throws IOException {

        long ans = 0;
        long sum = 0;

        Scanner scan = new Scanner(new File("t2.txt"));

        List<char[]> list = new ArrayList<>();
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            list.add(line.toCharArray());        
        }
        int sx=0, sy=0;
        int n = list.size(), m = list.get(0).length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(list.get(i)[j] == 'S'){
                    sx = i;sy=j;break;
                }
            }
        }
        dp = new long[n][m];
        for(long[] a : dp)
            Arrays.fill(a, -1);

        boolean[][] vis = new boolean[n][m];
        vis[sx][sy] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy, 0});


        System.out.println(f(sx, sy, list));


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

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class aoc2025day11 {


    static final int INF = Integer.MAX_VALUE / 2;
    static final int MOD = (int)(1e9+7);
    static int[][] dir = {{1, 0}, {0,1}, {0,-1}, {-1,0}, {-1,1}, {1,-1}, {1, 1}, {-1,-1}};
    //static int[][] dir = {{1, 0}, {0,1}, {0,-1}, {-1,0}};

    public static boolean valid(int x, int y, int n, int m) {
        return x>=0 && x<n && y>=0 && y<m;
    }

    public static char[][] rot(char[][] a){
        int n = a.length;
        char[][] res = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - i - 1] = a[i][j];
            }
        }
        return res;
    }

    public static boolean canPlace(char[][] board, int i, int j, char[][] t){
        int n = board.length, m = board[0].length;
        for(int x=0;x<3;x++)
            for(int y=0;y<3;y++)
                if(board[i+x][j+y] != '.' && t[x][y] != '.')
                    return false;
        return true;
    }

    public static void main(String[] args) throws IOException {

        long ans = 0;
        long sum = 0;

        Scanner scan = new Scanner(new File("t2.txt"));
        char[][][] arr = new char[6][3][3];
        for(int i=0;i<6;i++){
            scan.nextLine();
            String l1 = scan.nextLine(), l2 = scan.nextLine(), l3 = scan.nextLine();
            arr[i][0] = l1.toCharArray();
            arr[i][1] = l2.toCharArray();
            arr[i][2] = l3.toCharArray();
            scan.nextLine();
        }
        int iii=0;

        while(scan.hasNextLine()){

            String[] s1 = scan.nextLine().split(" ");
            String[] b = s1[0].split("x");b[1] = b[1].substring(0, b[1].length()-1);
            int width = Integer.valueOf(b[0]), height = Integer.valueOf(b[1]);
            int[] nums = new int[6];
            for(int i=1;i<s1.length;i++){
                nums[i-1] = Integer.valueOf(s1[i]);
            }
            //System.out.println(Arrays.toString(nums)+" "+left+" "+right);
            char[][] board = new char[height][width];
            for(char[] bb : board)Arrays.fill(bb, '.');

            long t = nums[0] * 7 + nums[1] * 5 + nums[2] * 7 + nums[3] * 6 + nums[4] * 7 + nums[5]*7;
            if(t <= width*height)ans++;

        }
        //char[][] g = {{'P', 'P', 'P'}, {'P', '.', '.'}, {'P', 'P', 'P'}};


        System.out.println(ans);
    }


    public static void printMat(char[][] arr) {
        int n = arr.length, m = arr[0].length;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println("");
        }
        System.out.println();
    }
}
;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class aoc2025day2 {
    static FastIO scan;
    static FastOut out;

    static final int INF = Integer.MAX_VALUE / 2;
    static final int MOD = (int)(1e9+7);

    public static void main(String[] args) throws IOException {

        scan = new FastIO();
        out = new FastOut();

        Scanner scan = new Scanner(new File("t1.txt"));

        String line = "";
        while(scan.hasNextLine())
            line += scan.nextLine();

        long ans = 0;
        for(String s : line.split(",")){
            String[] s2 = s.split("-");
            long a = Long.valueOf(s2[0]);
            long b = Long.valueOf(s2[1]);
            //System.out.println(a+" "+b);
            for(long i=a;i<=b;i++){
                String num = i+"";
                boolean bb = false;
                for(int j=0;j<num.length();j++){
                    String cur = num.substring(0, j+1);
                    if(cur.length() == num.length())continue;

                    int t = num.length() / cur.length();

                    if(cur.repeat(t).equals(num)){
                        bb = true;
                        break;
                    }
                }
                if(bb)
                    ans += i;
            }
        }


        System.out.println(ans);


        out.close();
    }

    public static boolean valid(int x, int y, char[][] b) {
        return x>=0 && x<b.length && y>=0 && y<b[0].length && b[x][y] != '#';
    }

    public static void printMat(int[][] arr) {
        int n = arr.length, m = arr[0].length;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println("");
        }
    }

    static class FastIO{
        BufferedReader br;
        StringTokenizer st;
        public FastIO(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        public FastIO(String path) throws FileNotFoundException{
            br=new BufferedReader(new FileReader(path));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class FastOut {
        private final BufferedWriter bw;

        public void flush() throws IOException {
            bw.flush();
        }

        public FastOut() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
}

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class aoc2025day5 {
    static FastIO scan;
    static FastOut out;

    static final int INF = Integer.MAX_VALUE / 2;
    static final int MOD = (int)(1e9+7);
    static int[][] dir = {{1, 0}, {0,1}, {0,-1}, {-1,0}, {-1,1}, {1,-1}, {1, 1}, {-1,-1}};
    //static int[][] dir = {{1, 0}, {0,1}, {0,-1}, {-1,0}};

    public static boolean valid(int x, int y, int n, int m) {
        return x>=0 && x<n && y>=0 && y<m;
    }

    public static void main(String[] args) throws IOException {

        scan = new FastIO();
        out = new FastOut();
        long ans = 0;

        Scanner scan = new Scanner(new File("t2.txt"));

        List<long[]> list = new ArrayList<>();

        String line = scan.nextLine();

        while(!line.equals("")){
            String[] arr = line.split("-");
            list.add(new long[]{Long.valueOf(arr[0]), Long.valueOf(arr[1])});
            line = scan.nextLine();
        }

        Collections.sort(list, (x, y) -> {
            int c = Long.compare(x[0], y[0]);
            if(c == 0)
                return Long.compare(x[1], y[1]);
            return c;
        });

        
        long max = list.get(0)[0];
        int n = list.size();
        for(int i=0;i<n;i++){
            
            long[] l = list.get(i);

            ans += Math.max(0, l[1] - max + 1);
            if(i+1 < n){
                max = Math.max(max, list.get(i+1)[0]);
                max = Math.max(max, list.get(i)[1]+1);
            }
            System.out.println(max+" "+ans);
            
        }


        System.out.println(ans);


        out.close();
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

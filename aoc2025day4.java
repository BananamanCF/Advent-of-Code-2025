import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class dd {
    static FastIO scan;
    static FastOut out;

    static final int INF = Integer.MAX_VALUE / 2;
    static final int MOD = (int)(1e9+7);
    static int[][] dir = {{1, 0}, {0,1}, {0,-1}, {-1,0}, {-1,1}, {1,-1}, {1, 1}, {-1,-1}};

    public static boolean valid(int x, int y, int n, int m) {
        return x>=0 && x<n && y>=0 && y<m;
    }

    public static void main(String[] args) throws IOException {

        scan = new FastIO();
        out = new FastOut();

        Scanner scan = new Scanner(new File("t1.txt"));

        List<char[]> list = new ArrayList<>();
        int sx=0, sy=0;
        int ii=0;
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            list.add(line.toCharArray());
        }
        int n = list.size(), m = list.get(0).length;

        long ans = 0;
        for(int k=0;k<10000;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    int c = 0;
                    if(list.get(i)[j] != '@')continue;

                    for(int[] d : dir){
                        int nx = i+d[0];
                        int ny = j+d[1];
                        if(valid(nx, ny, n, m) && list.get(nx)[ny] == '@'){
                            c++;
                        }
                    }
                    if(c < 4){
                        list.get(i)[j] = '.';
                        ans++;
                    }
                }
            }
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

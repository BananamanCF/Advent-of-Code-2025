import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class aoc2025day6 {
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
        long sum = 0;

        Scanner scan = new Scanner(new File("t2.txt"));

        List<String> list = new ArrayList<>();
        int ind = 0;
        String ops = "";
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            if(line.contains("+")){
                ops = line;
                break;
            }
            list.add(line);
        }
        ind = 0;
        List<List<Long>> arr = new ArrayList<>();
        arr.add(new ArrayList<>());

        for(int col=list.get(0).length()-1;col>=0;col--){
            String num = "";
            int cnt = 0;
            for(int row=0;row<list.size();row++){
                char cur = list.get(row).charAt(col);
                if(cur != ' '){
                    num += cur;
                    cnt++;
                }
            }
            if(cnt == 0){
                arr.add(new ArrayList<>());
                ind++;
            }
            else{
                arr.get(ind).add(Long.valueOf(num));
            }
        }
        //System.out.println(arr);
        ind = 0;
        String[] opp = ops.trim().split("\\s+");
        for(int i=opp.length-1;i>=0;i--){
            long cur = arr.get(ind).get(0);

            for(int j=1;j<arr.get(ind).size();j++){
                if(opp[i].equals("+"))
                    cur += arr.get(ind).get(j);
                else
                    cur *= arr.get(ind).get(j);
            }
            //System.out.println(cur+"  "+Arrays.toString(opp));
            sum += cur;
            ind++;
        }
        

        System.out.println(sum);


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

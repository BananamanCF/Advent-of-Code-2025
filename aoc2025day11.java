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
    static class Node{
        String s = "";
        boolean b1 = false;
        boolean b2 = false;
        int num = 0;
    }
    static Map<String, Long> dp;
    public static long f(String node, Map<String, List<String>> g, boolean a, boolean b){
        if(node.equals("out")){
            return (a && b) ? 1 : 0;
        }
        String key = node+":"+a+":"+b;
        if(dp.containsKey(key))return dp.get(key);

        long ways = 0;
        for(String nei : g.get(node)){
            boolean newA = a || nei.equals("fft");
            boolean newB = b || nei.equals("dac");
            ways += f(nei, g, newA, newB);
        }
        dp.put(key, ways);
        return ways;
    }


    public static void main(String[] args) throws IOException {

        long ans = 0;
        long sum = 0;

        Scanner scan = new Scanner(new File("t2.txt"));

        Map<String, List<String>> graph = new HashMap<>();
        dp = new HashMap<>();
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] arr = line.split(" ");
            String src = arr[0].substring(0, arr[0].length()-1);
            if(!graph.containsKey(src))
                graph.put(src, new ArrayList<>());

            for(int i=1;i<arr.length;i++){
                graph.get(src).add(arr[i]);
                if(!graph.containsKey(arr[i]))graph.put(arr[i], new ArrayList<>());
            }
        }
        Queue<Node> q = new LinkedList<>();
        Node cur = new Node();
        cur.s = "svr";
        cur.b1 = false;
        cur.b2 = false;
        System.out.println(f("svr", graph, false, false));

        q.offer(cur);
        Map<String, Integer> map = new HashMap<>();

        // while(!q.isEmpty()){
        //     Node node = q.poll();
        //     String s = node.s;
        //     //System.out.println(s);
        //     boolean a = node.b1;
        //     boolean b = node.b2;

        //     if(node.s.equals("out")){
        //         //System.out.println(s+" "+a+" "+b);
        //         if(a && b)ans++;
        //         continue;
        //     }
        //     for(String nei : graph.get(s)){
        //         if(nei.equals("dac"))a = true;
        //         if(nei.equals("fft"))b = true;
        //         Node newN = new Node();
        //         newN.s = nei;
        //         newN.b1 = a;
        //         newN.b2 = b;
        //         newN.num++;
        //         String key = s +":"+a+":"+b+":"+newN.num;
        //         map.put(key, map.getOrDefault(key, 0)+1);
        //         if(map.get(key) < 20000){
        //             q.offer(newN);
        //         }
        //     }
        // }


        System.out.println(ans);
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
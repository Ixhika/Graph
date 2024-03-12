package Cycles;

import java.util.*;
public class Prims {
    ArrayList<int[]>[] graph;
    int n;

    Prims(int n){
        graph = new ArrayList[n];
        this.n = n;
    }

    public void addEdge(int src , int dest , int wt){
        if(graph[src] == null){
            graph[src] = new ArrayList<>();
        }

        if(graph[dest] == null){
            graph[dest] = new ArrayList<>();
        }

        graph[src].add(new int[]{wt , dest});
        graph[dest].add(new int[]{wt , src});
    }

    public int mst(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> (x[0] - y[0]));

        int sum = 0;
        boolean[] visited = new boolean[n];
        pq.offer(new int[]{0,0});

        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int wt = temp[0];
            int node = temp[1];
            
            if(visited[node]){
                continue;
            }
            visited[node] = true;
            sum += wt;

            for(int[] i: graph[node]){
                if(!visited[i[1]]){
                    pq.offer(i);
                }
            }
        }
        return sum;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Prims t = new Prims(n);
        while(m-- > 0){
            t.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        System.out.println(t.mst());
    }
}

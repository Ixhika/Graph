package Cycles;

import java.util.ArrayList;

public class DetecCycleInDirectedGraphDfs {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for(int i=0;i<V;i++){
            if(dfs(adj, visited, recStack, i)){
                return true;
            }
        }
        return false;
    }

    // Extra recursion stack because it is directed otherwise even if there is no cycle it will show yes
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj , boolean[] visited , boolean[] recStack , int curr){
        visited[curr]  = true;
        recStack[curr] = true;

        for(int i:adj.get(curr)){
            if(!visited[i]){
                if(dfs(adj,visited,recStack,i)){
                    return true;
                }
            }else if(recStack[i] == true){
                return true;
            }
        }
        recStack[curr] = false;
        return false;
    }
}

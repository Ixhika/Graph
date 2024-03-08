package Cycles;

import java.util.ArrayList;

public class DetectCycleInUndirectedGraphDFS {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i] && dfs(adj,visited,i,-1)){
                return true;
            }
        }
        return false;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> adj , boolean[] visited , int curr , int parent){
        visited[curr] = true;

        for(int i:adj.get(curr)){

            // to make sure that it does not go to infinte loop so we check once it is visited it does not go back if it is the parent of the next node
            if(i == parent){
                continue;
            }
            if(visited[i] == true){
                return true;
            }
            if(dfs(adj,visited,i,curr)){
                return true;
            }
        }
        return false;
    }
}

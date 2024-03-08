package Cycles;
/*Given an undirected graph with V vertices labelled from 0 to V-1 and E edges, check whether it contains any cycle or not. Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.

Example 1:

Input:  
V = 5, E = 5
adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} 
Output: 1
Explanation: 

1->2->3->4->1 is a cycle.
Example 2:

Input: 
V = 4, E = 2
adj = {{}, {2}, {1, 3}, {2}}
Output: 0
Explanation: 

No cycle in the graph */
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

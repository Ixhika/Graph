package Cycles;
/*Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.

Example 1:

Input:

Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 3, 2, 1, 0.
Example 2:

Input:

Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 5, 4, 2, 1, 3, 0. */

import java.util.*;

// Always in directed graph
public class TopologicalSortingDFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            visited[i] = false;
        }
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(adj,stack,visited,i);
            }
        }
        
       int[] res = new int[stack.size()];
        for(int i=0;i<V;i++){
            res[i] = stack.pop();
        }
        return res;

    }
    static void dfs(ArrayList<ArrayList<Integer>> adj , Stack<Integer> stack , boolean[] visited , int curr){
        visited[curr] = true;

        for(int i:adj.get(curr)){
            if(!visited[i]){
                dfs(adj,stack,visited,i);
            }
        }
        stack.push(curr);
    }
}

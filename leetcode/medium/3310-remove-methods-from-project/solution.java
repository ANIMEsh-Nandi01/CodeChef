import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // Step 1: Build the adjacency list for the directed graph
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : invocations) {
            graph[edge[0]].add(edge[1]);
        }
        
        // Step 2: Use DFS to mark all suspicious methods
        boolean[] isSuspicious = new boolean[n];
        dfs(k, graph, isSuspicious);
        
        // Step 3: Check if any healthy method invokes a suspicious method
        for (int[] edge : invocations) {
            int u = edge[0]; // caller
            int v = edge[1]; // callee
            
            // If caller is healthy but callee is suspicious, we can't remove anything
            if (!isSuspicious[u] && isSuspicious[v]) {
                return getAllMethods(n);
            }
        }
        
        // Step 4: If safe to remove, collect and return only healthy methods
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!isSuspicious[i]) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    // Helper function to perform Depth-First Search
    private void dfs(int node, List<Integer>[] graph, boolean[] isSuspicious) {
        isSuspicious[node] = true;
        for (int neighbor : graph[node]) {
            if (!isSuspicious[neighbor]) {
                dfs(neighbor, graph, isSuspicious);
            }
        }
    }
    
    // Helper function to return all methods when removal is impossible
    private List<Integer> getAllMethods(int n) {
        List<Integer> allMethods = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            allMethods.add(i);
        }
        return allMethods;
    }
}
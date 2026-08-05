# Remove Methods From Project

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are maintaining a project that has `n` methods numbered from `0` to `n - 1`.

You are given two integers `n` and `k`, and a 2D integer array `invocations`, where `invocations[i] = [ai, bi]` indicates that method `ai` invokes method `bi`.

There is a known bug in method `k`. Method `k`, along with any method invoked by it, either  **directly**  or  **indirectly**, are considered  **suspicious**  and we aim to remove them.

A group of methods can only be removed if no method  **outside**  the group invokes any methods  **within**  it.

Return an array containing all the remaining methods after removing all the  **suspicious**  methods. You may return the answer in  *any order*. If it is not possible to remove  **all**  the suspicious methods,  **none**  should be removed.

 

 **Example 1:** 

 **Input:**  n = 4, k = 1, invocations = [[1,2],[0,1],[3,2]]

 **Output:**  [0,1,2,3]

 **Explanation:** 

Method 2 and method 1 are suspicious, but they are directly invoked by methods 3 and 0, which are not suspicious. We return all elements without removing anything.

 **Example 2:** 

 **Input:**  n = 5, k = 0, invocations = [[1,2],[0,2],[0,1],[3,4]]

 **Output:**  [3,4]

 **Explanation:** 

Methods 0, 1, and 2 are suspicious and they are not directly invoked by any other method. We can remove them.

 **Example 3:** 

 **Input:**  n = 3, k = 2, invocations = [[1,2],[0,1],[2,0]]

 **Output:**  []

 **Explanation:** 

All methods are suspicious. We can remove them.

 

 **Constraints:** 

- 1 <= n <= 105
- 0 <= k <= n - 1
- 0 <= invocations.length <= 2 * 105
- invocations[i] == [ai, bi]
- 0 <= ai, bi <= n - 1
- ai != bi
- invocations[i] != invocations[j]

## Solution

**Language:** Java  
**Runtime:** 56 ms (beats 89.42%)  
**Memory:** 296.2 MB (beats 10.58%)  
**Submitted:** 2026-08-05T17:43:21.174Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/remove-methods-from-project/)
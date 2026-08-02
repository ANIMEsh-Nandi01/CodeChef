# Stone Game

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Alice and Bob play a game with piles of stones. There are an  **even**  number of piles arranged in a row, and each pile has a  **positive**  integer number of stones `piles[i]`.

The objective of the game is to end with the most stones. The  **total**  number of stones across all the piles is  **odd**, so there are no ties.

Alice and Bob take turns, with  **Alice starting first**. Each turn, a player takes the entire pile of stones either from the  **beginning**  or from the  **end**  of the row. This continues until there are no more piles left, at which point the person with the  **most stones wins**.

Assuming Alice and Bob play optimally, return `true` *if Alice wins the game, or* `false` *if Bob wins*.

 

 **Example 1:** 

```
Input: piles = [5,3,4,5]
Output: true
Explanation: 
Alice starts first, and can only take the first 5 or the last 5.
Say she takes the first 5, so that the row becomes [3, 4, 5].
If Bob takes 3, then the board is [4, 5], and Alice takes 5 to win with 10 points.
If Bob takes the last 5, then the board is [3, 4], and Alice takes 4 to win with 9 points.
This demonstrated that taking the first 5 was a winning move for Alice, so we return true.

```

 **Example 2:** 

```
Input: piles = [3,7,2,3]
Output: true

```

 

 **Constraints:** 

- 2 <= piles.length <= 500
- piles.length is even.
- 1 <= piles[i] <= 500
- sum(piles[i]) is odd.

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 23.31%)  
**Memory:** 42.5 MB (beats 99.60%)  
**Submitted:** 2026-08-02T04:58:37.114Z  

```java
class Solution { // Define the class Solution
    public boolean stoneGame(int[] piles) { // Function taking the array of pile values and returning whether Alice wins
        int n = piles.length; // Store the total number of stone piles in variable 'n'
        
        int[] dp = new int[n]; // Create a 1D DP array to track maximum relative scores for sub-ranges
        
        for (int i = 0; i < n; i++) { // Loop through each index 'i' from 0 to n-1
            dp[i] = piles[i]; // Base case: single pile sub-range (length 1) yields the pile value itself
        } // End base case loop
        
        for (int len = 2; len <= n; len++) { // Loop for sub-range lengths starting from 2 up to 'n'
            for (int i = 0; i <= n - len; i++) { // Loop for the left index 'i' of the current sub-range
                int j = i + len - 1; // Calculate the right index 'j' based on start 'i' and length 'len'
                
                // Compare picking left pile (piles[i] - opponent's best score dp[i+1]) 
                // vs picking right pile (piles[j] - opponent's best score dp[i])
                dp[i] = Math.max(piles[i] - dp[i + 1], piles[j] - dp[i]); // Update dp[i] with the maximum score difference
            } // End inner start-index loop
        } // End outer length loop
        
        return dp[0] > 0; // Return true if the net score difference for the entire array (dp[0]) is strictly positive
    } // End stoneGame method
} // End Solution class
```

---

[View on LeetCode](https://leetcode.com/problems/stone-game/)
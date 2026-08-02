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
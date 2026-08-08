class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        // rightMatch[i] stores the length of the longest suffix of word2 
        // that can be perfectly matched using the suffix of word1 starting at index i
        int[] rightMatch = new int[n + 1];
        
        // Step 1: Precompute backwards
        int j = m - 1; // Start matching from the end of word2
        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--; // Successfully matched a character, move word2 pointer left
            }
            // Record how many characters we've successfully matched from the end
            rightMatch[i] = (m - 1) - j; 
        }
        
        // Step 2: Greedily build the answer left-to-right
        int[] result = new int[m];
        int resIdx = 0;
        boolean changed = false; // Tracks if we've used our 1 allowed mismatch
        j = 0; // Reset word2 pointer to the beginning
        
        for (int i = 0; i < n && j < m; i++) {
            // Case 1: Perfect Match
            if (word1.charAt(i) == word2.charAt(j)) {
                result[resIdx++] = i;
                j++;
            } 
            // Case 2: Mismatch, but we haven't used our free change yet
            else if (!changed) {
                // How many characters of word2 are left to match AFTER this index?
                int remainingToMatch = m - j - 1;
                
                // Can the rest of word2 be matched perfectly in the rest of word1?
                if (rightMatch[i + 1] >= remainingToMatch) {
                    result[resIdx++] = i; // Take the index
                    j++;                  // Move forward in word2
                    changed = true;       // Consume our one allowed change
                }
            }
        }
        
        // If we successfully built an array of size m, return it
        if (resIdx == m) {
            return result;
        }
        
        // Otherwise, no valid sequence exists
        return new int[0];
    }
}
# Find the Lexicographically Smallest Valid Sequence

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given two strings `word1` and `word2`.

A string `x` is called  **almost equal**  to `y` if you can change  **at most**  one character in `x` to make it  *identical*  to `y`.

A sequence of indices `seq` is called  **valid**  if:

- The indices are sorted in ascending order.
- Concatenating the characters at these indices in word1 in the same order results in a string that is almost equal to word2.

Return an array of size `word2.length` representing the lexicographically smallest  **valid**  sequence of indices. If no such sequence of indices exists, return an  **empty**  array.

 **Note**  that the answer must represent the  *lexicographically smallest array*,  **not**  the corresponding string formed by those indices.

 

 **Example 1:** 

 **Input:**  word1 = "vbcca", word2 = "abc"

 **Output:**  [0,1,2]

 **Explanation:** 

The lexicographically smallest valid sequence of indices is `[0, 1, 2]`:

- Change word1[0] to 'a'.
- word1[1] is already 'b'.
- word1[2] is already 'c'.

 **Example 2:** 

 **Input:**  word1 = "bacdc", word2 = "abc"

 **Output:**  [1,2,4]

 **Explanation:** 

The lexicographically smallest valid sequence of indices is `[1, 2, 4]`:

- word1[1] is already 'a'.
- Change word1[2] to 'b'.
- word1[4] is already 'c'.

 **Example 3:** 

 **Input:**  word1 = "aaaaaa", word2 = "aaabc"

 **Output:**  []

 **Explanation:** 

There is no valid sequence of indices.

 **Example 4:** 

 **Input:**  word1 = "abc", word2 = "ab"

 **Output:**  [0,1]

 

 **Constraints:** 

- 1 <= word2.length < word1.length <= 3 * 105
- word1 and word2 consist only of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 33 ms (beats 80.56%)  
**Memory:** 136.3 MB (beats 94.44%)  
**Submitted:** 2026-08-08T02:35:45.333Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/)
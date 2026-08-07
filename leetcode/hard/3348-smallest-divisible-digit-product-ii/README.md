# Smallest Divisible Digit Product II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a string `num` which represents a  **positive**  integer, and an integer `t`.

A number is called  **zero-free**  if  *none*  of its digits are 0.

Return a string representing the  **smallest**   **zero-free**  number greater than or equal to `num` such that the  **product of its digits**  is divisible by `t`. If no such number exists, return `"-1"`.

 

 **Example 1:** 

 **Input:**  num = "1234", t = 256

 **Output:**  "1488"

 **Explanation:** 

The smallest zero-free number that is greater than 1234 and has the product of its digits divisible by 256 is 1488, with the product of its digits equal to 256.

 **Example 2:** 

 **Input:**  num = "12355", t = 50

 **Output:**  "12355"

 **Explanation:** 

12355 is already zero-free and has the product of its digits divisible by 50, with the product of its digits equal to 150.

 **Example 3:** 

 **Input:**  num = "11111", t = 26

 **Output:**  "-1"

 **Explanation:** 

No number greater than 11111 has the product of its digits divisible by 26.

 

 **Constraints:** 

- 2 <= num.length <= 2 * 105
- num consists only of digits in the range ['0', '9'].
- num does not contain leading zeros.
- 1 <= t <= 1014

## Solution

**Language:** Java  
**Runtime:** 76 ms (beats 34.29%)  
**Memory:** 103.2 MB (beats 5.71%)  
**Submitted:** 2026-08-07T17:08:04.192Z  

```java
class Solution {
    // Lookup table for prime factors of digits 0-9 [count of 2s, 3s, 5s, 7s]
    int[][] primeCounts = {
        {0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 0}, {0, 1, 0, 0}, {2, 0, 0, 0},
        {0, 0, 1, 0}, {1, 1, 0, 0}, {0, 0, 0, 1}, {3, 0, 0, 0}, {0, 2, 0, 0}
    };

    public String smallestNumber(String num, long t) {
        int[] target = new int[4];
        long temp = t;
        
        // Step 1: Extract prime factors from t
        while (temp % 2 == 0) { target[0]++; temp /= 2; }
        while (temp % 3 == 0) { target[1]++; temp /= 3; }
        while (temp % 5 == 0) { target[2]++; temp /= 5; }
        while (temp % 7 == 0) { target[3]++; temp /= 7; }
        
        // If t has prime factors other than 2, 3, 5, 7, it's impossible.
        if (temp > 1) return "-1";

        char[] chars = num.toCharArray();
        int n = chars.length;

        // Step 2: Clean up Zeros. Find the first '0' and convert it and everything after to '1's.
        for (int i = 0; i < n; i++) {
            if (chars[i] == '0') {
                for (int j = i; j < n; j++) {
                    chars[j] = '1';
                }
                break;
            }
        }

        // Step 3: Precompute prefix factors to quickly check state
        int[][] pref = new int[n + 1][4];
        for (int i = 0; i < n; i++) {
            int d = chars[i] - '0';
            for (int k = 0; k < 4; k++) pref[i + 1][k] = pref[i][k] + primeCounts[d][k];
        }

        // Check if the adjusted initial string already satisfies the condition
        if (meetsTarget(pref[n], target)) {
            return new String(chars);
        }

        // Step 4: Right-to-Left search to find the pivot index
        for (int i = n - 1; i >= 0; i--) {
            int currentDigit = chars[i] - '0';
            
            // Try incrementing the current digit
            for (int d = currentDigit + 1; d <= 9; d++) {
                int[] currentFactors = new int[4];
                for (int k = 0; k < 4; k++) currentFactors[k] = pref[i][k] + primeCounts[d][k];

                // Check if the remaining spaces can fulfill the missing factors
                if (canSatisfy(currentFactors, target, n - 1 - i)) {
                    chars[i] = (char) (d + '0');
                    
                    // Step 5: Left-to-Right Greedy Fill for the suffix
                    for (int j = i + 1; j < n; j++) {
                        for (int nxt = 1; nxt <= 9; nxt++) {
                            int[] nextFactors = new int[4];
                            for (int k = 0; k < 4; k++) nextFactors[k] = currentFactors[k] + primeCounts[nxt][k];
                            
                            // Pick the smallest digit that keeps the state valid
                            if (canSatisfy(nextFactors, target, n - 1 - j)) {
                                chars[j] = (char) (nxt + '0');
                                currentFactors = nextFactors;
                                break;
                            }
                        }
                    }
                    return new String(chars);
                }
            }
        }

        // Step 6: If no combination worked within the original length, we must find the new minimum length.
        int newLen = n + 1;
        
        // Find the absolute shortest length that can hold all the target prime factors
        while (!canSatisfy(new int[4], target, newLen)) {
            newLen++;
        }
        
        char[] expanded = new char[newLen];
        int[] currentFactors = new int[4];
        
        // Greedily fill the newly expanded string from left to right
        for (int j = 0; j < newLen; j++) {
            for (int nxt = 1; nxt <= 9; nxt++) {
                int[] nextFactors = new int[4];
                for (int k = 0; k < 4; k++) nextFactors[k] = currentFactors[k] + primeCounts[nxt][k];
                
                if (canSatisfy(nextFactors, target, newLen - 1 - j)) {
                    expanded[j] = (char) (nxt + '0');
                    currentFactors = nextFactors;
                    break;
                }
            }
        }
        
        return new String(expanded);
    }

    // Helper to check if current factors completely cover the target factors
    private boolean meetsTarget(int[] current, int[] target) {
        for (int k = 0; k < 4; k++) {
            if (current[k] < target[k]) return false;
        }
        return true;
    }

    // Helper to determine if we can squeeze the remaining missing factors into `spaces` digits
    private boolean canSatisfy(int[] current, int[] target, int spaces) {
        int req2 = Math.max(0, target[0] - current[0]);
        int req3 = Math.max(0, target[1] - current[1]);
        int req5 = Math.max(0, target[2] - current[2]);
        int req7 = Math.max(0, target[3] - current[3]);

        // 5s and 7s are exclusive, they strictly require one space each
        if (req5 + req7 > spaces) return false;
        
        int remSpaces = spaces - req5 - req7;
        int minLenFor2and3 = Integer.MAX_VALUE;

        // We try all sensible combinations of using '6's (which provide both a 2 and a 3).
        // Since we want to minimize digit length, we see if using some amount of '6's helps compress.
        for (int cnt6 = 0; cnt6 <= Math.min(req2, req3); cnt6++) {
            int c2 = req2 - cnt6;
            int c3 = req3 - cnt6;
            // '8' provides three 2s. '9' provides two 3s. The ceil division calculates how many 8s/9s/4s/2s/3s are needed.
            int len = cnt6 + (c2 + 2) / 3 + (c3 + 1) / 2;
            minLenFor2and3 = Math.min(minLenFor2and3, len);
        }

        return minLenFor2and3 <= remSpaces;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/smallest-divisible-digit-product-ii/)
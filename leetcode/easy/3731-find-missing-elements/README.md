# Find Missing Elements

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given an integer array `nums` consisting of  **unique**  integers.

Originally, `nums` contained  **every integer**  within a certain range. However, some integers might have gone  **missing**  from the array.

The  **smallest**  and  **largest**  integers of the original range are still present in `nums`.

Return a  **sorted**  list of all the missing integers in this range. If no integers are missing, return an  **empty**  list.

 

 **Example 1:** 

 **Input:**  nums = [1,4,2,5]

 **Output:**  [3]

 **Explanation:** 

The smallest integer is 1 and the largest is 5, so the full range should be `[1,2,3,4,5]`. Among these, only 3 is missing.

 **Example 2:** 

 **Input:**  nums = [7,8,6,9]

 **Output:**  []

 **Explanation:** 

The smallest integer is 6 and the largest is 9, so the full range is `[6,7,8,9]`. All integers are already present, so no integer is missing.

 **Example 3:** 

 **Input:**  nums = [5,1]

 **Output:**  [2,3,4]

 **Explanation:** 

The smallest integer is 1 and the largest is 5, so the full range should be `[1,2,3,4,5]`. The missing integers are 2, 3, and 4.

 

 **Constraints:** 

- 2 <= nums.length <= 100
- 1 <= nums[i] <= 100

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 100.00%)  
**Memory:** 46.7 MB (beats 67.71%)  
**Submitted:** 2026-08-04T16:23:24.900Z  

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        boolean[] present = new boolean[101];
        
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            present[num] = true;
        }
        
        List<Integer> missing = new ArrayList<>();
        
        for (int i = min + 1; i < max; i++) {
            if (!present[i]) {
                missing.add(i);
            }
        }
        
        return missing;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-missing-elements/)
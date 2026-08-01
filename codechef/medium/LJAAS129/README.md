# LJAAS129

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Write a program using a for loop to find and print the index of the first occurrence of the number 8 in the array  **{2, 4, 8, 12, 8}**.

### Sample 1:
Input
Output

```

```

```
2
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-01T11:01:15.323Z  

```java
class Codechef
{
	public static void main (String[] args) 
	{
		int[] numbers = {2, 4, 8, 12, 8};
        // Complete the code
        
        for (int i=0;i<numbers.length;i++){
            if(numbers[i]==8){
                System.out.println(i);
                break;
            }
        }

	}
}

```

---

[View on CodeChef](https://www.codechef.com/problems/LJAAS129)
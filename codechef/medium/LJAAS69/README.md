# LJAAS69

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Write a program to check whether the given numbers are divisible by both `3` and `5`.

The input has already been taken in the provided code. You only need to complete the logic and print the result for each number.

For each number:

- Print Divisible by both 3 and 5 if the number is divisible by both 3 and 5.
- Otherwise, print Not divisible by both 3 and 5.
### Sample 1:
Input
Output

```
15
20
```

```
Divisible by both 3 and 5
Not divisible by both 3 and 5

```

### Explanation:

15 is divisible by both 3 and 5. 20 is not divisible by both 3 and 5.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-01T10:47:31.404Z  

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num;
        Scanner scanner = new Scanner(System.in);

        //check the first number
        num = scanner.nextInt();
        if(num % 3==0 && num % 5 == 0) {
           System.out.println("Divisible by both 3 and 5");
        } else {
            System.out.println("Not divisible by both 3 and 5");
        }

        //check the second number
        num = scanner.nextInt();
        if(num % 3==0 && num % 5==0){
            System.out.println("Divisible by both 3 and 5");
        } else {
            System.out.println("Not divisible by both 3 and 5");
        }
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/LJAAS69)
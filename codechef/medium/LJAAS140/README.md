# LJAAS140

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Write a program to compute and print the area of a rectangle. Take length and width as user inputs.

### Sample 1:
Input
Output

```
5 8
```

```
40
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-01T11:03:54.237Z  

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Take length and width as input
        
        Scanner scanner= new Scanner(System.in);
        
        int length = scanner.nextInt();
        int width = scanner.nextInt();
        
        int area = calculateArea(length, width);
        System.out.println(area);   
        
        scanner.close();
    }
    
    public static int calculateArea(int length, int width) {
        // Complete this method
        return length * width;
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/LJAAS140)
# LJAAS60

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Write a program to print the grades of 3 students based on the marks they have obtained provided as input. The student is graded  **A**  if marks are greater than  **90**,  **B**  if marks are greater than  **70**,  **C**  if greater than or equal to  **40**, else  **F**.

[ **Note:**  You need to take inputs for all 3 students.]

### Sample 1:
Input
Output

```
95  
40  
20  
```

```
A  
C  
F  
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-01T10:39:53.641Z  

```java
import java.util.Scanner;

class Codechef
{
	public static void main (String[] args) 
	{
		// your code goes here
		Scanner sc= new Scanner(System.in);
		
		for(int i=0;i<3;i++){
		    int marks=sc.nextInt();
		    
		    if(marks>90){
		        System.out.println("A");
		    } else if (marks>70) {
		        System.out.println("B");
		    } else if (marks>=40){
		        System.out.println("C");
		    } else{
		        System.out.println("F");
		    }
		}
		sc.close();

	}
}

```

---

[View on CodeChef](https://www.codechef.com/problems/LJAAS60)
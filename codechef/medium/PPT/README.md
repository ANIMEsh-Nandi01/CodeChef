# PPT

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Presentation

Chef needs to give a presentation that lasts exactly $10$ minutes (or $600$ seconds). He will prepare a slide show containing some number of slides for the presentation.

He knows that he takes exactly $30$ seconds to cover each slide. He has already made $N$ slides. How many more slides does he need to make so that his presentation lasts exactly $10$ minutes?

### Input Format
- The first and only line of input contains a single integer $N$ - the number of slides Chef has already made.
### Output Format

Output the number of slides Chef still has to make.

### Constraints
- $0 \le N \le 20$
### Sample 1:
Input
Output

```
10

```

```
10

```

### Explanation:

Chef's $10$ slides only take $300$ seconds, so he needs to another $10$ slides.

### Sample 2:
Input
Output

```
0

```

```
20

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-05T16:09:10.426Z  

```java
import java.util.Scanner;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // Initialize the Scanner to read input from the standard input stream
        Scanner sc = new Scanner(System.in);
        
        // Check if there is an integer to read (good practice for competitive programming)
        if (sc.hasNextInt()) {
            // Read the number of slides Chef has already completed
            int n = sc.nextInt();
            
            // Calculate total required slides (600 / 30 = 20)
            int totalSlidesRequired = 20;
            
            // Subtract completed slides from the total to find the remaining amount
            int remainingSlides = totalSlidesRequired - n;
            
            // Output the final result
            System.out.println(remainingSlides);
        }
        
        // Close the scanner to prevent resource leaks
        sc.close();
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/PPT)
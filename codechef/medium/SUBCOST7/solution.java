import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            
            while(t-- > 0) {
                int n = sc.nextInt();
                int x = sc.nextInt();
                int y = sc.nextInt();
                
                if (n <= 3) {
                    System.out.println(n * x);
                } else {
                    System.out.println((3 * x) + ((n - 3) * y));
                }
            }
        }
    }
}
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
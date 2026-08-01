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
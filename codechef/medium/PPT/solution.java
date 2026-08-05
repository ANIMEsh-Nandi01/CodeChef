import java.util.Scanner;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
        
            int n = sc.nextInt();
            int totalSlidesRequired = 20;
            int remainingSlides = totalSlidesRequired - n;
            
            System.out.println(remainingSlides);
        }
        
        sc.close();
    }
}
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
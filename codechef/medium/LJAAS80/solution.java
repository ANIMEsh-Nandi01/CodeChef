import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) 
    {
        //your code goes InheritableThreadLocal
        Scanner scanner = new Scanner(System.in);
        
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        
        char operator = scanner.next().charAt(0);
        
        switch(operator) {
            case '+':
                System.out.println(num1 + num2);
                break;
            case '-':
                System.out.println(num1-num2);
                break;
            case '*':
                System.out.println(num1*num2);
                break;
            case '/':
                System.out.println(num1/num2);
                break;
        }
        
        scanner.close();
        
        
    }
}
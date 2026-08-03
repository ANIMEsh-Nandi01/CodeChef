import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		
		if(sc.hasNextInt()){
		    int x=sc.nextInt();
		    
		    
		    if(x%11==0){
		        System.out.println("No");
		    } else {
		        System.out.println("Yes");
		    }
		}
		sc.close();
	}
}

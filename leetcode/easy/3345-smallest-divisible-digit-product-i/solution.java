class Solution {
    public int smallestNumber(int n, int t) {
        
        while (true) {           
            int product = 1;
            int currentNumber = n;
            
            while (currentNumber > 0) {                
                product *= (currentNumber % 10);                
                currentNumber /= 10;
            }
            
            if (product % t == 0) {            
                return n;
            }
            
            n++;
        }
    }
}
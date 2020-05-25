package heap;



class Ugly {
    public int[] ugly = new int[1690];
 
    Ugly() {
        int i2 = 0, i3 = 0, i5 = 0;
        ugly[0] = 1; 
        
        int next_multiple_of_2 = ugly[i2] * 2;
        int next_multiple_of_3 = ugly[i3] * 3;
        int next_multiple_of_5 = ugly[i5] * 5;
        
        // Pre-compute all the Ugly Number
        for(int i=1; i < 1690; i++) {
            int next_ugly_num = Math.min(next_multiple_of_2, Math.min(next_multiple_of_3, next_multiple_of_5));            
            ugly[i] = next_ugly_num;
            
            if(next_ugly_num == next_multiple_of_2) {
                i2++;
                next_multiple_of_2 = ugly[i2] * 2;
            } 
            
            if(next_ugly_num == next_multiple_of_3) {
                i3++;
                next_multiple_of_3 = ugly[i3] * 3;
            } 
            
            if(next_ugly_num == next_multiple_of_5){
                i5++;
                next_multiple_of_5 = ugly[i5] * 5;
            }
        }
    }
}



public class UglyNumDp {
    // Creating a static instance of the class
    public static Ugly u = new Ugly();
    
    public int nthUglyNumber(int n) {
        return u.ugly[n-1];
    }
    
    
    public static void main(String[] args) {
    	UglyNumDp ug2 = new UglyNumDp();
    	int num = ug2.nthUglyNumber(8);
    	System.out.print("Nth Ugly Number using Dp: " + num);
    }
	
}

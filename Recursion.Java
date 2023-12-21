// "static void main" must be defined in a public class.
public class Recursion {
    public static void main(String[] args) {
        Main m = new Main();
        int sum=0;
        int rem=2;
       /* System.out.println(m.linearSearch(new int[]{10,70,7,3},700));*/
        m.printPattern(4,0);
    }
    /** recursive print below pattern
        #####
        ####
        ###
        ##
        #
    */
    public void printPattern(int occurence){
        if(occurence ==0){
            return;
        }
        for(int i=0;i < occurence;i++){
            System.out.print("*");
        }
        System.out.println();
        printPattern(occurence-1);
    }
    public void printPattern(int row, int col){
       if(row ==0){
           return;
       }
        if(col < row){
            System.out.print("*");
            printPattern(row, col+1);
        }
       else{
            System.out.println();
            printPattern(row-1, 0);
       }
        
    }
    
    //#recursive search element in an array
    public int linearSearch(int[] nums, int target){
        return linearSearch(nums,0,target);
    }
    public int linearSearch(int[] nums,int idx, int target){
        if(idx > nums.length-1){
            return -1;
        }
        if(target == nums[idx]){
            return idx;
        }
        return linearSearch(nums,idx+1,target);
    }
    //#recursive whether given array is sorted
    public boolean isSortedArray(int[] nums){
        return isSortedArray(nums,0,1,nums.length-1);
    }
    public boolean isSortedArray(int[] nums, int left, int right, int length){
        if(right > length){
            return true;
        }
        if(nums[left] <= nums[right]){
            return isSortedArray(nums,left+1, right+1, length);
        }else{
            return false;
        }
    }
    //recursive approach reverse num 
    public int rev(int num){
        int sum=0;
        rev(num,sum);
        return sum;
    }
    public int rev(int num,int sum){
        if(num <= 0){
            return 0;
        }
        int rem = num % 10;
        sum = sum * 10 + rem;
        return rev(num/10, sum);
    }
    //recursive approach to reverse a number
    public void reverseNum(int num){
        if(num <=0){
            return ;
        }
        System.out.println(num%10);
        reverseNum(num/10);
    }
    //recursive approach to solve the sum of a digit of a number
    public int digitSum(int num){
        if(num <= 0){
            return 0;
        }
        return (num%10) + digitSum(num/10);
    }
    
    //recursive approach to solve factorial
    public int factorial(int n){
        if(n <=0){
            return 1;
        }
        return n * factorial(n-1);
    }
    
    //recursive approach to solve binary search
    public int binarySearch(int[] nums, int value){
        return binarySearch(nums,0,nums.length-1,value);
    }
    public int binarySearch(int[] nums, int left, int right,int value){
        if(left > right){
            return -1;
        }
        int mid = (left + (right - left)) / 2;
        if(nums[mid] == value){
            return mid;
        }
        if(value > nums[mid]){
            return binarySearch(nums,mid+1, right,value);
        }
        return binarySearch(nums,left,mid-1,value);   
    }
    //fibbonaci number using recursion
    public int fib(int n){
        if(n < 2){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
    
}

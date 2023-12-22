package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {
    public static void main(String[] args) {
        Main m = new Main();
        int sum=0;
        int rem=2;
        /* System.out.println(m.linearSearch(new int[]{10,70,7,3},700));*/
       // m.printPattern(4,0);
        int[] arr=new int[]{5,4,3,1,2};

        //List<String> list= new ArrayList<>();
       // System.out.println(m.subset(new int[]{1,2,3}));;
        //System.out.println(list);
        m.permutation("abc","");
    }
    //recursive permutaiton and combination
    public void permutation(String src,String out){
        if(src.isEmpty()){
            System.out.println(out);
            return;
        }
        char ch = src.charAt(0);
        for(int i=0; i <= out.length(); i++){
            String f = out.substring(0,i);
            String s = out.substring(i,out.length());
            String str = f + ch + s;
            permutation(src.substring(1),str);
        }
    }
    //iterative subset
    public List<List<Integer>> subset(int[] arr){
        List<List<Integer>> finalList = new ArrayList<>();

        int i=0;
        while(i < arr.length){

            if(!finalList.isEmpty()){
                int j=0;
                while (j < finalList.size()){
                    if(arr[i] == finalList.get(j).get(0)){
                        break;
                    }
                    List<Integer> lastSub = finalList.get(j);
                    List<Integer> newSub = new ArrayList<>(lastSub);
                    newSub.add(arr[i]);
                    finalList.add(newSub);
                    j++;
                }
            }
            if(finalList.isEmpty()){
                finalList.add(List.of());
                finalList.add(List.of(arr[i]));
            }
            i++;

        }
        return finalList;
    }

    //recursive subset
    public void subSet1(String src,String out,List<String> list){
        if(src.isEmpty()){
            list.add(out);
            return;
        }
        //take
        String s = src.charAt(0)+"";
        subSet1(src.substring(1),s+out,list);
        //ignore
        subSet1(src.substring(1),out,list);
    }
    //recursive String remove apple from String
    public String solveStringP2(String src){
        String answer = "";
        if(src.isEmpty()){
            return "";
        }
        if(src.startsWith("apple")){
            return solveStringP2(src.substring(5));
        }else {
            return src.charAt(0)+ solveStringP2(src.substring(1));
        }
    }
    //recursive string baccad, remove a from it
    public String solveStringP1(String src){
         return solveStringP1Helper(src);
    }

    private String  solveStringP1Helper(String src, String parsed) {
        if(src.isEmpty()){
            return parsed;
        }
        char c = src.charAt(0);
        if(c=='a'){
            return solveStringP1Helper(src.substring(1),parsed);
        }else{
            parsed = parsed+c;
            return solveStringP1Helper(src.substring(1),parsed);
        }
    }
    private String  solveStringP1Helper(String src) {
        //String answer="";
        if(src.isEmpty()){
            return src;
        }
        char c = src.charAt(0);
        if(c=='a'){
            return solveStringP1Helper(src.substring(1));
        }else{
            String ans=""+c;
            return ans +  solveStringP1Helper(src.substring(1));
        }
    }

    /*recursive merge sort */
    public int[] mergeSort(int[] arr, int left, int right){
        if(arr.length ==1){
            return arr;
        }
        int mid = (left +(right-left)) /2;
       int leftArr[] = mergeSort(Arrays.copyOfRange(arr,0,mid), left, mid);
       int rightArr[] = mergeSort(Arrays.copyOfRange(arr,mid,arr.length),mid,right);
       return merge(leftArr,rightArr);
    }

    private int[] merge(int[] leftArr, int[] rightArr) {
        int[] newArr = new int[leftArr.length+ rightArr.length];
        int leftI =0;
        int rightI = 0;
        int i=0;
        while (leftI < leftArr.length && rightI < rightArr.length){
            if(leftArr[leftI] < rightArr[rightI]){
                newArr[i] = leftArr[leftI];
                leftI++;
                i++;
            }else{
                newArr[i] = rightArr[rightI];
                i++;
                rightI++;
            }
        }
        if(leftI < leftArr.length){
            while (leftI < leftArr.length){
                newArr[i] = leftArr[leftI];
                leftI++;
                i++;
            }
        }else{
            while (rightI < rightArr.length){
                newArr[rightI] = rightArr[rightI];
                rightI++;
                i++;
            }
        }
        return  newArr;
    }

    /*recursive selection sort
    select the largest element and swap it with the last element
and in the next phase again find the next highest element excluding the last index, and swap it with the second last element */
    public void selectionSort2(int[] arr,int row,int col, int max){
        if(row == 0){
            return;
        }
        if(col < row){
            if(arr[col] > arr[max]){
                selectionSort2(arr,row,col+1,col);
            }else {
                selectionSort2(arr,row,col+1,max);
            }
        }else {
            int temp = arr[max];
            arr[max] = arr[row-1];
            arr[row-1] = temp;
            selectionSort2(arr,row-1,0,0);
        }
    }
    public void selectionSort(int[] arr, int length){
        if(length <=0){
            return;
        }
        int maxIdx = findMax(arr, length);
        replace(arr,maxIdx, length);
        selectionSort(arr,length-1);
    }
    private void replace(int[] arr,int maxIdx, int idx) {
        int tmp = arr[idx];
        arr[idx] = arr[maxIdx];
        arr[maxIdx] = tmp;
    }
    private int findMax(int[] arr, int length) {
        int max = arr[0];
        int idx =0;
        for(int i=0; i <= length; i++){
            if(arr[i] > max){
                max = arr[i];
                idx = i;
            }
        }
        return idx;
    }
    //recursive bubble sort pattern
    public void bblSort(int [] arr,int row, int col){
        if(row < 0){
            return;
        }
        if(col < row){
           if(arr[col] > arr[col+1]){
               int temp = arr[col];
               arr[col] = arr[col+1];
               arr[col+1] = temp;
           }
            bblSort(arr,row,col+1);
        }else{
            bblSort(arr,row-1,0);
        }
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
        if(row <0){
            return;
        }
        if(col < row){
            System.out.print("*");
            printPattern(row,col+1);
        }else{
            System.out.println();
            printPattern(row-1,0);
        }
    }
    public void printPattern2(int row, int col){
        if(row <0){
            return;
        }
        if(col < row){
            printPattern2(row,col+1);
            System.out.print("*");
        }else{
            printPattern2(row-1,0);
            System.out.println();
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

package org.example.prep.gs;

public class Min_Num_Platforms_Required {
    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

        int arr1[] = {900, 940};
        int dep1[] = {910, 1200};

        if (findPlatform(arr, dep) == 3 && findPlatform(arr1, dep1) == 1)
            System.out.println("All Tests Pass");
        else
            System.out.println("There are test failures");
    }
    public static int findPlatform(int arr[], int dep[]) {
        int pCount =1;
        //navigate to arrival & departure trains
        int arrivedTime = arr[0];
        int lastDepartTime = dep[0];
        for(int i = 1; i < arr.length; i++ ){
            int newTrainArrivalAt = arr[i];
            if(newTrainArrivalAt > lastDepartTime){
                lastDepartTime = dep[i];
                pCount--;
                continue;
            }else{
                pCount++;
            }
        }
        return pCount+1;
    }
}

package org.example.prep.gs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BestAverageGrade {
    public static Integer bestAvgGrade(String[][] scores)
    {
        Map<String, List<Integer>> map =new HashMap<>();
        for(String[] record: scores){
            String name = record[0];
            int score = Integer.valueOf(record[1]);
            if(map.containsKey(name)){
                List<Integer> scoreList = map.get(name);
                scoreList.add(score);
                map.put(name,scoreList);
            }else{
                List<Integer> scoreList = new ArrayList<>();
                scoreList.add(score);
                map.put(name,scoreList);
            }
        }
        int averageHighest = Integer.MIN_VALUE;
        for(String name:map.keySet()){
            int average = map.get(name).stream().collect(Collectors.averagingInt(Integer::intValue)).intValue();
            if(average > averageHighest){
                averageHighest = average;
            }
        }
        return averageHighest;
    }

    public static boolean pass()
    {
        String[][] s1 = { { "Rohan", "84" },
                { "Sachin", "102" },
                { "Ishan", "55" },
                { "Sachin", "18" } };

        return bestAvgGrade(s1) == 84;
    }

    public static void main(String[] args)
    {
        if(pass())
        {
            System.out.println("Pass");
        }
        else
        {
            System.out.println("Some Fail");
        }
    }
}

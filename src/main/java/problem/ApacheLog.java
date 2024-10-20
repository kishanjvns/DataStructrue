package problem;

import java.util.LinkedHashMap;
import java.util.Map;

public class ApacheLog {
    private static String findTopIpaddress(String[] input){

        String result="";
        int maxCount=0;
        Map<String,Integer> map=new LinkedHashMap<>();
        for(String logRecord:input){
            String ipAdd = logRecord.split("-")[0].trim();
            if(map.containsKey(ipAdd)){
                int count=map.get(ipAdd);
                map.put(ipAdd,++count);
                if(count > maxCount){
                    result=ipAdd;
                    maxCount=count;
                }
            }else{
                map.put(ipAdd,1);
                if(1 > maxCount){
                    result=ipAdd;
                    maxCount=1;
                }
            }
        }
        System.out.println(result);
        return result;

    }
    //https://lion.app.box.com/s/2ds118s5pgzntoue5gpvip8eh1dre1a0/file/962890611826
    public static void main(String[] args) {
        ApacheLog t =new ApacheLog();
        String lines[] = new String[] {
                "10.0.0.1 - log entry 1 11",
                "10.0.0.1 - log entry 2 213",
                "10.0.0.2 - log entry 133132" };
        String result = findTopIpaddress(lines);

        if (result.equals("10.0.0.1")) {
            System.out.println("Test passed");

        } else {
            System.out.println("Test failed");

        }

    }
}

package org.example.prep.gs;

import java.util.Map;

public class DistanceBetweenTwoWordMidPoint {
    public static double shortestDistance(String paragraph, String wordOne, String wordTwo) {
        String[] paras = paragraph.split("[., ]");

        int keepParaIndex = 0;
        double midPointW1 = 0;
        double midPointW2 = 0;
        double shortestPath =0;
        for(String paraWord: paras){
            if(paraWord.equalsIgnoreCase(wordOne)){
                midPointW1 = keepParaIndex + (paraWord.length()/2d);
            }if(paraWord.equalsIgnoreCase(wordTwo)){
                midPointW2 = keepParaIndex + (paraWord.length()/2d);
            }
            if(midPointW1 > 0 && midPointW2 > 0){
                double currentMid = Math.abs((midPointW1 - midPointW2));
                if(currentMid > shortestPath){
                    shortestPath = currentMid;
                }
            }
            keepParaIndex = paraWord.length()+1;
        }
        if(midPointW1 < 0 || midPointW2 < 0){
            shortestPath = -1;
        }
        return shortestPath;
    }

    public static boolean pass() {
        return shortestDistance( document, "we", "just" ) == 4;
       //return shortestDistance(document, "Design", "filler" ) == 25d;
       /* return  shortestDistance(document, "and", "graphic") == 6d &&
                shortestDistance(document, "transfer", "it") == 14d &&
                shortestDistance(document, "Design", "filler" ) == 25d ;*/
    }

    public static void main(String[] args) {
        if (pass()) {
            System.out.println("Pass");
        } else {
            System.out.println("Some Fail");
        }
    }

    private static final String document;
    static{

        StringBuffer sb = new StringBuffer();
        //sb.append("In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements");
        //sb.append(" lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements");
        //sb.append(" for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which");
        sb.append("Example we just made up");
        document = sb.toString();
    }
}

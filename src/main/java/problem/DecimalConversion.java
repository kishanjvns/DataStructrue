package problem;

import java.util.*;

public class DecimalConversion {
    /**
     * Return the fraction output in the following way Examples: If after decimal,
     * repeating numbers are there in the output . eg. 1/3=0.333333333, this should
     * be represented as 0.(3) 6/11=0.54545454, this should be represented as 0.(54)
     * fractionRepresentation(1,2)=0.5 fractionRepresentation(1,3)=0.(3)
     * fractionRepresentation(6,11)=0.(54)
     */
    /**
     * 1/2 -> res 0.5 and should be 0.5
     * 1/3 -> res 0.33333334 should be 0.(3)
     * 6/11 -> res 0.54545456 should be 0.(54)
     * */
    public static String fractionRepresentation2(int numerator, int denominator)
    {
        if(denominator <= 0) throw new IllegalArgumentException("denominator must be a positive number");

        boolean isNegative = numerator < 0;
        numerator = Math.abs(numerator);

        int integer = numerator / denominator;
        numerator = numerator % denominator;

        Set<Integer> reminders = new LinkedHashSet<>();
        int cycleBeginsAtReminder = -1;

        while(numerator != 0) {
            numerator *= 10;

            int reminder = numerator % denominator;

            if(reminders.contains(numerator)) {
                cycleBeginsAtReminder = numerator;
                break;
            }

            reminders.add(numerator);
            numerator = reminder;
        }

        StringBuffer buffer =  new StringBuffer();
        if(isNegative) buffer.append('-');
        buffer.append(integer);

        if(!reminders.isEmpty()) {
            buffer.append('.');
            for(int reminder : reminders) {
                if(Objects.equals(reminder, cycleBeginsAtReminder)) {
                    buffer.append('(');
                }
                buffer.append(reminder / denominator);
            }
            if(cycleBeginsAtReminder != -1l) {
                buffer.append(')');
            }
        }

        return buffer.toString();
    }
    public static String fractionRepresentation(int num, int den) {
        StringBuilder sb= new StringBuilder();
        if(den < 0){
            throw new IllegalArgumentException("Invalid value");
        }
        num=Math.abs(num);

        sb.append(num/den);
        num=num%den;
        Set<Integer> set=new LinkedHashSet<>();
        int cycleBegin=-1;
        while (num != 0){
            num*=10;
            int rem=num%den;
            if(set.contains(num)){
                cycleBegin=num;
                break;
            }
            set.add(num);
            num=rem;
        }
        if(set.isEmpty()){
           return sb.toString();
        }
        sb.append(".");
        for(int rem:set){
            if(cycleBegin==rem){
                sb.append("(");
            }
            sb.append(rem/den);
        }
        if(cycleBegin!=-1){
            sb.append(")");
        }
        return sb.toString();
    }
    public static void main(String args[]) {
        // float f=6/11f;
        // System.out.println(f);
        System.out.println(fractionRepresentation(1, 2) + " " + fractionRepresentation(1, 3) + " "
                + fractionRepresentation(6, 11));

        if (fractionRepresentation(1, 2).equals("0.5") && fractionRepresentation(6, 11).equals("0.(54)")
                && fractionRepresentation(1, 3).equals("0.(3)")) {
            System.out.println("All passed");
        } else {
            System.out.println("Failed");
        }

    }
}


import com.sun.jdi.DoubleValue;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        long n = 2222222222l;
        double total = 0;
        long startTime = System.currentTimeMillis();

        for(long i=0;i<n;i++){
            double value = Math.pow(-1, i)/(2*i+1);
            total += value;
        }

        double pi = total*4;
        long endTime = System.currentTimeMillis();
        double totalTime = endTime - startTime;

        System.out.println("The PI: "+pi);
        System.out.println("Total time: "+timeToMinutes(totalTime));
    }

    public static String timeToMinutes(double milliseconds){
        double seconds = milliseconds / 1000;

        if((seconds/60)<1){
            return getIntegerPart(seconds)+" seconds";
        }
        double minutesDecimal = seconds/60;
        long minutes = getIntegerPart(minutesDecimal);
        double restSeconds = getDecimalPart(minutesDecimal);
        return minutes+" minutes "+(getIntegerPart(restSeconds*60))+" seconds";
    }

    public static long getIntegerPart(double number){
        return new BigDecimal(String.valueOf(number)).longValue();
    }

    public static double getDecimalPart(double number){
        return new BigDecimal(String.valueOf(number)).remainder(BigDecimal.ONE).doubleValue();
    }
}

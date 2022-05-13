import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Scanner objectScan = new Scanner(System.in);

        System.out.println("Wall length in metres?");
        int width = scan.nextInt();

        System.out.println("Wall height in metres?");
        int height = scan.nextInt();

        int area = width * height;
        System.out.println("The area of your wall is " + area + " metres squared");

        System.out.println("Do you have exclusions (door/window, y/n)?");
        String object = objectScan.nextLine();

        double totalArea = area;

        if (object.equals("y")) {
            System.out.println("What is the total width of your objects?");
            int objectWidth = scan.nextInt();

            //add array later

            System.out.println("What is the total height of your objects?");
            int objectHeight = scan.nextInt();
            int objectArea = (objectHeight * objectWidth);
            System.out.println("Object Area= " + objectArea);

            totalArea = (area - objectArea);
            int totalAreaF = (int) totalArea;
            System.out.println("your total area is " +totalAreaF);
        }


        System.out.println("How Many litres per paint bucket?");

        int paintBucket = scan.nextInt();
        //1 litre of paint averages 12 metres squared, average bucket between 5-30 litres

        paintBucket = 12 * paintBucket;
        double isDivisable;
        isDivisable = (double)paintBucket / totalArea;
        boolean isLessThan1 = (isDivisable < 1);
        if (isLessThan1){

            double bucketsNeeded = (totalArea / paintBucket);
            System.out.println("Paint Buckets Required = " + Math.ceil(bucketsNeeded));

        }
        else
            System.out.println("1 Bucket Required");
        NumberFormat formatter = new DecimalFormat("#0.00");
        double litresNeeded = totalArea / 12;
        System.out.println("In total " + formatter.format(litresNeeded) + " litres needed" );
    }
}

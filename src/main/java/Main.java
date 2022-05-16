import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
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

        System.out.println("Do you have exclusions (doors/windows etc?, y/n)?");
        String object = objectScan.nextLine().toLowerCase();


        double totalArea = area;

        //Adding multiple objects
        if (object.equals("y")) {

            System.out.println("How many objects are on your wall?");
            int[] objectsArray = new int[scan.nextInt()];
            int[] objectAreaList = new int[objectsArray.length];

            int objectCount = objectsArray.length;
            int objectArea;
            for (int i = 0; i < objectCount; i++) {
                System.out.println("What is the width of your object?");
                int objectWidth = scan.nextInt();


                System.out.println("What is the height of your object?");
                int objectHeight = scan.nextInt();

                objectArea = (objectHeight * objectWidth);
                System.out.println("Object Area= " + objectArea);


                objectAreaList[i] = objectArea;
                System.out.println("Your object area's " + Arrays.toString(objectAreaList));
            }
            int objectTotal = 0;
            for (int j : objectAreaList) {
                objectTotal += j;

            }
            totalArea = (area - objectTotal);
            int totalAreaF = (int) totalArea;
            System.out.println("your total area for painting is " + totalAreaF + " metres squared");
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

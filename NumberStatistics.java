import java.util.Scanner;

public class NumberStatistics {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        int count = 0;
        int positiveCount =0;
        int negativeCount= 0;
        double largest=0;
        double smallest=0;
        double sum=0;
        
        while (true) { 
            System.out.print("Enter a number:");
            double number = input.nextDouble();
            

            if (number == 0){

                break;
            }
             if (count == 0) {
                largest = number;
                smallest = number;
            }
            
            
            if( number >0 ){
                positiveCount++;
                //System.out.println("Total positive number: "+ positiveCount);
                
            }
            else{
                negativeCount++;
                //System.out.println("Total negative number: "+ negativeCount);
            }
            
            if ( number > largest){
                largest= number ;
                //System.out.println("Largest number: "+ largest);
            }
            if (number < smallest){
                smallest= number;
                //System.out.println("Smallest number: "+ smallest);
            }

            sum= sum + number;

            count++;
        }
        if (count >0){

            double average = sum/count;
            System.out.println("Total numbers: "+ count);
            System.out.println("Total positive numbers: "+positiveCount );
            System.out.println("Total negative numbers: "+ negativeCount);
            System.out.println("Largest number: "+ largest);
            System.out.println("Smallest number: "+ smallest);
            System.out.println("Average: "+ average);
        }
        else System.out.println("No numbers are entered.");

    }
}
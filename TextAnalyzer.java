import java.util.Scanner;

public class TextAnalyzer {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();

        int characters = sentence.length();
        int charactersWithoutSpaces =0;
        int vowels =0;
        int consonants =0;
        int digits = 0;

        for (int i=0; i<sentence.length(); i++){
            char c = sentence.charAt(i); // this line means: give me the character at a particular position in this strings.                  

            if( c!= ' '){
                charactersWithoutSpaces++;
            }

            if (Character.isLetter(c)){
                char lowerC = Character.toLowerCase(c);
                
                if (lowerC == 'a' || lowerC =='e'|| lowerC =='i'|| lowerC =='o'|| lowerC=='u'){
                    vowels++;
                }
                else{
                    consonants++;
                }
            }

            if(Character.isDigit(c)){
                digits++;

            }
        }

        String reversed ="";
        for (int i =sentence.length()-1; i>=0; i--){

            reversed = reversed + sentence.charAt(i); //Take whatever is already inside reversed, add the current character to the end, then save the new result back into reversed.
            
        }

        char mostFrequent =' ';
        int maxCount =0;
        for (int i =0; i<sentence.length(); i++){
            char current = sentence.charAt(i);
            int frequency =0;
            for(int j =0; j<sentence.length();j++){
                if (current ==sentence.charAt(j)){
                    frequency++;
                }
            }
            if (frequency>maxCount){
                maxCount = frequency;
                mostFrequent= current;
            }
        }




        String[] words= sentence.trim().split("\\s+"); //"trim" removes unnecessary spaces from the beginning and end of a string. it doesnt remove the spaces between the words.
        //"split("\\s"+)"-> break one string into multiple pieces.
        //"\s" represents whitespace. Split the sentence wherever there are one or more spaces/whitespace characters.
    
        System.out.println("Vowels: "+ vowels);
        System.out.println("consonants: "+ consonants);
        System.out.println("Digits: "+ digits);
        System.out.println("Reversed: "+reversed);
        System.out.println("Most frequent character: "+ mostFrequent);
        System.out.println("Frequency: "+ maxCount);
    }


}

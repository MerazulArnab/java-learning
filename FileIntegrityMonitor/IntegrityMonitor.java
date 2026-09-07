import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest; //MessageDigest is a Java class that can calculate hashes such as SHA-256
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Scanner;


public class IntegrityMonitor {
    public static void main(String[] args) {
        //File file = new File("monitored_files/report.txt");
        File directory = new File("monitored_files");
        
        File[] files = directory.listFiles();
        //Scanner input = new Scanner(file);
    

        //System.out.println("File: "+file.getName());
        //System.out.println("SHA-256: "+hash);

        HashMap<String, String> originalHashes = new HashMap<>();
        // key = filename-> String
        //Value = SHA-256 -> String
        for(int i =0; i<files.length; i++){
            File file = files[i];
            
            if(file.isFile()){
                String hash = calculateSHA256(file);
                originalHashes.put(file.getName(), hash); //Store this filename as the key and its SHA-256 hash as the value.

                System.out.println(file.getName());
                System.out.println("SHA-256: "+hash);
                
                System.out.println();
            }
        }
        saveBaseline(originalHashes);
        Scanner input = new Scanner(System.in);
        System.out.println("Original hashes saved.");
        input.nextLine();
        
        File[] currentFiles = directory.listFiles();
        //Get all the files that are currently inside monitored_files and store them in an array called currentFiles.
        for (int i=0; i<currentFiles.length; i++){
            File file = currentFiles[i];
            if(file.isFile()){
                
                String currentHash = calculateSHA256(file); //Calculate the SHA-256 of this file right now and store it in currentHash.
                if(!originalHashes.containsKey(file.getName())){
                    System.out.println("Files: "+file.getName());
                    System.out.println("New File.");
                    continue;
                }


                String originalHash= originalHashes.get(file.getName());

                System.out.println("Files: "+file.getName());
                System.out.println("Original: "+ originalHash);
                System.out.println("Current: "+ currentHash);

                
                

                if( originalHash.equals(currentHash)){
                    System.out.println("Unchanged.");
                }
                else{
                    System.out.println("Modified file.");
                }


            }
           
            
        }
        String [] originalFileNames = originalHashes.keySet().toArray(new String[0]);
        for(int i =0; i< originalFileNames.length; i++){
            String fileName = originalFileNames[i];
            
            File originalFile = new File(directory, fileName);

            if(!originalFile.exists()){
                System.out.println("Files: "+ fileName);
                System.out.println("Deleted file.");
            }
        }
        

    }

    public static String calculateSHA256(File file){
        try {
        
            MessageDigest digest =MessageDigest.getInstance("SHA-256");
            //   |           |              |
            // java class  variable      give me a SHA-256 calculator

            FileInputStream input =  new FileInputStream(file);
            // |               |              |
            // java class     variable       open this file so we can read its bytes
            //FileInputStream is used to open a file and read its raw bytes

            byte[] buffer = new byte[1024]; // creates an array that can have temporary space that can hold 1024 bytes at a time
            int bytesRead; // created a variable that will tell us how many bytes were actually read

            while((bytesRead = input.read(buffer)) != -1){ // for negative it will be stopped
                digest.update(buffer, 0, bytesRead);
                // buffer-> where the file bytes are temporarily stored
                //0-> start reading from position 0 of the buffer
                //bytesRead-> how many bytes from the buffer should actually be used

            }
            input.close();
            byte[] hashBytes = digest.digest(); //getting the hash here
            //|      |              |
            //array  variable       finish SHA-256 and return the hash bytes
            //of bytes

            StringBuilder hexString = new StringBuilder(); //StringBuilder is a Java class that lets us build a String piece by piece.
            for (int i=0; i<hashBytes.length; i++){
                String hex = Integer.toHexString(0xff & hashBytes[i]);
                if (hex.length() ==1){
                    hexString.append("0");
                }
                hexString.append(hex);
            }
            return hexString.toString();
        }
         catch ( IOException | NoSuchAlgorithmException e) {
            System.out.println("Error calculating SHA-256.");
            return null;

        }
        
    }

    public static void saveBaseline(HashMap<String, String> originalHashes) {

        try {

        BufferedWriter writer = new BufferedWriter(
                new FileWriter("baseline.txt")
        );

        String[] fileNames =originalHashes.keySet().toArray(new String[0]);

            for (int i = 0; i < fileNames.length; i++) {

            String fileName = fileNames[i];
            String hash = originalHashes.get(fileName);

            writer.write(fileName + "=" + hash);
            writer.newLine();
            }

        writer.close();

        System.out.println("Baseline saved to baseline.txt");
        }
    catch (IOException e) {

        System.out.println("Error saving baseline.");
        }
    }

    
}


/*
1. "import java.io.FileInputStream;"  lets us read the actual bytes of a file.
The first method : calculateSHA256(File file).
Its job will be: receive a file,read its bytes, calculate SHA-256, return hash as String


2. Think of "digest" as our SHA-256 machine. we will give file bytes in a digest and we will get SHA-256 hash
3."bytesRead = input.read(buffer)" = input.read(buffer) → reads bytes from the file and puts those actual bytes into buffer.It returns how many bytes it managed to put into buffer, and that number is stored in bytesRead.
*/
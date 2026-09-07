import java.io.File; //This gives us access to Java's File class.(I want to use Java's already-built File class in this program.)
import java.io.FileNotFoundException; //This is for handling the situation where Java cannot find logs.txt.
import java.util.HashMap;
import java.util.Scanner;

/*public class LogAnalyzer {
    public static void main(String[] args) {
        try { //Opening a file can fail.
            File file = new File("logs.txt");// (I want to work with a file called logs.txt.)
            Scanner input = new Scanner (file); //Java isn't waiting for you to type something. It's reading the next line from logs.txt.

            while(input.hasNextLine()){ // asks:- is there another line available in this file ?
                String line = input.nextLine(); //Read one entire line from the file and store it in a String called line.
                System.out.println(line);
            }
        } catch (FileNotFoundException e) { //If that specific problem happens, handle it here instead of crashing the program.
            System.out.println("Log file not found.");
        }
    }
}*/



public class LogAnalyzer{
    public static void main(String[] args) {

        int successfulLogins =0;
        int failedLogins=0;
        HashMap<String, Integer> failedAttemptsByIp = new HashMap<>();

        try{
            File file = new File("logs.txt");
            Scanner input = new Scanner(file);

            while(input.hasNextLine()){
                String line = input.nextLine();
                String[] parts = line.split(" ");

                String date = parts[0];
                String time  = parts[1];
                String event = parts[2];
                String username = parts[3];
                String ipAddress = parts[4];


                LogEntry entry = new LogEntry(date, time, event, username, ipAddress);

                /*System.out.println(line);
                System.out.println(event);
                System.out.println();
                System.out.println(entry.getEvent());*/
                

                if (entry.getEvent().equals("LOGIN_SUCCESS")){
                    successfulLogins++;
                    
                }
                if (entry.getEvent().equals("LOGIN_FAILED")){
                    failedLogins++;
                    String ip = entry.getIpAddress(); //in hashmap get() is used to access a value

                    if(failedAttemptsByIp.containsKey(ip)){
                        int currentCount = failedAttemptsByIp.get(ip);
                        failedAttemptsByIp.put(ip, currentCount + 1);
                    }
                    else{
                        failedAttemptsByIp.put(ip, 1); //in hashmap put() is used to add items.
                    }
                }
                
                
            }
            
            System.out.println("Successful logins: "+ successfulLogins);
            System.out.println("Failed logins: "+ failedLogins);
            System.out.println();
            System.out.println("Failed attempts by IP:");

            String[] ips =  failedAttemptsByIp.keySet().toArray(new String[0]); //Give me all the IP addresses stored as keys in the HashMap.

            for (int i =0; i<ips.length; i++){
                String ip = ips[i];
                int count = failedAttemptsByIp.get(ip);
                System.out.println(ip + "-> "+ count);

                if (count >=3){
                    System.out.println("Warning:");
                    System.out.println(ip + " has suspicious login activity.");
                }
            }
        }
        catch(FileNotFoundException e){ //java needs a variable to hold that specific exception object and its information. e.g: if a FileNotFoundException happens, catch it and store its error information in e.
                System.out.println("Log file not found.");
        }
    }
}


/*STAGE 1
Read file
-----------------------
logs.txt
   ↓
Open file
   ↓
Read one line
   ↓
Print that line
   ↓
Read next line
   ↓
Print that line

        ↓
STAGE 2
Break each line into pieces
        ↓
STAGE 3
Store each line as LogEntry
        ↓
STAGE 4
Count success / failed logins
        ↓
STAGE 5
Count failed attempts per IP
        ↓
STAGE 6
Detect suspicious IP addresses */
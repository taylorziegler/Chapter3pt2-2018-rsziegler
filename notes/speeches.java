

/**
 * Write a description of class speeches here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.io.*;

public class speeches
{
    public static void main(String [] args) throws IOException {
       // I changed the names
       calc("data\\gwashington.txt");
       calc("data\\tjefferson.txt");
       calc("data\\mfillmore.txt");
       calc("data\\troosevelt.txt");
       calc("data\\gwbush.txt");
       calc("data\\bobama.txt");
    }
    
    public static void calc(String path) throws IOException {
        Scanner scanfile = new Scanner(new File(path));
        String file = "";
        
        System.out.println("Date: " + scanfile.nextLine());
        System.out.println("Name: " + scanfile.nextLine());
        
        while (scanfile.hasNext()) {
            file += scanfile.nextLine() + " ";
        }
        String line;
        int people = 0, government = 0, united = 0, our = 0, lengthCount = 0, avgLen = 0;
        String[] split = file.split(" ");
        
        for (int i = 0; i < split.length; i++) {
            if ((split[i].length() >= 6) && (split[i].toLowerCase().substring(0, 6).equals("people"))) {
                people++;
            }
            else if ((split[i].length() >= 10) && (split[i].toLowerCase().substring(0, 10).equals("government"))) {
                government++;
            }
            else if ((split[i].length() >= 6) && (split[i].toLowerCase().substring(0, 6).equals("united"))) {
                united++;
            }
            else if ((split[i].length() >= 3) && (split[i].toLowerCase().substring(0, 3).equals("our"))) {
                our++;
            }
            lengthCount += split[i].length();
        }
        
        
        avgLen = lengthCount/(split.length);
        System.out.println("Average word length (characters/word): " + avgLen);
        System.out.println("Speech length (characters): " + split.length);
        System.out.println("People: " + people);
        System.out.println("Government: " + government);
        System.out.println("United: " + united);
        System.out.println("Our: " + our + "\n");
    }
}

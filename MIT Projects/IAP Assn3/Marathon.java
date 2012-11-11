/**
 *
 * @author HicksJ
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;  
import java.util.Scanner;
import java.io.IOException;  
import java.lang.String;
import java.io.FileNotFoundException;
import java.lang.Object;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.LineNumberReader;


public class Marathon {

    /**
     * @param args the command line arguments
     */   

public static void main(String arg[]) {
    
    String[] names ={
        "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
        "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
        "Aaron", "Kate"
    };
    
    int[] origTimes ={
        341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
        343, 317, 265
    };
    
    int[] times ={
        341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
        343, 317, 265
    };   
        
         getNames();
    
         for (int i = 0; i < names.length; i++) {
           System.out.println("Original: "+i + ": "+ names[i]+ ": " + origTimes[i]);        
         }
           
         int[] times2 = sortTimes(times);
         int[] sortedNames = matchNames(origTimes,times2);
                              
           System.out.println("");           
         for (int i = 0; i < names.length; i++) {      
           System.out.println("Final Results: "+ names[sortedNames[i]]+ ": " + times2[i]);
         }
      
}

   public static int[] matchNames(int[] orig, int[] sorted){
       
 /*      input sorted integer array 
  *      match item i to index in original array
  *      save array of matched indexes and export this array
  *     
 */           
       int[] new1 = new int[sorted.length];
       
       for (int i = 0; i < sorted.length; i++) {
          for (int j = 0; j < sorted.length; j++) {
            if(orig[j] == sorted[i]){
              new1[i] = j;
           }
         }
       }
           
     return new1;
   }
   
   public static int[] sortTimes(int[] times2){
  
       int[] sortedTimes = new int[times2.length];
       
        Arrays.sort(times2);
        System.arraycopy(times2, 0, sortedTimes, 0, times2.length);
       
       return sortedTimes;     
      
   }

   public static String getNames(){
       
        String text = "";
        int count = 0;
        List<String[]> list = new ArrayList<String[]>();
        
        File file = new File("C:\\Users\\hicksj\\Documents\\NetBeansProjects"
                            +"\\Test\\src\\marathon.txt");
        
        try{
            Scanner scanner = new Scanner(file);
                                  
            while ((scanner.hasNextLine())) {
                String line = scanner.nextLine();                          
                list.add(parseNames(line));                         
            }
            scanner.close();
       }
       catch (FileNotFoundException e){
           System.err.format("Exception: " + e.getMessage());
           e.printStackTrace();
       }
       for (String[] stringArr : list) {
        for(String str : stringArr){
            System.out.print(str+" ");
        }
        System.out.println("");
    }
       
       return text;
   }
   
   public static String[] parseNames(String s){
    String[] array = s.split("\\d");
    return array;
}

  }

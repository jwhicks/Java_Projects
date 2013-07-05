/**
 *
 * @author HicksJ
 * 
 * input names and times of a marathon and 
 * output a sorted array ascending by time
 * fastest time first. 
 */

  
import java.lang.String;
import java.util.*;
import java.io.*;


public class Marathon {  

private static final String DATA_FILE_NAME = 
             "/home/hicksj/NetBeansProjects/Java_Progs/Marathon/src/marathon/RaceData.csv";
private static String [] runnerNames = new String[18];
private static int [] runnerTimes = new int[18];
private static int [] origTimes = new int[18];

public static void main(String arg[]) throws IOException {

         loadRaceData();
         
         System.arraycopy(runnerTimes, 0, origTimes, 0, runnerTimes.length); 
          
         for (int i = 0; i < runnerNames.length; i++) {
           System.out.println("Input: "+ runnerNames[i]+ ": " + origTimes[i]);        
         }
           
         int[] times2 = sortTimes(runnerTimes);
         int[] sortedNames = matchNames(origTimes,times2);
                              
           System.out.println("");           
         for (int i = 0; i < runnerNames.length; i++) {      
           System.out.println("Final Results: "+ runnerNames[sortedNames[i]]+ ": " + times2[i]);
        }
      
}//Main

  public static int[] sortTimes(int[] times2){
  
  /* 
   * Sort the input array and copy into returned array
   * 
   */
       
       int[] sortedTimes = new int[times2.length];
       
        sortArray(times2);
        System.arraycopy(times2, 0, sortedTimes, 0, times2.length);
       
       return sortedTimes;     
      
   }//sortTimes

   public static int[] matchNames(int[] orig, int[] sorted){
       
 /*      
  *      input sorted integer array 
  *      match item i to index in original array
  *      save array of matched indexes and export this array
  *     
 */           
       int[] newNames = new int[sorted.length];
       
       for (int i = 0; i < sorted.length; i++) {
          for (int j = 0; j < sorted.length; j++) {
            if(orig[j] == sorted[i]){
              newNames[i] = j;
           }
         }
       }
           
     return newNames;
     
   }//matchNames
   
/*
*    sort an input array descinding by time
*    fastest time first
*/   
   public static int[] sortArray(int[] inArray){

       int i,j,temp;

       for (i=0; i<= inArray.length-1; i++){
           for(j=i+1; j<=inArray.length-1; j++){
               if(inArray[i] > inArray[j]){
                   temp = inArray[i];
                   inArray[i] = inArray[j];
                   inArray[j] = temp;    
               }
           }
       }
     return inArray;
     
   }//sortArray
  
  public static void loadRaceData() throws FileNotFoundException, IOException {
             
       int i =0;
       
       try {
         File file = new File(DATA_FILE_NAME);
         Scanner scanner = new Scanner(file);
         
         while (scanner.hasNext()){
                StringTokenizer st = new StringTokenizer(scanner.nextLine(),",");
                    if (st.countTokens() == 2){
                        runnerNames[i] = st.nextToken();
                        runnerTimes[i] = Integer.parseInt(st.nextToken());
                        i++;
           }
         }
         
         scanner.close();
         
       } catch (FileNotFoundException e) {
                e.printStackTrace();
       }
                  
  } //loadRaceData()
  
}//Class

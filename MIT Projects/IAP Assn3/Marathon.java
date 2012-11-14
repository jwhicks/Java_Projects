/**
 *
 * @author HicksJ
 */

  
import java.lang.String;
import java.util.Arrays;


public class Hello {  

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
                        
         for (int i = 0; i < names.length; i++) {
           System.out.println("Input: "+ names[i]+ ": " + origTimes[i]);        
         }
           
         int[] times2 = sortTimes(times);
         int[] sortedNames = matchNames(origTimes,times2);
                              
           System.out.println("");           
         for (int i = 0; i < names.length; i++) {      
           System.out.println("Final Results: "+ names[sortedNames[i]]+ ": " + times2[i]);
        }
      
}//Main

  public static int[] sortTimes(int[] times2){
  
  /* 
   * Sort the input array and copy into returned array
   * 
   */
       
       int[] sortedTimes = new int[times2.length];
       
        Arrays.sort(times2);
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
         
}//Class

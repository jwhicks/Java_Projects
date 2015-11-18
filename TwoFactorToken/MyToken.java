package mytoken;

/**
 *
 * @author HicksJ
 */

import javax.swing.JOptionPane;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;
import java.util.HashMap;


public class MyToken {

    public static String input = "";
    public static HashMap<String, String> map = new HashMap<String, String>();
									
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

        String myEndToken = "";
        createHashMap(); 
 
        javax.swing.UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Dialog", Font.BOLD, 22)));   
        input = JOptionPane.showInputDialog("Enter your token string: ");
        
        for (int i=0; i<input.length(); i+=5){
           myEndToken = myEndToken.concat(map.get(input.substring(i+1, i+3)));           
         }
        
           JOptionPane.showMessageDialog(null,"e-Grid Token: "+myEndToken,"Two-Factor Authorization:",
                                      JOptionPane.PLAIN_MESSAGE);
        } 
    
    public static void createHashMap(){
         
     /**	
	 eGrid Table has the format:
		A1, B1,.....J1
		A2, B2,.....J2
        A3, B3,.....J3
		A4, B4,.....J4
		A5, B5,.....J5	
	 **/ 
         
//            GRID #  KEY
//     ==================
       map.put("A1", "2");
       map.put("A2", "1");
       map.put("A3", "K");
       map.put("A4", "9");
       map.put("A5", "K");
         
       map.put("B1", "5");
       map.put("B2", "6");
       map.put("B3", "7");
       map.put("B4", "7");
       map.put("B5", "P");
       
       map.put("C1", "5");
       map.put("C2", "J");
       map.put("C3", "P");
       map.put("C4", "8");
       map.put("C5", "C");
       
       map.put("D1", "K");
       map.put("D2", "Q");
       map.put("D3", "0");
       map.put("D4", "9");
       map.put("D5", "T");
       
       map.put("E1", "5");
       map.put("E2", "N");
       map.put("E3", "V");
       map.put("E4", "3");
       map.put("E5", "6");
       
       map.put("F1", "4");
       map.put("F2", "4");
       map.put("F3", "X");
       map.put("F4", "7");
       map.put("F5", "4");
       
       map.put("G1", "3");
       map.put("G2", "V");
       map.put("G3", "V");
       map.put("G4", "X");
       map.put("G5", "8");
       
       map.put("H1", "X");
       map.put("H2", "5");
       map.put("H3", "7");
       map.put("H4", "8");
       map.put("H5", "Y");
       
       map.put("I1", "D");
       map.put("I2", "0");
       map.put("I3", "J");
       map.put("I4", "K");
       map.put("I5", "H");
       
       map.put("J1", "0");
       map.put("J2", "8");
       map.put("J3", "J");
       map.put("J4", "N");
       map.put("J5", "4");
           
    }//createHashMap
}//class

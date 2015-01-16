/*
 * Read in and display weekly rig counts from 
 * Baker Hughes Standard Report
 */
 
package rigcount;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;

/**
 *
 * @author hicksj
 */
public class RigCount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String rigCount="";
        String idString="";
        String totalChange="";
        String weeklyChange="";
        String yearlyChange="";
        Document doc;
                
        javax.swing.UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Dialog", Font.BOLD, 22)));

        try {
          doc = 
          Jsoup.connect("http://gis.bakerhughesdirect.com/Reports/StandardReport.aspx").timeout(0).get();
          idString = doc.select("span[id=ctl00_ContentPlaceHolder1_rigCountsChg]").text();
          
        } catch (IOException e) {
            e.printStackTrace();
          }//catch
        
        rigCount = idString.substring(11, 15);
        totalChange = idString.substring(31, 39);
        weeklyChange = idString.substring(43, 49);
        yearlyChange = idString.substring(71, 102);
        
        JOptionPane.showMessageDialog(null,"Rig Count Is: "+rigCount+"\nMovement is: "+totalChange+
                                      "\nWeekly Change: "+weeklyChange+"\nYearly Change: "+yearlyChange,
                                      "Baker Hughes Rig Count",JOptionPane.PLAIN_MESSAGE);
        
        
    }//main
    
}//class

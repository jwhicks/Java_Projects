
package rigcount;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;
import org.jsoup.select.Elements;

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
        String totalChange="";
        String weeklyChange="";
        String yearlyChange="";
    
        Elements idString = null;
        
        Document doc;
                
        javax.swing.UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Dialog", Font.BOLD, 22)));

        try {
          doc = 
          Jsoup.connect("http://gis.bakerhughesdirect.com/Reports/StandardReport.aspx").timeout(0).get();
          idString = doc.select("span[id=ctl00_ContentPlaceHolder1_rigCountsChg]");
          
        } catch (IOException e) {
            e.printStackTrace();
        }//catch

       
        rigCount = idString.text().substring(11, 14);      
        totalChange = idString.text().substring(29, 36);
        weeklyChange = idString.text().substring(38, 43);
        yearlyChange = idString.text().substring(66, 77);   

        JOptionPane.showMessageDialog(null, idString.text(), "Rig Count", JOptionPane.PLAIN_MESSAGE);
    
    }//main
    
}//class

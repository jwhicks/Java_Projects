
package StockInfo;

import java.lang.Runtime;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;
import java.util.*;
import org.jsoup.select.Elements;

/**
 *
 * @author hicksj
 */
public class StockInfo {

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String fileName = "C:\\Users\\hicksj\\Desktop\\stocks.csv";
        Elements marketData = null;
        Elements stockPrice = null;
        String [] ticker = {"aapl","goog","txn","mmm","amzn","aep","brcm","ebay","de","dtv","dow",
                            "epd","fb","fast","fdx","gs","hal","hrs","hpq","hon","hpq","hd","jnj",
                            "jci","jpm","khc","ibm","intc","intu","ivz","kr","lll","lly","lvlt",
                            "lltc","lmt","low","mro","mar","mat","mdt","msft","ma","mcd","ms","navi",
                            "nflx","noc","nov","oii","omc","oxy","nke","nue","ntrs","orcl","pep","qcom",
                            "rtn","sbux","slb","t","unh","ups","usb","v","wfc","wmt","xom"
                            };
        PrintWriter out = null;
        
        try{
          out = new PrintWriter(fileName);     
          
		  // for | delimiter: out.append("|"); Need to use this instead of a comma because of the 
		  // notation in the information. If use a comma, it won't get parsed correctly. 
		  // before running this script, need to set excel delimiter to | instead of ,. This is done in:
		  // Start -> Control Panel -> Region & Language -> Additional Settings -> List Separator. 
		  
          out.append("Ticker");
          out.append("|");
          out.append("Stock Price");
          out.append("|");
          out.append("Market Cap");
          out.append("|");
          out.append("P/E Ratio");
          out.append("|");
          out.append("Rev. Per Employee");
          out.append("|");
          out.append("EPS");
          out.append("|");
          out.append("Dividend");
          out.append("|");
          out.append("Dividend Yield");
          out.append("|");
          out.append("Dividend Date");
          out.append("\n");
         
        }catch(IOException e)
	  {
	     e.printStackTrace();
	  }


        Document doc;
                
        javax.swing.UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Dialog", Font.BOLD, 22)));
      
        for(int i=0; i<ticker.length; i++){
        
        try {
          doc = 
          Jsoup.connect("http://www.marketwatch.com/investing/stock/"+ticker[i]).timeout(0).get();
            marketData = doc.select("p[class=data lastcolumn");
            stockPrice = doc.select("p[class=data bgLast");
          
  
        } catch (IOException e) {
            e.printStackTrace();
        }//catch  

         out.append(ticker[i].toUpperCase());
         out.append("|");
         out.append(stockPrice.get(0).ownText());
         out.append("|");
         out.append(marketData.get(2).ownText());
         out.append("|");
         out.append(marketData.get(4).ownText());
         out.append("|");
         out.append(marketData.get(5).ownText());
         out.append("|");
         out.append(marketData.get(6).ownText());
         out.append("|");
         out.append(marketData.get(7).ownText());
         out.append("|");
         out.append(marketData.get(8).ownText());
         out.append("|");
         out.append(marketData.get(9).ownText());
         out.append("\n");

       }//for   
        
        out.flush();
        out.close();
        
      try
    {
        Runtime.getRuntime().exec("excel "+fileName);
    }
    catch (IOException e) 
    {
      e.printStackTrace();
    }
        
    }//main
}//class

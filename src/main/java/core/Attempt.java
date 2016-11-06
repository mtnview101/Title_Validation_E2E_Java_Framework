package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Attempt {
	
//**************************************************************************	
    public String[][] a2d() throws IOException {
//**************************************************************************
        String csvFile = "./src/main/resources/Title_Validation.csv";
        BufferedReader br = null;
        String line = null;
        String[] column = null;
        int lines = 0;
        int columns = 0;
        String SplitBy = ",";
        String text_case_id = null;
        String url = null;
        String title_expected = null;

        // BEGINING TO COUNT LINES AND COLUMNS **********************************************************************
        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {					//String	readLine()    	Reads a line of text.
        	
               lines++; 											// lineS is int type
               System.out.println("lines="+lines);
               column = line.split(SplitBy);						// column is String type
               columns = column.length;								// columns is int type
               System.out.println("columns="+columns);
        }
        br.close();
        // END OF COUNTING LINES AND COLUMNS *************************************************************************
        
        String s2d[][] = new String[lines][columns]; // 2d array initializing, lines and columns from COUNTING above
        
        br = new BufferedReader(new FileReader(csvFile));
        WebDriver driver = new HtmlUnitDriver();   // Version 1.2 :: HtmlUnit
        int i = 0;
        while ((line = br.readLine()) != null) {

               String[] csv = line.split(SplitBy);

               text_case_id = csv[0];
               url = csv[1];
               title_expected = csv[2];

               driver.get(url);
               driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
               String title_actual = driver.getTitle();

  //write result (title actual) of Title Validation in s2d array             
               
               s2d[i][0] = text_case_id;
               System.out.println("s2d["+i+"][0]="+s2d[i][0]);
               s2d[i][1] = title_expected;
               System.out.println("s2d["+i+"][1]="+s2d[i][1]);
               s2d[i][2] = title_actual;
               System.out.println("s2d["+i+"][2]="+s2d[i][2]);
               System.out.println();

               i++;
        }

        driver.quit();
        br.close();
        return s2d;
 }
//**************************************************************************
    
 public static void main(String[] args) throws IOException {
      core.Attempt attempt = new core.Attempt();
      //attempt.a2d();
      System.out.println(Arrays.asList(attempt.a2d()));
 }
}

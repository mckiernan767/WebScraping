/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebScraping;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Eoin
 */
public class Main {
    
    public static void main(String[] args) throws IOException, Exception  {
    
    String url = "https://www-01.ibm.com/common/ssi/ShowDoc.wss?docURL=/common/ssi/rep_ca/5/897/ENUS915-085/index.html&lang=en&request_locale=en";

        Document doc = Jsoup.connect(url).get();
                //System.out.println("doc " + doc);
                        
        //ArrayList<String> downServers = new ArrayList<>();
        Elements elements = doc.getElementsByClass("gpt-data-table");
        Element table = elements.get(4);
       
        //System.out.println("table " + table);
        
        Elements rows = table.select("tr");
        //ArrayList Program = new ArrayList();
        
        String lastSubProgramId = "";
        //System.out.println("rows " + rows);
RestClient post = new RestClient();
            for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
                Element row = rows.get(i);
                Elements cols = row.select("td");

                boolean isBold = !cols.select("b").isEmpty();
                
                if (isBold){
                    String programId = cols.get(0).text();
                    String programName = cols.get(1).text();
                    
                Program program = new Program(programId);
                
                
               
                
                String id = post.postProgram(program);
                
                SubProgram subProgram = new SubProgram(programId, programName, id);
                
                lastSubProgramId = post.postSubProgram(subProgram);
                
                   // System.out.println("a + B " + programId +" "+programName);
                }else{
                    String partID = cols.get(0).text();
                    String partName = cols.get(1).text();
                    String date = cols.get(2).text();
               
                    Part part = new Part(partID, partName, date, lastSubProgramId);
                    post.postPart(part);
                    
                }
 
}
        
System.out.println("Finished");
            
}
    
}

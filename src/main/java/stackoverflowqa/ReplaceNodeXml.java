/*
https://stackoverflow.com/questions/67361493/trying-to-use-replace-to-replace-xml-dependencies-extracted-by-using-xpath-ja/

05/04/2021

*/
package stackoverflowqa;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class ReplaceNodeXml {
    
    
    public static void main(String[] args) throws IOException {
        
        String pom = readFile(ReplaceNodeXml.class.getResourceAsStream("pom-plain.xml"));
        String web = readFile(ReplaceNodeXml.class.getResourceAsStream("pom-web.xml"));            
        
        Document doc_web = Jsoup.parse(web,"",Parser.xmlParser());
        Document doc_pom = Jsoup.parse(pom,"",Parser.xmlParser());
        
        // css selectors for nested dependencies

        Elements dependencies_web = doc_web.select("project>dependencies");
        Elements dependencies_pom = doc_pom.select("project>dependencies");

        // remove the old dependencies
        dependencies_pom.clear();

        //add the new dependencies
        dependencies_pom.addAll(dependencies_web);

        // retain formating of the xml file
        doc_pom.outputSettings().prettyPrint(false);

        Files.writeString(Paths.get("pom-plain_out.xml"),doc_pom.toString(),StandardOpenOption.CREATE);
    }
    
    public static String readFile(InputStream in) throws IOException{
       
        return new String(in.readAllBytes(), StandardCharsets.UTF_8);
    }

}
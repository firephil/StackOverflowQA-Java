package stackoverflowqa;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

// usefull article https://stackabuse.com/executing-shell-commands-with-java/

public class SqliteDump{
	
    public static void main(String[] args) throws IOException{

    	String command = "sqlite3.exe  test.db .dump .output 1.sql";
    	System.out.println(command);
    	Process process = Runtime.getRuntime().exec(command);
        
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(),StandardCharsets.UTF_8));
        
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("1.sql"), StandardCharsets.UTF_8);
        
    	String line = "";
    	while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
   
    }
}
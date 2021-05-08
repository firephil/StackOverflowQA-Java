package stackoverflowqa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ReadFiles {
        
            public static void main(String[] args) throws IOException{
                
                List<String> highscores = Files.readAllLines(Paths.get("C://highscores.txt"));
                highscores.forEach(System.out::println);
                System.out.println("\n");
                // Relative Path depending your build tool this will be different for ant,maven,gradle etc
                
                InputStream in = ReadFiles.class.getResourceAsStream("highscores.txt");
                Stream<String> highscores_stream = new BufferedReader(new InputStreamReader(in)).lines();
                highscores_stream.forEach(System.out::println);
            }
}
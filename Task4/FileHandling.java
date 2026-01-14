package Task4;
import java.io.*;
import java.util.*;
public class FileHandling {
    public static void main(String[] args) throws IOException {
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter("/Users/yash/Desktop/codes/test/file.txt"));
            bw.write("Hello");
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            BufferedReader br=new BufferedReader(new FileReader("/Users/yash/Desktop/codes/test/file.txt"));
            System.out.println(br.readLine());
            br.close();
        }
        catch(Exception e){
            System.out.println(e);
        }


    }

}

import com.sun.source.tree.SynchronizedTree;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main {
    public  static ArrayList<String> List = new ArrayList<>();
    public static FileWriter myFile;
    public static void main(String[] args) {
        try {
            //myFile = new FileWriter("D:\\file.txt");
            AddData(new String[]{"ahmed","ali"});
            AddToFile(List);
        } catch(Exception e) {}
    }
    public static void AddData(String [] data) throws Exception
    {
        File MyFile = new File("D:\\file.txt");
        Scanner write = new Scanner(MyFile);
        while (write.hasNextLine()){
            List.add(write.nextLine());
        }
        for(int i = 0 ; i<data.length; i++) {
            List.add(data[i]);
        }
        for (int i = 0 ; i< List.size() ; i++) {
            System.out.println(List.get(i));
        }
    }
    public static void AddToFile(ArrayList<String> list) throws Exception {
        for(int i = 0 ; i<list.size();i++) {
            myFile.write(list.get(i));
        }
    }
}

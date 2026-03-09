import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main{
    public static void main(String[]args) throws IOException {
        HashMap<String, ArrayList<String>> D;
        D = new HashMap<>();

        BufferedReader f= new BufferedReader(new FileReader("ulysses.txt"));
        String line;

        while((line=f.readLine())!=null){
            String[]words=line.split("\\s+");
            for(String w:words){
                w=w.replaceAll("(^a-zA-Z)","");
                w=w.toLowerCase();
                if(w.length()==0){
                    continue;
                }
                char[]chars=w.toCharArray();
                Arrays.sort(chars);
                String key=new String(chars);
                if(!D.containsKey(key)){
                    ArrayList<String>list=new ArrayList<>();
                    list.add(w);
                    D.put(key,list);


                }else{
                    D.get(key).add(w);

                }


            }


        }
        f.close();
        for(String key:D.keySet()){
            if(D.get(key).size()>=2){
                System.out.println(key +":" + D.get(key));
            }
        }






    }

}

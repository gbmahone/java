package org.gbmahone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {

     String path = "c:\\workspace\\in.txt";
     FileReader fr = null;
     BufferedReader br = null;

     try {
         fr = new FileReader(path);
         br = new BufferedReader(fr);

         String line = br.readLine();
        // esse readline vai ler uma linha do arquivo e se estiver no final do arquivo
         // vai me retornar nullo

         while (line != null) {
             System.out.println(line);
             line = br.readLine();
         }
     }
     catch (IOException e) {
         System.out.println("Error: " + e.getMessage());
     }
     finally {

         try {
            if (br != null) {
                br.close();
            }
            if (fr != null) {
                fr.close();
            }
         }
         catch (IOException e) {
            e.printStackTrace();
         }
     }

    }
}
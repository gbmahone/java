package org.gbmahone;

import java.io.*;


public class Main {
    public static void main(String[] args) {
        String[] lines = new String[]{"Good morning", "Good afternoon", "Good night"};

        String path = "c:\\workspace\\out.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            for (String line : lines) {
                bw.write(line);
                bw.newLine(); //bw.newLine é pra dar a quebra de linha
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
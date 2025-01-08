package org.gbmahone;

import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        // vetor das pastas com uma referencia que especifica somente quem é pasta(File::isDirectory)
        File[] folders = path.listFiles(File::isDirectory);
        System.out.println("FOLDERS:");
        for (File folder : folders) {
            System.out.println(folder);
        }
        // vetor com a lista somente de arquivos(File::isFile)
        File[] files = path.listFiles(File::isFile);
        System.out.println("FILES:");
        for (File file : files){
            System.out.println(file);
        }

        // criar uma sub pasta chamada subdir a partir da pasta informada no strPath
        //o uso do boolean é pra confirmar se a ação foi feita
        //mkdir() é pra criar a pasta
        boolean success = new File(strPath + "\\subdir").mkdir();
        System.out.println("Directory created successfully: " + success);
    }

}
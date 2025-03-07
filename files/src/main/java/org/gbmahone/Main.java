package org.gbmahone;

import org.gbmahone.entities.Product;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.println("Enter file path: ");
        String sourceFileStr = sc.nextLine();

        File sourceFile = new File(sourceFileStr);
        String sourceFolderStr = sourceFile.getParent();

        System.out.println(sourceFolderStr);

        // mkdir é pra criar uma nova pasta(diretorio)
        boolean success = new File(sourceFolderStr + "/out").mkdir();

        String targetFileStr = sourceFolderStr + "/out/summary.csv ";

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

            String itemCsv = br.readLine();
            while (itemCsv != null){
                String[] fields = itemCsv.split(", "); // separar o conteudo pela virgula e transformar em variaveis
                String name = fields[0];
                double price = Double.parseDouble(fields[1]); // convertendo o fields que é uma String em double, usando o parse
                int quantity = Integer.parseInt(fields[2]); // convertendo o fields que é String em Ingeter, usando o parse

                list.add(new Product(name, price, quantity));

                itemCsv = br.readLine();
            }
            // bufferedWriter é pra gravar o conteudo e pra usar ele tem que instaciar o FileWriter dentro dele
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

                for (Product item : list){
                    bw.write(item.getName() + ", " + String.format("%.2f",item.total()));
                    bw.newLine();
                }

                System.out.println(targetFileStr + "CREATED");

            }catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

    }

}
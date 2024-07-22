package com.example.mt940_to_excel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExcelWriterTest {

    public static void main(String[] args) {

        String txtFilePath = "C:\\Users\\enesa\\OneDrive\\Masaüstü\\214002138_240717.txt";

        String mt940Content;
        try {
            mt940Content = new String(Files.readAllBytes(Paths.get(txtFilePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


        MT940Parser parser = new MT940Parser();
        List<MT940Transaction> transactions = parser.parse(mt940Content);


        ExcelWriter excelWriter = new ExcelWriter();
        try {
            excelWriter.writeToExcel(transactions, "test.xlsx");
            System.out.println("Excel dosyası başarıyla oluşturuldu");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

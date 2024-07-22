package com.example.mt940_to_excel;

import java.util.ArrayList;
import java.util.List;

public class ExcelWriterTest {

    public static void main(String[] args) {

        List<MT940Transaction> transactions = new ArrayList<>();
        transactions.add(new MT940Transaction("0059", "00372", "666009999", "255201,57", "DBS Aktarım - DBS Aktarım"));
        transactions.add(new MT940Transaction("0059", "00372", "666009999", "255201,57", "DBS Aktarım - DBS Aktarım"));

       ExcelWriter excelWriter = new ExcelWriter();

       try {
           excelWriter.writeToExcel(transactions,"test.xlsx");
           System.out.println("Excel dosyası başarıyla oluşturuldu");
       } catch (Exception e) {

           e.printStackTrace();
       }



    }

}

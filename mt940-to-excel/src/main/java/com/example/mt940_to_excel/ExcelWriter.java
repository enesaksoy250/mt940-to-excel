package com.example.mt940_to_excel;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

    public void writeToExcel(List<MT940Transaction> transactions,String filePath) throws IOException {

          Workbook workbook = new XSSFWorkbook();
          Sheet sheet = workbook.createSheet("Transactions");

          Row header = sheet.createRow(0);
          header.createCell(0).setCellValue("Banka Kodu");
          header.createCell(1).setCellValue("Şube Kodu");
          header.createCell(2).setCellValue("Hesap Kodu");
          header.createCell(3).setCellValue("İşlem Tutarı");
          header.createCell(4).setCellValue("İşlem Açıklaması");

          int rowNum = 1;

          for (MT940Transaction transaction : transactions) {

              Row row = sheet.createRow(rowNum++);
              row.createCell(0).setCellValue(transaction.getBankaKodu());
              row.createCell(1).setCellValue(transaction.getSubeKodu());
              row.createCell(2).setCellValue(transaction.getHesapKodu());
              row.createCell(3).setCellValue(transaction.getIslemTutari());
              row.createCell(4).setCellValue(transaction.getIslemAciklamasi());

          }

       try(FileOutputStream fileOut = new FileOutputStream(filePath)) {

           workbook.write(fileOut);

       }

       workbook.close();
    }


}

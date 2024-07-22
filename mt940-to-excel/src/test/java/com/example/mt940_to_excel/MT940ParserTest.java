package com.example.mt940_to_excel;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MT940ParserTest {

    public static void main(String[] args) {

        String filePath ="C:\\Users\\enesa\\OneDrive\\Masaüstü\\214002138_240717.txt";

        try {

            String mt940Content = new String(Files.readAllBytes(Paths.get(filePath)));

            MT940Parser parser = new MT940Parser();
            List<MT940Transaction> transactions = parser.parse(mt940Content);


            for (MT940Transaction transaction : transactions) {
                System.out.println("Banka Kodu: " + transaction.getBankaKodu());
                System.out.println("Şube Kodu: " + transaction.getSubeKodu());
                System.out.println("Hesap Kodu: " + transaction.getHesapKodu());
                System.out.println("İşlem Tutarı: " + transaction.getIslemTutari());
                System.out.println("İşlem Açıklaması: " + transaction.getIslemAciklamasi());
                System.out.println("-------------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

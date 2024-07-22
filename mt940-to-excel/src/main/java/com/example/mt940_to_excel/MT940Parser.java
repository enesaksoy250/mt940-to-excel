package com.example.mt940_to_excel;

import jakarta.transaction.Transaction;
import java.util.List;
import java.util.ArrayList;


public class MT940Parser {

    public List<MT940Transaction> parse(String mt940Content) {
        List<MT940Transaction> transactions = new ArrayList<>();
        String[] lines = mt940Content.split("\n");

        MT940Transaction transaction = null;
        for (String line : lines) {
            if (line.startsWith(":20:")) {
                if (transaction != null) {
                    transactions.add(transaction);
                }
                transaction = new MT940Transaction();
                // Banka kodu, şube kodu ve hesap kodu buraya eklenecek
            } else if (line.startsWith(":25:")) {
                if (transaction != null) {
                    transaction.setBankaKodu(line.substring(4, 8)); // Örnek: "0059"
                    transaction.setSubeKodu(line.substring(9, 14)); // Örnek: "00372"
                    transaction.setHesapKodu(line.substring(15));   // Örnek: "666009999"
                }
            } else if (line.startsWith(":61:")) {
                if (transaction != null) {
                    String amount = line.substring(17, line.indexOf('N')).trim(); // Örnek: "000000108256,39"
                    transaction.setIslemTutari(removeLeadingZeros(amount));
                }
            } else if (line.startsWith(":86:")) {
                if (transaction != null) {
                    transaction.setIslemAciklamasi(line.substring(4).trim()); // Örnek: "- DBS Aktarım - DBS Aktarım"
                }
            }
        }

        if (transaction != null) {
            transactions.add(transaction);
        }

        return transactions;
    }

    private String removeLeadingZeros(String amount) {

        if (amount != null && !amount.isEmpty()) {
            // Virgülden önceki kısmı işleme al
            String[] parts = amount.split(",");
            String integerPart = parts[0];
            String decimalPart = parts.length > 1 ? parts[1] : "";

            // Başındaki sıfırları kaldır
            integerPart = integerPart.replaceFirst("^0+(?!$)", "");

            // Virgülle birleştir
            return integerPart + (decimalPart.isEmpty() ? "" : "," + decimalPart);
        }
        return amount;
    }


}



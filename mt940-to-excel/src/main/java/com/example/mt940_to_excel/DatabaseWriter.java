package com.example.mt940_to_excel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class DatabaseWriter {

    private static final String URL = "jdbc:sqlite:mt940.db";

    public void saveTransactions(List<MT940Transaction> transactions) {
        String insertSQL = "INSERT INTO transactions (bankaKodu, subeKodu, hesapKodu, islemTutari, islemAciklamasi) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            for (MT940Transaction transaction : transactions) {
                pstmt.setString(1, transaction.getBankaKodu());
                pstmt.setString(2, transaction.getSubeKodu());
                pstmt.setString(3, transaction.getHesapKodu());
                pstmt.setString(4, transaction.getIslemTutari());
                pstmt.setString(5, transaction.getIslemAciklamasi());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

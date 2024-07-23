package com.example.mt940_to_excel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseReader {

    private static final String URL = "jdbc:sqlite:mt940.db";

    public void printAllTransactions() {
        String selectSQL = "SELECT * FROM transactions";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Banka Kodu: " + rs.getString("bankaKodu"));
                System.out.println("Şube Kodu: " + rs.getString("subeKodu"));
                System.out.println("Hesap Kodu: " + rs.getString("hesapKodu"));
                System.out.println("İşlem Tutarı: " + rs.getString("islemTutari"));
                System.out.println("İşlem Açıklaması: " + rs.getString("islemAciklamasi"));
                System.out.println("-------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

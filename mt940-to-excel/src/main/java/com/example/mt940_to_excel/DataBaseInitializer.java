package com.example.mt940_to_excel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DataBaseInitializer {

    private static final String URL = "jdbc:sqlite:mt940.db"; // Veritabanı dosyasının yolu

    public static void initializeDatabase() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS transactions (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "bankaKodu TEXT, " +
                "subeKodu TEXT, " +
                "hesapKodu TEXT, " +
                "islemTutari TEXT, " +
                "islemAciklamasi TEXT" +
                ");";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

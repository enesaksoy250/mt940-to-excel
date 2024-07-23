package com.example.mt940_to_excel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCleaner {

    private static final String URL = "jdbc:sqlite:mt940.db";

    public static void deleteAllRecords() {
        String deleteSQL = "DELETE FROM transactions";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            stmt.execute(deleteSQL);
            System.out.println("Tablodaki tüm veriler başarıyla silindi.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropTable() {
        String dropSQL = "DROP TABLE IF EXISTS transactions";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            stmt.execute(dropSQL);
            System.out.println("Tablo başarıyla silindi.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //deleteAllRecords();
        dropTable();
    }


}

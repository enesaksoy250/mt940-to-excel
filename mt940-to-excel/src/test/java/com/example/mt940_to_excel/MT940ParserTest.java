package com.example.mt940_to_excel;
import java.util.List;

public class MT940ParserTest {

    public static void main(String[] args) {
        // Test verisi
        String mt940Content = ":20:TRY214002138-99999830-240717\n" +
                ":25:0059-00372/666009999\n" +
                ":28C:199/0001\n" +
                ":60F:C240717TRY000000013273,56\n" +
                ":61:2407170717CY000000108256,39NDDBTR450005902140130214002137//\n" +
                ":86: - DBS Aktarım - DBS Aktarım\n" +
                ":61:2407170717CY000000255201,57NDDBTR450005902140130214002137//\n" +
                ":86: - DBS Aktarım - DBS Aktarım\n" +
                ":62F:C240717TRY000000376731,52";

        MT940Parser parser = new MT940Parser();
        List<MT940Transaction> transactions = parser.parse(mt940Content);

        // Sonuçları yazdırma
        for (MT940Transaction transaction : transactions) {
            System.out.println("Banka Kodu: " + transaction.getBankaKodu());
            System.out.println("Şube Kodu: " + transaction.getSubeKodu());
            System.out.println("Hesap Kodu: " + transaction.getHesapKodu());
            System.out.println("İşlem Tutarı: " + transaction.getIslemTutari());
            System.out.println("İşlem Açıklaması: " + transaction.getIslemAciklamasi());
            System.out.println("-------------------------");
        }
    }
}

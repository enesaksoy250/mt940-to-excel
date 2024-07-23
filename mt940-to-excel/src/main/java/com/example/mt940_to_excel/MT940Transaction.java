package com.example.mt940_to_excel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class MT940Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankaKodu;
    private String subeKodu;
    private String hesapKodu;
    private String islemTutari;
    private String islemAciklamasi;


    public MT940Transaction(String bankaKodu, String subeKodu, String hesapKodu, String islemTutari, String islemAciklamasi) {
        this.bankaKodu = bankaKodu;
        this.subeKodu = subeKodu;
        this.hesapKodu = hesapKodu;
        this.islemTutari = islemTutari;
        this.islemAciklamasi = islemAciklamasi;
    }


}

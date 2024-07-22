package com.example.mt940_to_excel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class MT940Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankaKodu;
    private String subeKodu;
    private String hesapKodu;
    private String islemTutari;
    private String islemAciklamasi;

    public MT940Transaction() {
    }

    public MT940Transaction(String bankaKodu, String subeKodu, String hesapKodu, String islemTutari, String islemAciklamasi) {
        this.bankaKodu = bankaKodu;
        this.subeKodu = subeKodu;
        this.hesapKodu = hesapKodu;
        this.islemTutari = islemTutari;
        this.islemAciklamasi = islemAciklamasi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankaKodu() {
        return bankaKodu;
    }

    public void setBankaKodu(String bankaKodu) {
        this.bankaKodu = bankaKodu;
    }

    public String getSubeKodu() {
        return subeKodu;
    }

    public void setSubeKodu(String subeKodu) {
        this.subeKodu = subeKodu;
    }

    public String getHesapKodu() {
        return hesapKodu;
    }

    public void setHesapKodu(String hesapKodu) {
        this.hesapKodu = hesapKodu;
    }

    public String getIslemTutari() {
        return islemTutari;
    }

    public void setIslemTutari(String islemTutari) {
        this.islemTutari = islemTutari;
    }

    public String getIslemAciklamasi() {
        return islemAciklamasi;
    }

    public void setIslemAciklamasi(String islemAciklamasi) {
        this.islemAciklamasi = islemAciklamasi;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", bankaKodu='" + bankaKodu + '\'' +
                ", subeKodu='" + subeKodu + '\'' +
                ", hesapKodu='" + hesapKodu + '\'' +
                ", islemTutari='" + islemTutari + '\'' +
                ", islemAciklamasi='" + islemAciklamasi + '\'' +
                '}';
    }

}

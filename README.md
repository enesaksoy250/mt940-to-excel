Bu proje, MT940 formatındaki banka işlemlerini okuyarak, verileri bir Excel dosyasına dönüştüren bir Java uygulamasıdır. Ayrıca, veritabanına veri yazma ve veritabanındaki verileri silme işlevlerini de içerir.


## Kurulum

1. **Java JDK 17**'yi Java'nın resmi sitesinden indirip kurun.
2. Bu projeyi klonlayın:  ```sh                   
   git clone https://github.com/enesaksoy250/mt940-to-excel.git            
3.Projeyi IDE'nizde açın veya terminal üzerinden çalıştırın.

##Kullanım

1.MT940 verilerini bir dosyadan okumak için:

  Bir tane txt dosyasına MT940 formatında verilerinizi ekleyin.(Dosyanın yolunu belirtmeyi unutmayın)

2.Verileri Excel dosyasına yazmak için:

  Main sınıfını çalıştırın. Bu, MT940 verilerini okuyacak ve test.xlsx adında bir Excel dosyasına yazacaktır.

3.Veritabanı işlemleri:

  DataBaseInitializer sınıfı, veritabanını oluşturur ve gerekli tabloları ayarlar.
  DatabaseWriter sınıfı, verileri veritabanına yazar.
  DatabaseCleaner sınıfı, veritabanındaki tüm verileri veya tabloyu temizler.

##Veritabanı

  Proje, SQLite veritabanını kullanır. Veritabanı dosyası mt940.db olarak adlandırılmıştır. Bu dosya proje kök dizininde bulunur.

Veritabanı ile İlgili İşlemler
  Veritabanını Başlatma: DataBaseInitializer.initializeDatabase() metodunu çağırarak tabloyu oluşturabilirsiniz. 
  Verileri Kaydetme: DatabaseWriter.saveTransactions(List<MT940Transaction> transactions) metodunu kullanarak verileri veritabanına yazabilirsiniz.
  Verileri Silme: DatabaseCleaner sınıfını kullanarak veritabanındaki tüm verileri veya tabloyu temizleyebilirsiniz.

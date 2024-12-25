import java.io.IOException;
    import java.util.*;
    import java.util.List;

    public class Main {
        private static Scanner in = new Scanner(System.in);
        private static List<Klien> daftarUser = new ArrayList<>();
        private static Map<Integer, List<Integer>> userFotograferHistory = new HashMap<>();
        private static Map<Integer, List<Integer>> userCateringHistory = new HashMap<>();
        private static Map<Integer, List<Integer>> userHiburanHistory = new HashMap<>();
        private static Map<Integer, List<Integer>> userDecoratorHistory = new HashMap<>();
        private static Map<Integer, List<Integer>> userPaketLayananHistory = new HashMap<>();
        private static List<Pernikahan> daftarPemesananPernikahan = new ArrayList<>();
        private static List<Seminar> daftarPemesananSeminar = new ArrayList<>();
        private static List<Ultah> daftarPemesananUltah = new ArrayList<>();
        private static List<Konser> daftarPemesananKonser = new ArrayList<>();
        private static List<Fotografer> daftarPemesananFotografer = new ArrayList<>();
        private static List<Catering> daftarPemesananCatering = new ArrayList<>();
        private static List<Hiburan> daftarPemesananHiburan = new ArrayList<>();
        private static List<Decorator> daftarPemesananDecorator = new ArrayList<>();
        private static List<PaketLayanan> daftarPaketLayanan = new ArrayList<>();
        private static int varIdEvent = 1;
        private static int varIdVendor = 1;
        static int varIdUser = 1;
        private static int varIdPaket = 1;
        private static int pilEvent;
        private static int pilTambahan;
        private static int pilTambahan2;
        private static int pilPaketlayanan;

            public void bookWedding(String namaPasangan, float jumlahTamu, String lokasi, String tanggal) {
                float hargaLayanan = 200000;
                double totalHarga = hargaLayanan * jumlahTamu;

                Pernikahan pernikahan = new Pernikahan(varIdUser ++, varIdEvent++, jumlahTamu, lokasi, hargaLayanan, totalHarga, tanggal, namaPasangan);
                daftarPemesananPernikahan.add(pernikahan);
            }

            public void bookSeminar(String topic, String pembicara, float jumlahTamu, String lokasi, String tanggal) {
                float hargaLayananSeminar = 30000;
                double totalHargaSeminar = jumlahTamu * hargaLayananSeminar;

                Seminar seminar = new Seminar(varIdUser ++, varIdEvent++, jumlahTamu, lokasi, hargaLayananSeminar, totalHargaSeminar, tanggal, topic, pembicara);
                daftarPemesananSeminar.add(seminar);
            }

            public void bookBirthday(String namaUltah, int usia, float jumlahTamu, String lokasi, String tanggal) {
                float hargaLayananUltah = 200000;
                double totalHargaUltah = jumlahTamu * hargaLayananUltah;

                Ultah ultah = new Ultah(varIdUser ++, varIdEvent++, jumlahTamu, lokasi, hargaLayananUltah, totalHargaUltah, tanggal, namaUltah, usia);
                daftarPemesananUltah.add(ultah);
            }

            public void bookConcert(String namaArtis, int jumlahTamu, String lokasi, String tanggal) {
                float hargaLayananKonser = 50000;
                double totalHargaKonser = jumlahTamu * hargaLayananKonser;

                Konser konser = new Konser(varIdUser ++, varIdEvent++, jumlahTamu, lokasi, hargaLayananKonser, totalHargaKonser, tanggal, namaArtis);
                daftarPemesananKonser.add(konser);
            }

            public List<PaketLayanan> getDaftarPaketLayanan() {
                return daftarPaketLayanan;
            }

            public List<Fotografer> getDaftarPemesananFotografer() {
                return daftarPemesananFotografer;
            }

            public List<Catering> getDaftarPemesananCatering(){
                return daftarPemesananCatering;
            }

            public List<Decorator> getDaftarPemesananDecorator(){
                return daftarPemesananDecorator;
            }

            public List<Hiburan> getDaftarPemesananHiburan(){
                return daftarPemesananHiburan;
            }

            public Map<Integer, List<Integer>> getUserFotograferHistory() {
                return userFotograferHistory;
            }

            public Map<Integer, List<Integer>> getUserCateringHistory() {
                return userCateringHistory;
            }

            public Map<Integer, List<Integer>> getUserHiburanHistory() {
                return userHiburanHistory;
            }

            public Map<Integer, List<Integer>> getUserDecoratorHistory() {
                return userDecoratorHistory;
            }

            public Map<Integer, List<Integer>> getUserPaketLayananHistory() {
                return userPaketLayananHistory;
            }

        public static void main(String[] args) throws IOException {
            List<String[]> dataFg = FileReader.readFromFile("file/fg.txt");
            for (String[] record : dataFg) {
                int idVendor = Integer.parseInt(record[0]);
                float harga = Float.parseFloat(record[1]);
                String nama = record[2];
                daftarPemesananFotografer.add(new Fotografer(idVendor, harga, nama));
            }

            List<String[]> dataCatering = FileReader.readFromFile("file/catering.txt");
            for (String[] record : dataCatering) {
                int idVendor = Integer.parseInt(record[0]) ;
                float harga = Float.parseFloat(record[1]);
                String nama = record[2];
                String jenisMakanan = record[3];
                daftarPemesananCatering.add(new Catering(idVendor, harga, nama, jenisMakanan));
            }

            List<String[]> dataHiburan = FileReader.readFromFile("file/hiburan.txt");
            for (String[] record : dataHiburan) {
                int idVendor = Integer.parseInt(record[0]) ;
                float harga = Float.parseFloat(record[1]);
                String nama = record[2];
                String jenisHiburan = record[3];
                daftarPemesananHiburan.add(new Hiburan(idVendor, harga, nama, jenisHiburan));
            }

            List<String[]> dataDecorator = FileReader.readFromFile("file/decorator.txt");
            for (String[] record : dataDecorator) {
                int idVendor = Integer.parseInt(record[0]) ;
                float harga = Float.parseFloat(record[1]);
                String nama = record[2];
                String jenisDecortor = record[3];
                daftarPemesananDecorator.add(new Decorator(idVendor, harga, nama, jenisDecortor));

            }

            List<String[]> dataLayanan= FileReader.readFromFile("file/paketLayanan.txt");
            for (String[] record : dataLayanan) {
                int idPaket = Integer.parseInt(record[0]);
                String nama = record[1];
                String catering = record[2];
                String fotografer = record[3];
                String hiburan = record[4];
                String decorator = record[5];
                int harga = Integer.parseInt(record[6]);
                daftarPaketLayanan.add(new PaketLayanan(idPaket,nama, catering, fotografer, hiburan, decorator, harga));
            }

            List<String[]> dataUser= FileReader.readFromFile("file/user.txt");
            for (String[] record : dataUser) {
                int idKlien = Integer.parseInt(record[0]);
                String nama = record[1];
                String noTelp = record[2];
                String alamat = record[3];
                daftarUser.add(new Klien(idKlien, nama, noTelp, alamat));
            }

            Main mainApp = new Main();
            new Booking(mainApp);
            in.close();
        }
    }
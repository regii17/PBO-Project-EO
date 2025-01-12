import java.io.IOException;
    import java.util.*;

    public class Main {
        private static Scanner in = new Scanner(System.in);

        private static int varIdEvent = 1;
        private static int idUser;
        private static int varStaff = 0;
        private double totalHargaEvent = 0;

        private String[] layananEvent = new String[4];
        private int eventCount = 0;
        private int vendorCount = 0;
        private double totalHargaVendor = 0;
        private String[] layananVendor = new String[5];

        //Relasi Agregasi
        
        
        private static List<Klien> daftarUser = new ArrayList<>();
        private static List<Pernikahan> daftarPemesananPernikahan = new ArrayList<>();
        private static List<Seminar> daftarPemesananSeminar = new ArrayList<>();
        private static List<Ultah> daftarPemesananUltah = new ArrayList<>();
        private static List<Konser> daftarPemesananKonser = new ArrayList<>();
        private static List<Fotografer> daftarPemesananFotografer = new ArrayList<>();
        private static List<Catering> daftarPemesananCatering = new ArrayList<>();
        private static List<Hiburan> daftarPemesananHiburan = new ArrayList<>();
        private static List<Decorator> daftarPemesananDecorator = new ArrayList<>();
        private static List<PaketLayanan> daftarPaketLayanan = new ArrayList<>();


        private static Map<Integer, List<Integer>> userWeddingHistory = new HashMap<>();
        private Map<Integer, List<Fotografer>> userFotograferBookings = new HashMap<>();
        private Map<Integer, List<Catering>> userCateringBookings = new HashMap<>();
        private Map<Integer, List<Decorator>> userDecoratorBookings = new HashMap<>();
        private Map<Integer, List<Hiburan>> userHiburanBookings = new HashMap<>();

        public List<Fotografer> getDaftarPemesananFotografer() {return daftarPemesananFotografer;}
        public List<Catering> getDaftarPemesananCatering(){
            return daftarPemesananCatering;
        }
        public List<Decorator> getDaftarPemesananDecorator(){return daftarPemesananDecorator;}
        public List<Hiburan> getDaftarPemesananHiburan(){
            return daftarPemesananHiburan;
        }
        public List<PaketLayanan> getDaftarPaketLayanan() {return daftarPaketLayanan;}
        public List<Klien> getDaftarUser() {
            return daftarUser;
        }
        public void setIdUser(int idUser) {
            Main.idUser = idUser;
        }
        public static int getIdUser() {
            return idUser;
        }
        public Map<Integer, List<Integer>> getUserWeddingHistory() {
            return userWeddingHistory;
        }

        //Relasi Dependensi
        public void addFotograferBooking(int userId, Fotografer fotografer) {
            userFotograferBookings.computeIfAbsent(Integer.valueOf(userId), k -> new ArrayList<>()).add(fotografer);
        }

        public void addCateringBooking(int userId, Catering catering) {
            userCateringBookings.computeIfAbsent(Integer.valueOf(userId), k -> new ArrayList<>()).add(catering);
        }

        public void addDecoratorBooking(int userId, Decorator decorator) {
            userDecoratorBookings.computeIfAbsent(Integer.valueOf(userId), k -> new ArrayList<>()).add(decorator);
        }

        public void addHiburanBooking(int userId, Hiburan hiburan) {
            userHiburanBookings.computeIfAbsent(Integer.valueOf(userId), k -> new ArrayList<>()).add(hiburan);
        }

        public List<Fotografer> getUserFotograferBookings(int userId) {
            return userFotograferBookings.getOrDefault(Optional.of(userId), new ArrayList<>());
        }

        public List<Catering> getUserCateringBookings(int userId) {
            return userCateringBookings.getOrDefault(Optional.of(userId), new ArrayList<>());
        }

        public List<Decorator> getUserDecoratorBookings(int userId) {
            return userDecoratorBookings.getOrDefault(Optional.of(userId), new ArrayList<>());
        }

        public List<Hiburan> getUserHiburanBookings(int userId) {
            return userHiburanBookings.getOrDefault(Optional.of(userId), new ArrayList<>());
        }

        //Relasi Implementasi (Realisasi)
        /* Relasi di mana sebuah class mengimplementasikan interface.*/
        public String cetakNotaEvent(){
            NotaEvent nota = new NotaEvent(layananEvent[0],layananEvent[1],layananEvent[2],layananEvent[3],totalHargaEvent);
            return nota.cetakNota(layananVendor[0],layananVendor[1],layananVendor[2],layananVendor[3],totalHargaEvent);
        }

        public void setTotalHargaEvent(double totalHargaEvent) {
            this.totalHargaEvent += totalHargaEvent;
        }

        public String cetakNotaVendor(){
            NotaVendor nota = new NotaVendor(layananVendor[0],layananVendor[1],layananVendor[2],layananVendor[3],layananVendor[4],totalHargaEvent);
            return nota.cetakNota(layananVendor[0],layananVendor[1],layananVendor[2],layananVendor[3],layananVendor[4],totalHargaEvent);
        }

        public void setTotalHargaVendor(double totalHargaVendor) {
            this.totalHargaVendor += totalHargaVendor;
        }

        public void setLayananEvent(String eventDescription) {
            if (eventCount < layananEvent.length) {
                layananEvent[eventCount] = eventDescription;
                eventCount++;
            } else {
                System.out.println("Event array is full.");
            }
        }

        public void setLayananVendor(String vendorDescription) {
            if (vendorCount < layananVendor.length) {
                layananVendor[vendorCount] = vendorDescription;
                vendorCount++;
            } else {
                System.out.println("Event array is full.");
            }
        }

        private Staff[] staffMembers = new Staff[10];
        private int staffCount = 0;

        public void bookWedding(String namaPasangan, float jumlahTamu, String lokasi, String tanggal) {
            float hargaLayanan = 200000;
            double totalHarga = hargaLayanan * jumlahTamu;
            Staff kepalaStaff = staffMembers[varStaff++];

            Pernikahan pernikahan = new Pernikahan(idUser, varIdEvent++, jumlahTamu, lokasi, hargaLayanan,
                                                    totalHarga, tanggal, namaPasangan, kepalaStaff);
            daftarPemesananPernikahan.add(pernikahan);
        }

        public void bookSeminar(String topic, String pembicara, float jumlahTamu, String lokasi, String tanggal) {
            float hargaLayananSeminar = 30000;
            double totalHargaSeminar = jumlahTamu * hargaLayananSeminar;
            Staff kepalaStaff = staffMembers[varStaff++];

            Seminar seminar = new Seminar(idUser, varIdEvent++, jumlahTamu, lokasi, hargaLayananSeminar,
                    totalHargaSeminar, tanggal, topic, pembicara, kepalaStaff);
            daftarPemesananSeminar.add(seminar);
        }

        public void bookBirthday(String namaUltah, int usia, float jumlahTamu, String lokasi, String tanggal) {
            float hargaLayananUltah = 200000;
            double totalHargaUltah = jumlahTamu * hargaLayananUltah;
            Staff kepalaStaff = staffMembers[varStaff++];

            Ultah ultah = new Ultah(idUser, varIdEvent++, jumlahTamu, lokasi, hargaLayananUltah,
                    totalHargaUltah, tanggal, namaUltah, usia, kepalaStaff);
            daftarPemesananUltah.add(ultah);
        }

        public void bookConcert(String namaArtis, int jumlahTamu, String lokasi, String tanggal) {
            float hargaLayananKonser = 50000;
            double totalHargaKonser = jumlahTamu * hargaLayananKonser;
            Staff kepalaStaff = staffMembers[varStaff++];

            Konser konser = new Konser(idUser, varIdEvent++, jumlahTamu, lokasi, hargaLayananKonser, totalHargaKonser, tanggal, namaArtis, kepalaStaff);
            daftarPemesananKonser.add(konser);
        }

        public static void addWeddingHistory(int userId, int weddingId) {
            if (userWeddingHistory == null) {
                userWeddingHistory = new HashMap<>();
            }

            userWeddingHistory.putIfAbsent(Integer.valueOf(userId), new ArrayList<>());
            boolean isAdded = userWeddingHistory.get(Optional.of(userId)).add(Integer.valueOf(weddingId));

            if (isAdded) {
                System.out.println("Success: Wedding history added for User ID: " + userId + " with Wedding ID: " + weddingId);
            } else {
                System.err.println("Error: Failed to add wedding history for User ID: " + userId);
            }
        }

        public List<Integer> getWeddingHistory(int userId) {
            if (userWeddingHistory == null || !userWeddingHistory.containsKey(Optional.of(userId))) {
                System.err.println("Error: No wedding history found for User ID: " + userId);
                return new ArrayList<>();
            }
            List<Integer> history = userWeddingHistory.get(Optional.of(userId));
            System.out.println("Success: Retrieved wedding history for User ID: " + userId + " -> " + history);
            return history;
        }

        public List<Pernikahan> getUserWeddingBookings(int userId) {
            List<Pernikahan> userBookings = new ArrayList<>();
            for (Pernikahan pernikahan : daftarPemesananPernikahan) {
                if (pernikahan.getIdUser() == userId) {
                    userBookings.add(pernikahan);
                }
            }
            return userBookings;
        }

        public List<Seminar> getUserSeminarBookings(int userId) {
            List<Seminar> userBookings = new ArrayList<>();
            for (Seminar seminar : daftarPemesananSeminar) {
                if (seminar.getIdUser() == userId) {
                    userBookings.add(seminar);
                }
            }
            return userBookings;
        }

        public List<Ultah> getUserUltahBookings(int userId) {
            List<Ultah> userBookings = new ArrayList<>();
            for (Ultah ultah : daftarPemesananUltah) {
                if (ultah.getIdUser() == userId) {
                    userBookings.add(ultah);
                }
            }
            return userBookings;
        }

        public List<Konser> getUserKonserBookings(int userId) {
            List<Konser> userBookings = new ArrayList<>();
            for (Konser konser : daftarPemesananKonser) {
                if (konser.getIdUser() == userId) {
                    userBookings.add(konser);
                }
            }
            return userBookings;
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

            List<String[]> dataStaff= FileReader.readFromFile("file/staff.txt");
            for (String[] record : dataStaff) {
                String nama = record[0];
                new Staff(nama);
            }

            Main mainApp = new Main();
            //Relasi Asosiasi
        /*Relasi di mana satu class mengetahui keberadaan class lain dan menggunakan objek dari class tersebut.
        * Class Main memiliki banyak daftar seperti:
          List<Fotografer>, List<Catering>, List<Hiburan>, dll.
          Relasi ini menunjukkan bahwa Main mengenal dan menggunakan objek dari class seperti Fotografer, Catering, Hiburan, dll.*/
            new Login(mainApp);
            in.close();
        }
    }

    /*Relasi yang terbentuk dalam kode adalah:

    Asosiasi: Class Main mengenal banyak class lain seperti Login, Fotografer, Catering, dll.
    Dependensi: Metode dalam Main bergantung pada objek seperti Fotografer, Catering, dll.
    Komposisi: Class seperti Pernikahan, Seminar, Ultah, dan Konser memiliki Staff kepalaStaff.
    Agregasi: Main memiliki daftar (List) objek seperti Klien, Fotografer, dll., yang dapat berdiri sendiri.
    Realisasi: Interface Nota diimplementasikan oleh NotaEvent dan NotaVendor.*/
import java.util.*;

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
    private static int varIdUser = 1;
    private static int varIdPaket = 1;
    private static int pilEvent;
    private static int pilTambahan;
    private static int pilTambahan2;
    private static int pilPaketlayanan;

    private static void layananTambahan(int pilTambahan){
        switch (pilTambahan){
            case 1:
                for (Fotografer fg : daftarPemesananFotografer) {
                    System.out.print(fg.getIdVendor() + " ");
                    fg.deskripsiEvent();
                    System.out.println("-------------------");
                }
                System.out.print("Masukkan pilihan : ");
                pilTambahan2 = in.nextInt();

                userFotograferHistory.putIfAbsent(varIdUser, new ArrayList<>());
                userFotograferHistory.get(varIdUser).add(pilTambahan2);

                System.out.println("Riwayat Pemesanan User:");
                for (Map.Entry<Integer, List<Integer>> entry : userFotograferHistory.entrySet()) {
                    System.out.println("User ID: " + entry.getKey());
                    System.out.println("Fotografer ID: " + entry.getValue());
                }
                break;
            case 2:
                for (Catering ck : daftarPemesananCatering) {
                    System.out.print(ck.getIdVendor() + " ");
                    ck.deskripsiEvent();
                    System.out.println("-------------------");
                }
                System.out.print("Masukkan pilihan : ");
                pilTambahan2 = in.nextInt();

                userCateringHistory.putIfAbsent(varIdUser, new ArrayList<>());
                userCateringHistory.get(varIdUser).add(pilTambahan2);

                System.out.println("Riwayat Pemesanan User:");
                for (Map.Entry<Integer, List<Integer>> entry : userCateringHistory.entrySet()) {
                    System.out.println("User ID: " + entry.getKey());
                    System.out.println("Catering ID: " + entry.getValue());
                }
                break;
            case 3:
                for (Hiburan hr : daftarPemesananHiburan) {
                    System.out.print(hr.getIdVendor() + " ");
                    hr.deskripsiEvent();
                    System.out.println("-------------------");
                }
                System.out.print("Masukkan pilihan : ");
                pilTambahan2 = in.nextInt();

                userHiburanHistory.putIfAbsent(varIdUser, new ArrayList<>());
                userHiburanHistory.get(varIdUser).add(pilTambahan2);

                System.out.println("Riwayat Pemesanan User:");
                for (Map.Entry<Integer, List<Integer>> entry : userHiburanHistory.entrySet()) {
                    System.out.println("User ID: " + entry.getKey());
                    System.out.println("Hiburan ID: " + entry.getValue());
                }
                break;
            case 4:
                for (Decorator dr : daftarPemesananDecorator) {
                    System.out.print(dr.getIdVendor() + " ");
                    dr.deskripsiEvent();
                    System.out.println("-------------------");
                }
                System.out.print("Masukkan pilihan : ");
                pilTambahan2 = in.nextInt();

                userDecoratorHistory.putIfAbsent(varIdUser, new ArrayList<>());
                userDecoratorHistory.get(varIdUser).add(pilTambahan2);

                System.out.println("Riwayat Pemesanan User:");
                for (Map.Entry<Integer, List<Integer>> entry : userDecoratorHistory.entrySet()) {
                    System.out.println("User ID : " + entry.getKey());
                    System.out.println("Decorator ID : " + entry.getValue());
                }
                break;
            case 5 :
                return;
            default:
                System.out.println("Pilihan tidak valid.");

        }
    }

    public static void main(String[] args) {
        daftarPemesananFotografer.add(new Fotografer(varIdVendor++, 2000000, "Rian"));
        daftarPemesananFotografer.add(new Fotografer(varIdVendor++, 3000000, "Tian"));

        daftarPemesananCatering.add(new Catering(varIdVendor++, 2000000, "Rudi", "Dessert"));
        daftarPemesananCatering.add(new Catering(varIdVendor++, 3000000, "Ruiad","Makanan Berat"));
        daftarPemesananCatering.add(new Catering(varIdVendor++, 2000000, "Ziad", "Minuman"));
        daftarPemesananCatering.add(new Catering(varIdVendor++, 3000000, "Tono","snek"));

        daftarPemesananHiburan.add(new Hiburan(varIdVendor++, 2000000, "Ronald music", "Jazz"));
        daftarPemesananHiburan.add(new Hiburan(varIdVendor++, 3000000, "Ruan music","POP"));
        daftarPemesananHiburan.add(new Hiburan(varIdVendor++, 2000000, "Ziad music", "Dangdut"));
        daftarPemesananHiburan.add(new Hiburan(varIdVendor++, 3000000, "DJ DUDU","DJ"));

        daftarPemesananDecorator.add(new Decorator(varIdVendor++, 2000000, "Ronald Decor", "Minimalis"));
        daftarPemesananDecorator.add(new Decorator(varIdVendor++, 3000000, "Ruan Decor","Intimate"));
        daftarPemesananDecorator.add(new Decorator(varIdVendor++, 2000000, "Ziad Decor", "Megah"));

        PaketLayanan paketLayanan1 = new PaketLayanan(varIdPaket++, "Pernikahan", "Catering", "Fotografer","Hiburan","Decorator",400000);
        daftarPaketLayanan.add(paketLayanan1);

        PaketLayanan paketLayanan2 = new PaketLayanan(varIdPaket++, "Seminar", "Catering", "Fotografer","Decorator","-",400000);
        daftarPaketLayanan.add(paketLayanan2);

        PaketLayanan paketLayanan3 = new PaketLayanan(varIdPaket++, "Ulang Tahun", "Catering", "Fotografer","Decorator","Hiburan",400000);
        daftarPaketLayanan.add(paketLayanan3);

        PaketLayanan paketLayanan4 = new PaketLayanan(varIdPaket++, "Konser", "Catering", "Fotografer","Decorator","Hiburan",400000);
        daftarPaketLayanan.add(paketLayanan4);

        daftarUser.add(new Klien(varIdUser++, "Alice","08888888","SMKS"));
        daftarUser.add(new Klien(varIdUser++, "Udin","081111111","SMKSSSSS"));
        daftarUser.add(new Klien(varIdUser++, "LOLY","0222222","SMKKKKKK"));

//public PaketLayanan(int idPaket, String event, String layanan1, String layanan2, float harga) {
//        this.idPaket = idPaket;
//        this.event = event;
//        this.layanan1 = layanan1;
//        this.layanan2 = layanan2;
//        this.harga = harga;
//    }
        do {
            System.out.println("\n Aplikasi booking EO Blue Spring");
            System.out.println("Pilihan Acara:");
            System.out.println("1. Acara Pernikahan");
            System.out.println("2. Acara Seminar");
            System.out.println("3. Acara Ultah");
            System.out.println("4. Acara Konser");
            System.out.println("5. Paket layanan");
            System.out.println("6. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilEvent = in.nextInt();

            switch (pilEvent) {
                case 1:
                    System.out.println("\nBooking pernikahan");
                    in.nextLine();
                    System.out.print("Masukkan nama pasangan: ");
                    String namaPasangan = in.nextLine();
                    System.out.print("Masukkan jumlah tamu: ");
                    int jumlahTamu = in.nextInt();
                    System.out.print("Masukkan lokasi: ");
                    String lokasi = in.next();
                    float hargaLayanan = 200000;
                    System.out.print("Masukkan tanggal (YYYY-MM-DD): ");
                    String tanggal = in.next();

                    float totalHarga = jumlahTamu * hargaLayanan;

                    Pernikahan pernikahan = new Pernikahan(varIdUser++,varIdEvent++, jumlahTamu, lokasi, hargaLayanan, totalHarga, tanggal, namaPasangan);
                    daftarPemesananPernikahan.add(pernikahan);

                    System.out.println("Pemesanan berhasil!");
                    pernikahan.deskripsiEvent();
                    break;
                case 2: // Case Seminar
                    System.out.println("\nBooking seminar");
                    System.out.print("Masukkan topik seminar: ");
                    String topic = in.next();
                    System.out.print("Masukkan nama pembicara: ");
                    String pembicara = in.next();
                    System.out.print("Masukkan jumlah tamu: ");
                    int jumlahTamuSeminar = in.nextInt();
                    System.out.print("Masukkan lokasi: ");
                    String lokasiSeminar = in.next();
                    System.out.print("Masukkan harga layanan: ");
                    float hargaLayananSeminar = in.nextFloat();
                    System.out.print("Masukkan tanggal (YYYY-MM-DD): ");
                    String tanggalSeminar = in.next();

                    float totalHargaSeminar = jumlahTamuSeminar * hargaLayananSeminar;


                    Seminar seminar = new Seminar(varIdUser++,varIdEvent++, jumlahTamuSeminar, lokasiSeminar, hargaLayananSeminar, totalHargaSeminar, tanggalSeminar, topic, pembicara);
                    daftarPemesananSeminar.add(seminar);

                    System.out.println("Pemesanan berhasil!");
                    seminar.deskripsiEvent();
                    break;
                case 3:
                    System.out.println("\nBooking acara ulang tahun");
                    System.out.print("Masukkan nama yang berulang tahun: ");
                    String namaUltah = in.next();
                    System.out.print("Masukkan usia: ");
                    int usia = in.nextInt();
                    System.out.print("Masukkan jumlah tamu: ");
                    int jumlahTamuUltah = in.nextInt();
                    System.out.print("Masukkan lokasi: ");
                    String lokasiUltah = in.next();
                    float hargaLayananUltah = 200000;
                    System.out.print("Masukkan tanggal (YYYY-MM-DD): ");
                    String tanggalUltah = in.next();

                    float totalHargaUltah = jumlahTamuUltah * hargaLayananUltah;

                    Ultah ultah = new Ultah(varIdUser++,varIdEvent++, jumlahTamuUltah, lokasiUltah, hargaLayananUltah, totalHargaUltah, tanggalUltah, namaUltah, usia);
                    daftarPemesananUltah.add(ultah);

                    System.out.println("Pemesanan berhasil!");
                    ultah.deskripsiEvent();
                    break;
                case 4:
                    System.out.println("\nBooking acara konser");
                    System.out.print("Masukkan nama artis: ");
                    String namaArtis = in.next();
                    System.out.print("Masukkan jumlah tamu: ");
                    int jumlahTamuKonser = in.nextInt();
                    System.out.print("Masukkan lokasi: ");
                    String lokasiKonser = in.next();
                    System.out.print("Masukkan harga layanan: ");
                    float hargaLayananKonser = in.nextFloat();
                    System.out.print("Masukkan tanggal (YYYY-MM-DD): ");
                    String tanggalKonser = in.next();

                    float totalHargaKonser = jumlahTamuKonser * hargaLayananKonser;

                    Konser konser = new Konser(varIdUser++,varIdEvent++, jumlahTamuKonser, lokasiKonser, hargaLayananKonser, totalHargaKonser, tanggalKonser, namaArtis);
                    daftarPemesananKonser.add(konser);

                    System.out.println("Pemesanan berhasil!");
                    konser.deskripsiEvent();
                    break;
                case 5 :
                    System.out.println("\nDaftar paket layanan:");
                  for (PaketLayanan paket : daftarPaketLayanan) {
                      System.out.println(paket.getIdPaket() + " ");
                      paket.deskripsiPaket();
                      System.out.println("----------------------");
                  }

                      System.out.print("Masukkan pilihan : ");
                      pilPaketlayanan = in.nextInt();

                      userPaketLayananHistory.putIfAbsent(varIdUser, new ArrayList<>());
                      userPaketLayananHistory.get(varIdUser).add(pilPaketlayanan);

                      System.out.println("Riwayat Pemesanan Paket Layanan User:");
                      for (Map.Entry<Integer, List<Integer>> entry : userPaketLayananHistory.entrySet()) {
                          System.out.println("User ID: " + entry.getKey());
                          System.out.println("Paket layanan ID: " + entry.getValue());
                      }
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
            do{
                System.out.println("Apakah kamu ingin menambahkan layanan tambahan ?");
                System.out.println("1. Fotografer");
                System.out.println("2. Catering");
                System.out.println("3. Hiburan");
                System.out.println("4. Decorator");
                System.out.println("5. Tidak");
                System.out.print("Masukkan pilihan : ");
                pilTambahan = in.nextInt();

                layananTambahan(pilTambahan);
            }while (pilTambahan != 5);


        }while(pilEvent != 6);
//            System.out.println("\nDaftar Semua Pemesanan:");
//            for (Pernikahan p : daftarPemesananPernikahan) {
//                p.deskripsiEvent();
//                System.out.println("-------------------");
//            }

            in.close();
    }
}
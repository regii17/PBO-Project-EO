public class Ultah extends Event{
    private String nama;
    private int usia;

    public Ultah(int idUser, int idEvent, float jumlahTamu, String lokasi, float hargaLayanan, double totalHarga, String tanggal, String nama, int usia) {
        super(idUser, idEvent, jumlahTamu, lokasi, hargaLayanan, totalHarga, tanggal);
        this.nama = nama;
        this.usia = usia;
    }

    @Override
    public int getIdEvent() {
        return super.getIdEvent();
    }

    @Override
    void deskripsiEvent() {
        System.out.println("Nama : " + this.nama);
        System.out.println("Usia : " + this.usia);
        System.out.println("Jumlah Tamu : " + super.jumlahTamu);
        System.out.println("Lokasi : " + super.lokasi);
        System.out.println("Harga Layanan : " + super.hargaLayanan);
        System.out.println("Total Harga : " + super.totalHarga);
        System.out.println("Tanggal : " + super.tanggal);
    }
}

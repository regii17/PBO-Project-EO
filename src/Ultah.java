public class Ultah extends Event{
    private String nama;
    private int usia;

    public Ultah(int idUser, int idEvent, float jumlahTamu, String lokasi, float hargaLayanan, double totalHarga, String tanggal, String nama, int usia, Staff staff) {
        super(idUser, idEvent, jumlahTamu, lokasi, hargaLayanan, totalHarga, tanggal, staff);
        this.nama = nama;
        this.usia = usia;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    @Override
    public int getIdEvent() {
        return super.getIdEvent();
    }

    @Override
    String deskripsiEvent() {
        return "";
    }
}

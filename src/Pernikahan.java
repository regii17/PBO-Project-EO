public class Pernikahan extends Event{
    private String namaPasangan;

    public Pernikahan(int idUser, int idEvent, int jumlahTamu, String lokasi, float hargaLayanan, float totalHarga, String tanggal, String namaPasangan) {
        super(idUser, idEvent, jumlahTamu, lokasi, hargaLayanan, totalHarga, tanggal);
        this.namaPasangan = namaPasangan;
    }

    @Override
    public int getIdEvent() {
        return super.getIdEvent();
    }

    @Override
    void deskripsiEvent() {
        System.out.println("Pernikahan Pasangan : " + this.namaPasangan);
        System.out.println("Tanggal Pernikahan : " + super.tanggal);
        System.out.println("Total Harga : " + super.totalHarga);
        System.out.println("Harga Layanan : " + super.hargaLayanan);
        System.out.println("Lokasi : " + super.lokasi);
        System.out.println("Jumlah Tamu : " + super.jumlahTamu);
    }
}

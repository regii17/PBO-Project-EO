public class Konser extends Event{
    private String artis;

    public Konser(int idUser, int idEvent, int jumlahTamu, String lokasi, float hargaLayanan, float totalHarga, String tanggal, String artis) {
        super(idUser, idEvent, jumlahTamu, lokasi, hargaLayanan, totalHarga, tanggal);
        this.artis = artis;
    }

    @Override
    public int getIdEvent() {
        return super.getIdEvent();
    }

    @Override
    void deskripsiEvent() {
        System.out.println("Artis : " + this.artis);
        System.out.println("Jumlah Tamu : " + super.jumlahTamu);
        System.out.println("Harga Layanan : " + super.hargaLayanan);
        System.out.println("Total Harga : " + super.totalHarga);
        System.out.println("Tanggal : " + super.tanggal);


    }
}

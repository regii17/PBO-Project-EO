public class Seminar extends Event{
    private String topic;
    private String pembicara;

    public Seminar(int idUser, int idEvent, float jumlahTamu, String lokasi, float hargaLayanan, double totalHarga, String tanggal, String topic, String pembicara) {
        super(idUser, idEvent, jumlahTamu, lokasi, hargaLayanan, totalHarga, tanggal);
        this.topic = topic;
        this.pembicara = pembicara;
    }

    @Override
    public int getIdEvent() {
        return super.getIdEvent();
    }

    @Override
    void deskripsiEvent() {
        System.out.println("Topic : " + this.topic);
        System.out.println("Pembicara : " + this.pembicara);
        System.out.println("Jumlah Tamu : " + super.jumlahTamu);
        System.out.println("Lokasi : " + super.lokasi);
        System.out.println("Harga Layanan : " + super.hargaLayanan);
        System.out.println("Total Harga : " + super.totalHarga);
        System.out.println("Tanggal : " + super.tanggal);
    }
}

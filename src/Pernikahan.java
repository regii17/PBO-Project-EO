public class Pernikahan extends Event{
    private String namaPasangan;

    public Pernikahan(int idUser, int idEvent, float jumlahTamu, String lokasi, float hargaLayanan, double totalHarga, String tanggal, String namaPasangan, Staff staff) {
        super(idUser, idEvent, jumlahTamu, lokasi, hargaLayanan, totalHarga, tanggal, staff);
        this.namaPasangan = namaPasangan;
    }

    public String getNamaPasangan() {
        return namaPasangan;
    }

    @Override
    public int getIdEvent() {
        return super.getIdEvent();
    }

    @Override
    public String deskripsiEvent() {
        return "Pernikahan Pasangan: " + namaPasangan + "\n" +
                "Tanggal Pernikahan: " + tanggal + "\n" +
                "Total Harga: " + totalHarga + "\n" +
                "Harga Layanan: " + hargaLayanan + "\n" +
                "Lokasi: " + lokasi + "\n" +
                "Jumlah Tamu: " + jumlahTamu;
    }

    public String toString() {
        return deskripsiEvent();
    }
}

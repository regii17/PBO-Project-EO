public class Konser extends Event{
    private String artis;

    public Konser(int idUser, int idEvent, int jumlahTamu, String lokasi, float hargaLayanan, double totalHarga, String tanggal, String artis, Staff staff) {
        super(idUser, idEvent, jumlahTamu, lokasi, hargaLayanan, totalHarga, tanggal, staff);
        this.artis = artis;
    }

    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
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

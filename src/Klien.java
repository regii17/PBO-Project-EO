public class Klien {
    private int idKlien;
    private String nama;
    private String noTelp;
    private String alamat;

    public Klien(int idKlien, String nama, String noTelp, String alamat) {
        this.idKlien = idKlien;
        this.nama = nama;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }

    public int getIdKlien() {
        return idKlien;
    }

    public void setIdKlien(int idKlien) {
        this.idKlien = idKlien;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}

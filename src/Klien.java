import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;

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

    public void updateKlien(String nama, String noTelp, String alamat){
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;

        System.out.println("Nama : " + this.nama);
        System.out.println("Alamat : " + this.alamat);
        System.out.println("No telp : " + this.noTelp);
    }

}

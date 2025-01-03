import org.w3c.dom.ls.LSOutput;

public abstract class Event {
    protected int idUser;
    protected int idEvent;
    protected float jumlahTamu;
    protected String lokasi;
    protected float hargaLayanan;
    protected double totalHarga = 0;
    protected String tanggal;
    protected Staff kepalaStaff;

    public Event(int idUser, int idEvent, float jumlahTamu, String lokasi, float hargaLayanan, double totalHarga, String tanggal, Staff staff) {
        this.idUser = idUser;
        this.idEvent = idEvent;
        this.jumlahTamu = jumlahTamu;
        this.lokasi = lokasi;
        this.hargaLayanan = hargaLayanan;
        this.totalHarga = totalHarga;
        this.tanggal = tanggal;
        this.kepalaStaff = staff;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public float getJumlahTamu() {
        return jumlahTamu;
    }

    public void setJumlahTamu(int jumlahTamu) {
        this.jumlahTamu = jumlahTamu;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public float getHargaLayanan() {
        return hargaLayanan;
    }

    public void setHargaLayanan(float hargaLayanan) {
        this.hargaLayanan = hargaLayanan;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(float totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setJumlahTamu(float jumlahTamu) {
        this.jumlahTamu = jumlahTamu;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public Staff getKepalaStaff() {
        return kepalaStaff;
    }

    public void setKepalaStaff(Staff kepalaStaff) {
        this.kepalaStaff = kepalaStaff;
    }

    abstract String deskripsiEvent();



}



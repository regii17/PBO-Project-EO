public abstract class Vendor {
    protected int idVendor;
    protected float harga;
    protected String nama;

    public Vendor(int idVendor, float harga, String nama) {
        this.idVendor = idVendor;
        this.harga = harga;
        this.nama = nama;
    }

    public int getIdVendor() {
        return idVendor;
    }

    public void setIdVendor(int idVendor) {
        this.idVendor = idVendor;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public abstract void deskripsiEvent();
}

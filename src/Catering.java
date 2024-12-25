public class Catering extends Vendor{
    private String jenisMakanan;

    public Catering(int idVendor, float harga, String nama, String jenisMakanan) {
        super(idVendor, harga, nama);
        this.jenisMakanan = jenisMakanan;
    }

    public String getJenisMakanan() {
        return jenisMakanan;
    }

    public void setJenisMakanan(String jenisMakanan) {
        this.jenisMakanan = jenisMakanan;
    }

    @Override
    public int getIdVendor() {
        return super.getIdVendor();
    }

    @Override
    public String deskripsiEvent() {
        return "Jenis makanan: " + this.jenisMakanan + "\n" +
                "Harga: " + super.harga + "\n" +
                "Nama: " + super.nama;
    }


}

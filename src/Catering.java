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
    public void deskripsiEvent() {
        System.out.println("Jenis makanan : " + this.jenisMakanan);
        System.out.println("Harga : " + super.harga);
        System.out.println("Nama : " + super.nama);

    }


}

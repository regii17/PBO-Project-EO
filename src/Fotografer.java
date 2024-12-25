public class Fotografer extends Vendor{

    public Fotografer(int idVendor, float harga, String nama) {
        super(idVendor, harga, nama);
    }

    @Override
    public int getIdVendor() {
        return super.getIdVendor();
    }

    @Override
    public String deskripsiEvent() {
        return "Nama : " + this.nama + "\n" +
                "Harga: " + this.harga;
    }
}

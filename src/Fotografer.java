public class Fotografer extends Vendor{

    public Fotografer(int idVendor, float harga, String nama) {
        super(idVendor, harga, nama);
    }

    @Override
    public int getIdVendor() {
        return super.getIdVendor();
    }

    @Override
    public void deskripsiEvent() {
        System.out.println("Nama : " + super.nama);
        System.out.println("Harga : " + super.harga);


    }
}

public class Decorator extends Vendor{
    private String jenisDecorator;

    public Decorator(int idVendor, float harga, String nama, String jenisDecorator) {
        super(idVendor, harga, nama);
        this.jenisDecorator = jenisDecorator;
    }

    @Override
    public int getIdVendor() {
        return super.getIdVendor();
    }

    @Override
    public void deskripsiEvent() {
        System.out.println("Harga : " + this.harga);
        System.out.println("Nama : " + this.nama);
        System.out.println("JenisDecorator : " + this.jenisDecorator);

    }

    public String getJenisDecorator() {
        return jenisDecorator;
    }

    public void setJenisDecorator(String jenisDecorator) {
        this.jenisDecorator = jenisDecorator;
    }

}

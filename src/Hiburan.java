public class Hiburan extends Vendor{
    private String jenisHiburan;

    public Hiburan(int idVendor, float harga, String nama, String jenisHiburan) {
        super(idVendor, harga, nama);
        this.jenisHiburan = jenisHiburan;
    }

    @Override
    public int getIdVendor() {
        return super.getIdVendor();
    }

    @Override
    public void deskripsiEvent() {
        System.out.println("Jenis hiburan : " + this.jenisHiburan);
        System.out.println("Harga : " + super.harga);
        System.out.println("Nama : " + super.nama);
    }

    public String getJenisHiburan() {
        return jenisHiburan;
    }

    public void setJenisHiburan(String jenisHiburan) {
        this.jenisHiburan = jenisHiburan;
    }

}

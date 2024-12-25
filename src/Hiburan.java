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
    public String deskripsiEvent() {
        return "Nama : " + this.nama + "\n" +
                "Harga: " + this.harga + "\n" +
                "Jenis hiburan : " + this.jenisHiburan;
    }

    public String getJenisHiburan() {
        return jenisHiburan;
    }

    public void setJenisHiburan(String jenisHiburan) {
        this.jenisHiburan = jenisHiburan;
    }

}

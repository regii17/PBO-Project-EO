public class PaketLayanan {
    private int idPaket;
    private String nama;
    private String catering;
    private String fotografer;
    private String hiburan;
    private String decorator;
    private int harga;

    public PaketLayanan(int idPaket, String nama, String catering, String fotografer, String hiburan, String decorator, int harga) {
        this.idPaket = idPaket;
        this.nama = nama;
        this.catering = catering;
        this.fotografer = fotografer;
        this.hiburan = hiburan;
        this.decorator = decorator;
        this.harga = harga;
    }

    public int getIdPaket() {
        return idPaket;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public String deskripsiPaket() {
        return String.format("Nama: %s\nCatering: %s\nFotografer: %s\nHiburan: %s\nDecorator: %s\nHarga: Rp%d",
                nama, catering, fotografer, hiburan, decorator, harga);
    }
    public void desckripsiPaket(){
        System.out.println("Nama : " + nama);
        System.out.println("Catering : " + catering);
        System.out.println("FG : " + fotografer);
    }
}

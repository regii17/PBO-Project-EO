public class PaketLayanan {
    private int idPaket;
    private String event;
    private String layanan1;
    private String layanan2;
    private String layanan3;
    private String layanan4;
    private float harga;

    public PaketLayanan(int idPaket, String event, String layanan1, String layanan2, String layanan3, String layanan4, float harga) {
        this.idPaket = idPaket;
        this.event = event;
        this.layanan1 = layanan1;
        this.layanan2 = layanan2;
        this.layanan3 = layanan3;
        this.layanan4 = layanan4;
        this.harga = harga;
    }

    public int getIdPaket() {
        return idPaket;
    }

    public void setIdPaket(int idPaket) {
        this.idPaket = idPaket;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getLayanan1() {
        return layanan1;
    }

    public void setLayanan1(String layanan1) {
        this.layanan1 = layanan1;
    }

    public String getLayanan2() {
        return layanan2;
    }

    public void setLayanan2(String layanan2) {
        this.layanan2 = layanan2;
    }

    public String getLayanan3() {
        return layanan3;
    }

    public void setLayanan3(String layanan3) {
        this.layanan3 = layanan3;
    }

    public String getLayanan4() {
        return layanan4;
    }

    public void setLayanan4(String layanan4) {
        this.layanan4 = layanan4;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }

    public void deskripsiPaket(){
        System.out.println("Layanan 1 : " + this.layanan1);
        System.out.println("Layanan 2 : " + this.layanan2);
        System.out.println("Layanan 3 : " + this.layanan3);
        System.out.println("Layanan 4 : " + this.layanan4);
        System.out.println("Harga" + this.harga);

    }
}

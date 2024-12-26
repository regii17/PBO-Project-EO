public class NotaEvent implements Nota{
    String layanan1,layanan2,layanan3,layanan4;
    double totalHarga;

    public NotaEvent(String layanan1, String layanan2, String layanan3, String layanan4, double totalHarga) {
        this.layanan1 = layanan1;
        this.layanan2 = layanan2;
        this.layanan3 = layanan3;
        this.layanan4 = layanan4;
        this.totalHarga = totalHarga;
    }

    @Override
    public String cetakNota() {
        return "Layanan 1 : " + layanan1 + " \n "+
                "Layanan 2 : " + layanan2 + " \n " +
                "Layanan 3 : " + layanan3 + " \n " +
                "Layanan 4 : " + layanan4 + " \n " +
                "Total harga : " + totalHarga;

    }
}

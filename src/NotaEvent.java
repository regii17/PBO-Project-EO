public class NotaEvent implements Nota{
    String layanan1,layanan2,layanan3,layanan4;
    double totalHarga;

    public NotaEvent(String layanan1, double totalHarga) {
        this.layanan1 = layanan1;
        this.totalHarga = totalHarga;
    }
    public NotaEvent(String layanan1, String layanan2, double totalHarga) {
        this.layanan1 = layanan1;
        this.layanan2 = layanan2;
        this.totalHarga = totalHarga;
    }
    public NotaEvent(String layanan1, String layanan2, String layanan3, double totalHarga) {
        this.layanan1 = layanan1;
        this.layanan2 = layanan2;
        this.layanan3 = layanan3;
        this.totalHarga = totalHarga;
    }
    public NotaEvent(String layanan1, String layanan2, String layanan3, String layanan4, double totalHarga) {
        this.layanan1 = layanan1;
        this.layanan2 = layanan2;
        this.layanan3 = layanan3;
        this.layanan4 = layanan4;
        this.totalHarga = totalHarga;
    }

    @Override
    public String cetakNota(String layanan1, double totalHarga) {
        return "Layanan 1 : " + layanan1 + " \n "+
                "Total harga : " + totalHarga;
    }

    @Override
    public String cetakNota(String layanan1, String layanan2, double totalHarga) {
        return "Layanan 1 : " + layanan1 + " \n "+
                "Layanan 2 : " + layanan2 + " \n " +
                "Total harga : " + totalHarga;
    }
    @Override
    public String cetakNota(String layanan1, String layanan2, String layanan3, double totalHarga) {
        return "Layanan 1 : " + layanan1 + " \n "+
                "Layanan 2 : " + layanan2 + " \n " +
                "Layanan 3 : " + layanan3 + " \n " +
                "Total harga : " + totalHarga;

    }
    @Override
    public String cetakNota(String layanan1, String layanan2, String layanan3, String layanan4, double totalHarga) {
        return "Layanan 1 : " + layanan1 + " \n "+
                "Layanan 2 : " + layanan2 + " \n " +
                "Layanan 3 : " + layanan3 + " \n " +
                "Layanan 4 : " + layanan4 + " \n " +
                "Total harga : " + totalHarga;

    }

    @Override
    public String cetakNota(String vendor1, String vendor2, String vendor3, String vendor4, String vendor5, double totalHarga) {
        return "";
    }

}

public class NotaVendor implements Nota{
    String vendor1, vendor2, vendor3, vendor4, vendor5;
    double totalHarga;

    public NotaVendor(String vendor1, String vendor2, String vendor3, String vendor4, String vendor5, double totalHarga) {
        this.vendor1 = vendor1;
        this.vendor2 = vendor2;
        this.vendor3 = vendor3;
        this.vendor4 = vendor4;
        this.vendor5 = vendor5;
        this.totalHarga = totalHarga;
    }

    @Override
    public String cetakNota() {
        return "Vendor 1 : " + vendor1 + " \n "+
                "Vendor 2 : " + vendor2 + " \n " +
                "Vendor 3 : " + vendor3 + " \n " +
                "Vendor 4 : " + vendor4 + " \n " +
                "Vendor 5 : " + vendor5 + " \n " +
                "Total harga : " + totalHarga;

    }
}

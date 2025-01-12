public interface Nota {

    String cetakNota(String layanan1, double totalHarga);

    String cetakNota(String layanan1, String layanan2, double totalHarga);

    String cetakNota(String layanan1, String layanan2, String layanan3, double totalHarga);

    String cetakNota(String layanan1, String layanan2, String layanan3, String layanan4, double totalHarga);

    String cetakNota(String vendor1, String vendor2, String vendor3, String vendor4, String vendor5, double totalHarga);
}

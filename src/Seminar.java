public class Seminar extends Event{
    private String topic;
    private String pembicara;

    public Seminar(int idUser, int idEvent, float jumlahTamu, String lokasi, float hargaLayanan, double totalHarga, String tanggal, String topic, String pembicara, Staff staff) {
        super(idUser, idEvent, jumlahTamu, lokasi, hargaLayanan, totalHarga, tanggal, staff);
        this.topic = topic;
        this.pembicara = pembicara;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPembicara() {
        return pembicara;
    }

    public void setPembicara(String pembicara) {
        this.pembicara = pembicara;
    }

    @Override
    public int getIdEvent() {
        return super.getIdEvent();
    }

    @Override
    String deskripsiEvent() {
        return "";
    }
}

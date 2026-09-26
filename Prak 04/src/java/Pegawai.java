public abstract class Pegawai {

    protected final String nip;
    protected final String nama;
    protected final double gajiPokok;

    protected Pegawai(String nip, String nama, double gajiPokok) {
        if (gajiPokok < 0) {
            throw new IllegalArgumentException("Gaji pokok tidak boleh negatif!");
        }

        this.nip = nip;
        this.nama = nama;
        this.gajiPokok = gajiPokok;
    }

    public double hitungGaji() {
        return gajiPokok;
    }

    public abstract String jenis();

    public String getNama() {
        return nama;
    }

    public String getNip() {
        return nip;
    }

    @Override
    public String toString() {
        return String.format(
            "%-14s %-9s %-20s Rp%,.2f",
            nip, jenis(), nama, hitungGaji()
        );
    }
}
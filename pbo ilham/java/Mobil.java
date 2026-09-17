/**
 * Class Mobil
 * Domain: Anggota Mobil (Kendaraan)
 *
 * Invarian:
 * 1. bahanBakar tidak boleh negatif dan tidak boleh melebihi kapasitasTangki
 *    Alasan: jumlah bahan bakar adalah kuantitas fisik. Nilai negatif tidak
 *    punya arti di dunia nyata, dan tangki tidak mungkin menampung lebih
 *    dari kapasitasnya.
 *
 * 2. kecepatan tidak boleh negatif dan tidak boleh melebihi kecepatanMaksimum
 *    Alasan: kecepatan adalah besaran fisik yang tidak mungkin negatif, dan
 *    setiap mobil punya batas kecepatan maksimum yang tidak boleh dilampaui.
 *
 * Kedua invarian dijaga oleh method isiBahanBakar(), gunakanBahanBakar(),
 * percepat(), dan perlambat(). Tidak ada setter untuk bahanBakar maupun
 * kecepatan, sehingga kedua field ini hanya bisa berubah lewat method-method
 * tersebut, yang selalu memvalidasi nilai sebelum mengubahnya.
 */
public class Mobil {
    private String merk;
    private String model;
    private int tahunProduksi;
    private double kapasitasTangki;      // liter
    private double bahanBakar;           // liter (invarian 1)
    private double kecepatan;            // km/jam (invarian 2)
    private double kecepatanMaksimum;    // km/jam

    public Mobil(String merk, String model, int tahunProduksi,
                 double kapasitasTangki, double kecepatanMaksimum) {
        if (merk == null || merk.isBlank()) {
            throw new IllegalArgumentException("Merk tidak boleh kosong.");
        }
        if (kapasitasTangki <= 0) {
            throw new IllegalArgumentException("Kapasitas tangki harus lebih dari 0.");
        }
        if (kecepatanMaksimum <= 0) {
            throw new IllegalArgumentException("Kecepatan maksimum harus lebih dari 0.");
        }
        this.merk = merk;
        this.model = model;
        this.tahunProduksi = tahunProduksi;
        this.kapasitasTangki = kapasitasTangki;
        this.kecepatanMaksimum = kecepatanMaksimum;
        this.bahanBakar = 0;   // mobil baru, tangki kosong -> tetap memenuhi invarian
        this.kecepatan = 0;    // mobil baru, diam -> tetap memenuhi invarian
    }

    // ---------- Getter (tidak ada setter untuk field ber-invarian) ----------
    public String getMerk() { return merk; }
    public String getModel() { return model; }
    public int getTahunProduksi() { return tahunProduksi; }
    public double getKapasitasTangki() { return kapasitasTangki; }
    public double getBahanBakar() { return bahanBakar; }
    public double getKecepatan() { return kecepatan; }
    public double getKecepatanMaksimum() { return kecepatanMaksimum; }

    // ---------- Menjaga invarian 1 (bahanBakar) ----------

    /** Mengisi bahan bakar. Ditolak jika hasilnya melebihi kapasitas tangki. */
    public boolean isiBahanBakar(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Ditolak : jumlah pengisian harus lebih dari 0");
            return false;
        }
        if (bahanBakar + jumlah > kapasitasTangki) {
            System.out.println("Ditolak : pengisian bahan bakar akan melebihi kapasitas tangki");
            return false;
        }
        bahanBakar += jumlah;
        return true;
    }

    /** Menggunakan bahan bakar. Ditolak jika hasilnya membuat bahan bakar negatif. */
    public boolean gunakanBahanBakar(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Ditolak : jumlah penggunaan harus lebih dari 0");
            return false;
        }
        if (bahanBakar - jumlah < 0) {
            System.out.println("Ditolak : bahan bakar tidak mencukupi");
            return false;
        }
        bahanBakar -= jumlah;
        return true;
    }

    // ---------- Menjaga invarian 2 (kecepatan) ----------

    /** Menambah kecepatan. Ditolak jika hasilnya melebihi kecepatan maksimum. */
    public boolean percepat(double tambahan) {
        if (tambahan <= 0) {
            System.out.println("Ditolak : penambahan kecepatan harus lebih dari 0");
            return false;
        }
        double kecepatanBaru = kecepatan + tambahan;
        if (kecepatanBaru > kecepatanMaksimum) {
            System.out.println("Ditolak : kecepatan akan melebihi batas maksimum");
            return false;
        }
        kecepatan = kecepatanBaru;
        return true;
    }

    /** Mengurangi kecepatan (mengerem). Ditolak jika hasilnya membuat kecepatan negatif. */
    public boolean perlambat(double pengurangan) {
        if (pengurangan <= 0) {
            System.out.println("Ditolak : pengurangan kecepatan harus lebih dari 0");
            return false;
        }
        double kecepatanBaru = kecepatan - pengurangan;
        if (kecepatanBaru < 0) {
            System.out.println("Ditolak : kecepatan tidak boleh negatif");
            return false;
        }
        kecepatan = kecepatanBaru;
        return true;
    }

    public void tampilkanInfo() {
        System.out.println("=== Info Mobil ===");
        System.out.println("Merk           : " + merk);
        System.out.println("Model          : " + model);
        System.out.println("Tahun Produksi : " + tahunProduksi);
        System.out.println("Bahan Bakar    : " + bahanBakar + " / " + kapasitasTangki + " L");
        System.out.println("Kecepatan      : " + kecepatan + " / " + kecepatanMaksimum + " km/jam");
        System.out.println("==================");
    }
}

public class MainMobil {
    public static void main(String[] args) {
        // 1. Membuat objek valid
        Mobil mobilku = new Mobil("Toyota", "Avanza", 2023, 45.0, 160.0);

        mobilku.tampilkanInfo();

        // 2. Satu perubahan yang SAH
        System.out.println("\nSetelah isiBahanBakar(20) sekali:");
        mobilku.isiBahanBakar(20.0); // sah, 20 <= 45
        mobilku.tampilkanInfo();

        // 3. Dua operasi yang TIDAK SAH -> objek harus menolaknya
        System.out.println();
        mobilku.isiBahanBakar(100.0); // tidak sah, 20 + 100 > 45
        mobilku.percepat(200.0);      // tidak sah, 200 > 160
    }
}

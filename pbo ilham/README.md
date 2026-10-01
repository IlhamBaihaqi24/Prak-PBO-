# Tugas 1 — Mobil

**Nama:** Ilham Baihaqi 
**NPM:** 4525210029

## Nama Domain
Mobil Avanza

## Invarian & Alasannya

1. **`bahanBakar` tidak boleh negatif dan tidak boleh melebihi `kapasitasTangki`**
   Alasan: jumlah bahan bakar adalah kuantitas fisik. Nilai negatif tidak
   punya arti di dunia nyata, dan tangki tidak mungkin menampung lebih
   dari kapasitasnya.

2. **`kecepatan` tidak boleh negatif dan tidak boleh melebihi `kecepatanMaksimum`**
   Alasan: kecepatan adalah besaran fisik yang tidak mungkin negatif, dan
   setiap mobil punya batas kecepatan maksimum (spesifikasi pabrikan) yang
   tidak boleh dilampaui.

Kedua invarian dijaga oleh method `isiBahanBakar()`, `gunakanBahanBakar()`,
`percepat()`, dan `perlambat()`. Tidak ada setter untuk `bahanBakar` maupun
`kecepatan`, sehingga kedua field ini hanya bisa berubah lewat method-method
tersebut, yang selalu memvalidasi sebelum mengubah nilai.

## Cara Menjalankan

### Java

1. Masuk ke folder `java`:
```
   cd java
```
2. Compile kode-nya:
```
   javac Mobil.java MainMobil.java
```
3. Jalankan:
```
   java MainMobil
```

### PHP

1. Masuk ke folder `php`:
```
   cd php
```
2. Jalankan:
```
   php index.php
```

## Contoh Output (Java & PHP menghasilkan pola yang sama)

```
=== Info Mobil ===
Merk           : Toyota
Model          : Avanza
Tahun Produksi : 2023
Bahan Bakar    : 0 / 45 L
Kecepatan      : 0 / 160 km/jam
==================

Setelah isiBahanBakar(20) sekali:
=== Info Mobil ===
Merk           : Toyota
Model          : Avanza
Tahun Produksi : 2023
Bahan Bakar    : 20 / 45 L
Kecepatan      : 0 / 160 km/jam
==================

Ditolak : pengisian bahan bakar akan melebihi kapasitas tangki
Ditolak : kecepatan akan melebihi batas maksimum
```

## Cara Kerja Sederhana

- Constructor mengisi `merk`, `model`, `tahunProduksi`, `kapasitasTangki`,
  `kecepatanMaksimum`, sedangkan `bahanBakar` dan `kecepatan` selalu dimulai
  dari 0 (mobil baru, tangki kosong dan diam — otomatis memenuhi kedua
  invarian).
- `isiBahanBakar(jumlah)` menolak kalau setelah ditambah akan melebihi
  `kapasitasTangki` (menjaga Invarian 1).
- `gunakanBahanBakar(jumlah)` menolak kalau setelah dikurangi akan menjadi
  negatif (menjaga Invarian 1).
- `percepat(tambahan)` menolak kalau setelah ditambah akan melebihi
  `kecepatanMaksimum` (menjaga Invarian 2).
- `perlambat(pengurangan)` menolak kalau setelah dikurangi akan menjadi
  negatif (menjaga Invarian 2).
- Tidak ada setter untuk `bahanBakar` maupun `kecepatan`. Kedua field ini
  hanya bisa berubah lewat keempat method di atas, karena semuanya
  memvalidasi nilai baru sebelum mengubah state objek.

## Deklarasi Penggunaan AI
Saya menyusun code ini dengan bantuan AI (Claude, Anthropic) untuk membantu
merancang struktur class, menentukan invarian yang relevan dengan domain
Mobil, serta menuliskan implementasi Java dan PHP sesuai ketentuan tugas.

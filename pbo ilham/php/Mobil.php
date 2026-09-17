<?php

class Mobil
{
    private string $merk;
    private string $model;
    private int $tahunProduksi;
    private float $kapasitasTangki;   // liter
    private float $bahanBakar;        // liter (invarian 1)
    private float $kecepatan;         // km/jam (invarian 2)
    private float $kecepatanMaksimum; // km/jam

    public function __construct(
        string $merk,
        string $model,
        int $tahunProduksi,
        float $kapasitasTangki,
        float $kecepatanMaksimum
    ) {
        if (trim($merk) === '') {
            throw new InvalidArgumentException("Merk tidak boleh kosong.");
        }
        if ($kapasitasTangki <= 0) {
            throw new InvalidArgumentException("Kapasitas tangki harus lebih dari 0.");
        }
        if ($kecepatanMaksimum <= 0) {
            throw new InvalidArgumentException("Kecepatan maksimum harus lebih dari 0.");
        }

        $this->merk = $merk;
        $this->model = $model;
        $this->tahunProduksi = $tahunProduksi;
        $this->kapasitasTangki = $kapasitasTangki;
        $this->kecepatanMaksimum = $kecepatanMaksimum;
        $this->bahanBakar = 0;
        $this->kecepatan = 0;
    }

    // ---------- Getter (tidak ada setter untuk field ber-invarian) ----------
    public function getMerk(): string { return $this->merk; }
    public function getModel(): string { return $this->model; }
    public function getTahunProduksi(): int { return $this->tahunProduksi; }
    public function getKapasitasTangki(): float { return $this->kapasitasTangki; }
    public function getBahanBakar(): float { return $this->bahanBakar; }
    public function getKecepatan(): float { return $this->kecepatan; }
    public function getKecepatanMaksimum(): float { return $this->kecepatanMaksimum; }

    // ---------- Menjaga invarian 1 (bahanBakar) ----------

    public function isiBahanBakar(float $jumlah): bool
    {
        if ($jumlah <= 0) {
            echo "Ditolak : jumlah pengisian harus lebih dari 0\n";
            return false;
        }
        if ($this->bahanBakar + $jumlah > $this->kapasitasTangki) {
            echo "Ditolak : pengisian bahan bakar akan melebihi kapasitas tangki\n";
            return false;
        }
        $this->bahanBakar += $jumlah;
        return true;
    }

    public function gunakanBahanBakar(float $jumlah): bool
    {
        if ($jumlah <= 0) {
            echo "Ditolak : jumlah penggunaan harus lebih dari 0\n";
            return false;
        }
        if ($this->bahanBakar - $jumlah < 0) {
            echo "Ditolak : bahan bakar tidak mencukupi\n";
            return false;
        }
        $this->bahanBakar -= $jumlah;
        return true;
    }

    // ---------- Menjaga invarian 2 (kecepatan) ----------

    public function percepat(float $tambahan): bool
    {
        if ($tambahan <= 0) {
            echo "Ditolak : penambahan kecepatan harus lebih dari 0\n";
            return false;
        }
        $kecepatanBaru = $this->kecepatan + $tambahan;
        if ($kecepatanBaru > $this->kecepatanMaksimum) {
            echo "Ditolak : kecepatan akan melebihi batas maksimum\n";
            return false;
        }
        $this->kecepatan = $kecepatanBaru;
        return true;
    }

    public function perlambat(float $pengurangan): bool
    {
        if ($pengurangan <= 0) {
            echo "Ditolak : pengurangan kecepatan harus lebih dari 0\n";
            return false;
        }
        $kecepatanBaru = $this->kecepatan - $pengurangan;
        if ($kecepatanBaru < 0) {
            echo "Ditolak : kecepatan tidak boleh negatif\n";
            return false;
        }
        $this->kecepatan = $kecepatanBaru;
        return true;
    }

    public function tampilkanInfo(): void
    {
        echo "=== Info Mobil ===\n";
        echo "Merk           : {$this->merk}\n";
        echo "Model          : {$this->model}\n";
        echo "Tahun Produksi : {$this->tahunProduksi}\n";
        echo "Bahan Bakar    : {$this->bahanBakar} / {$this->kapasitasTangki} L\n";
        echo "Kecepatan      : {$this->kecepatan} / {$this->kecepatanMaksimum} km/jam\n";
        echo "==================\n";
    }
}

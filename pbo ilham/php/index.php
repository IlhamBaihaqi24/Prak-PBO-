<?php
require_once __DIR__ . '/Mobil.php';

// 1. Membuat objek valid
$mobilku = new Mobil("Toyota", "Avanza", 2023, 45.0, 160.0);

$mobilku->tampilkanInfo();

// 2. Satu perubahan yang SAH
echo "\nSetelah isiBahanBakar(20) sekali:\n";
$mobilku->isiBahanBakar(20.0); // sah, 20 <= 45
$mobilku->tampilkanInfo();

// 3. Dua operasi yang TIDAK SAH -> objek harus menolaknya
echo "\n";
$mobilku->isiBahanBakar(100.0); // tidak sah, 20 + 100 > 45
$mobilku->percepat(200.0);      // tidak sah, 200 > 160

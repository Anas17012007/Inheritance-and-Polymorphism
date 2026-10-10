# Bentuk (Inheritance Bangun Datar & Ruang)

Program Java sederhana yang mendemonstrasikan konsep **inheritance (pewarisan)**, **method overriding**, **encapsulation** (getter/setter), dan penggunaan **constant** (`static final`) melalui hierarki class bentuk geometri.

## Struktur File

```
.
├── Bentuk.java         # Superclass: atribut warna
├── BujurSangkar.java   # Turunan Bentuk: persegi/bujur sangkar
├── Lingkaran.java      # Turunan Bentuk: lingkaran
├── Silinder.java       # Turunan Lingkaran: silinder
├── Main.java           # Class utama (main)
└── README.md
```

## Hierarki Class

```
Bentuk
├── BujurSangkar
└── Lingkaran
    └── Silinder
```

## Deskripsi Class

| Class | Extends | Atribut | Method Utama |
|---|---|---|---|
| `Bentuk` | – | `warna` | `getWarna()`, `setWarna()`, `printInfo()` |
| `BujurSangkar` | `Bentuk` | `sisi` | `hitungLuas()` (sisi × sisi), `printInfo()` *(override)* |
| `Lingkaran` | `Bentuk` | `radius`, `PHI = 3.14159` | `hitungLuas()` (π × r²), `printInfo()` *(override)* |
| `Silinder` | `Lingkaran` | `tinggi` | `hitungVolume()` (luas alas × tinggi), `printInfo()` *(override)* |

### Rumus

- **Luas bujur sangkar** = `sisi × sisi`
- **Luas lingkaran** = `PHI × radius × radius`
- **Volume silinder** = `luas lingkaran × tinggi`

### Konstruktor

| Class | Signature |
|---|---|
| `Bentuk` | `Bentuk(String warna)` |
| `BujurSangkar` | `BujurSangkar(double sisi, String warna)` |
| `Lingkaran` | `Lingkaran(double radius, String warna)` |
| `Silinder` | `Silinder(double tinggi, double radius, String warna)` |

> Perhatikan urutan parameter `Silinder`: **tinggi** diletakkan lebih dulu, baru `radius`.

## Cara Menjalankan

Pastikan **JDK** sudah terpasang, lalu jalankan dari folder yang berisi semua file:

```bash
javac *.java
java Main
```

## Contoh Penggunaan

```java
BujurSangkar bs = new BujurSangkar(5, "merah");
bs.printInfo();

Lingkaran l = new Lingkaran(7, "biru");
l.printInfo();

Silinder s = new Silinder(10, 7, "hijau");
s.printInfo();
```

## Contoh Output

```
Bujursangkar berwarna merah, luas = 25.0
Lingkaran biru, luas = 153.93791
Silinder warna hijau, volume = 1539.3791
```

> Nilai desimal dapat tampil dengan sedikit selisih di digit terakhir karena sifat bilangan `double` pada Java.

## Konsep OOP yang Digunakan

- **Inheritance** – `BujurSangkar` dan `Lingkaran` mewarisi `Bentuk`; `Silinder` mewarisi `Lingkaran`.
- **Method Overriding** – `printInfo()` ditimpa di setiap subclass dengan keluaran yang berbeda.
- **Super constructor** – subclass memanggil `super(...)` untuk menginisialisasi atribut parent.
- **Encapsulation** – atribut `sisi`, `radius`, dan `tinggi` bersifat `private` dengan getter/setter.
- **Constant** – `PHI` dideklarasikan `public static final`.

## Catatan

- `Silinder` memakai kembali `hitungLuas()` dari `Lingkaran` sebagai luas alas untuk menghitung volume.
- `printInfo()` pada `Silinder` hanya menampilkan volume, bukan luas alas.
- `PHI` menggunakan nilai pendekatan `3.14159`, bukan `Math.PI`, sehingga hasil sedikit berbeda dari perhitungan presisi penuh.

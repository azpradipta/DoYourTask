# Do Your Task

**Do Your Task** adalah aplikasi manajemen tugas yang membantu pengguna dalam mengelola tugas-tugas perkuliahan. Aplikasi ini dibangun menggunakan Java dengan JavaFX untuk antarmuka pengguna.

## Fitur

- **Mata Kuliah**: Menyimpan daftar mata kuliah yang sedang diikuti.
- **Tugas**: Menyimpan daftar tugas yang harus diselesaikan, lengkap dengan informasi tenggat waktu dan urgensi.
- **Riwayat Tugas**: Menyimpan riwayat tugas yang telah diselesaikan atau sedang dalam proses.

## Struktur Proyek

### Paket `com.example.doyourtask.model`

- **MataKuliah.java**: Kelas untuk merepresentasikan mata kuliah.
- **RiwayatTugas.java**: Kelas untuk merepresentasikan riwayat tugas.
- **RiwayatTugasData.java**: Singleton untuk menyimpan dan mengelola daftar riwayat tugas.
- **Tugas.java**: Kelas untuk merepresentasikan tugas dengan properti yang dapat diobservasi.
- **TugasData.java**: Singleton untuk menyimpan dan mengelola daftar tugas.

### Paket `com.example.doyourtask`

- **Main.java**: Kelas utama untuk menjalankan aplikasi.

## Instalasi

1. **Kloning Repository**
    ```bash
    git clone https://github.com/azpradipta/DoYourTask
    cd doyourtask
    ```

2. **Buka Proyek dengan IDE**
    - Buka proyek ini dengan IDE favorit Anda (misalnya IntelliJ IDEA, Eclipse).

3. **Konfigurasi JavaFX**
    - Pastikan Anda telah mengatur library JavaFX dengan benar di IDE Anda.
    - Jika menggunakan Maven, tambahkan dependensi JavaFX di `pom.xml` Anda (tidak disertakan dalam proyek ini).

4. **Jalankan Aplikasi**
    - Jalankan `Main.java` untuk memulai aplikasi.

## Penggunaan

1. **Menambahkan Mata Kuliah**
    - Buka aplikasi dan tambahkan mata kuliah melalui antarmuka yang disediakan.

2. **Menambahkan Tugas**
    - Tambahkan tugas baru dengan memasukkan nama tugas, mata kuliah terkait, tenggat waktu, dan urgensi.

3. **Melihat Riwayat Tugas**
    - Tinjau riwayat tugas yang telah diselesaikan atau sedang dalam proses melalui antarmuka yang disediakan.


---

Terima kasih telah menggunakan **Do Your Task**! Semoga aplikasi ini dapat membantu Anda dalam mengelola tugas-tugas perkuliahan dengan lebih baik.

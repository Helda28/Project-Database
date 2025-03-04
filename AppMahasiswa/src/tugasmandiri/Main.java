
package tugasmandiri;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Membuat objek CRUDOperations untuk mengelola data mahasiswa
        OperasiCrud crudOperations = new OperasiCrud();
        // Membuat objek Scanner untuk membaca input dari pengguna
        Scanner scanner = new Scanner(System.in);
        boolean running = true;  // Variabel untuk mengontrol perulangan menu

        // Perulangan untuk menampilkan menu dan memproses input pengguna
        while (running) {
            System.out.println("=============================");
            System.out.println("|   Pilih menu:             |");
            System.out.println("|   [C] : Create            |");
            System.out.println("|   [R] : Read              |");
            System.out.println("|   [U] : Update            |");
            System.out.println("|   [D] : Delete            |");
            System.out.println("|   [X] : Exit              |");
            System.out.println("=============================");
            System.out.print("Pilih menu: ");
            String choice = scanner.nextLine();  // Membaca pilihan menu dari pengguna

            // Switch case untuk memproses pilihan menu
            switch (choice.toUpperCase()) {
                case "C":
                    // Meminta input data mahasiswa baru dari pengguna
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Alamat: ");
                    String alamat = scanner.nextLine();
                    System.out.print("Masukkan Semester: ");
                    int semester = Integer.parseInt(scanner.nextLine());
                    System.out.print("Masukkan SKS: ");
                    int sks = Integer.parseInt(scanner.nextLine());
                    System.out.print("Masukkan IPK: ");
                    double ipk = Double.parseDouble(scanner.nextLine());

                    // Membuat objek Mahasiswa baru dan menambahkannya ke dalam list
                    Mahasiswa newMahasiswa = new Mahasiswa(nim, nama, alamat, semester, sks, ipk);
                    crudOperations.createMahasiswa(newMahasiswa);
                    System.out.println("Data berhasil ditambahkan!");
                    break;

                case "R":
                    // Menampilkan semua data mahasiswa
                    System.out.println("Daftar Mahasiswa:");
                    for (Mahasiswa student : crudOperations.readMahasiswas()) {
                        System.out.println(student);
                    }
                    break;

                case "U":
                    // Meminta input NIM mahasiswa yang akan diupdate
                    System.out.print("Masukkan NIM yang akan diupdate: ");
                    String updateNim = scanner.nextLine();
                    // Meminta input data baru dari pengguna
                    System.out.print("Masukkan Nama baru: ");
                    String updateNama = scanner.nextLine();
                    System.out.print("Masukkan Alamat baru: ");
                    String updateAlamat = scanner.nextLine();
                    System.out.print("Masukkan Semester baru: ");
                    int updateSemester = Integer.parseInt(scanner.nextLine());
                    System.out.print("Masukkan SKS baru: ");
                    int updateSks = Integer.parseInt(scanner.nextLine());
                    System.out.print("Masukkan IPK baru: ");
                    double updateIpk = Double.parseDouble(scanner.nextLine());

                    // Membuat objek Mahasiswa baru dengan data yang diupdate
                    Mahasiswa updatedMahasiswa = new Mahasiswa(updateNim, updateNama, updateAlamat, updateSemester, updateSks, updateIpk);
                    crudOperations.updateMahasiswa(updateNim, updatedMahasiswa);
                    System.out.println("Data berhasil diupdate!");
                    break;

                case "D":
                    // Meminta input NIM mahasiswa yang akan dihapus
                    System.out.print("Masukkan NIM yang akan dihapus: ");
                    String deleteNim = scanner.nextLine();
                    crudOperations.deleteMahasiswa(deleteNim);
                    System.out.println("Data berhasil dihapus!");
                    break;

                case "X":
                    // Menghentikan aplikasi
                    running = false;
                    System.out.println("Aplikasi dihentikan.");
                    break;

                default:
                    // Menampilkan pesan jika pilihan tidak valid
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }

        scanner.close();  // Menutup Scanner
    }
    
} 


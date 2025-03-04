
package tugasmandiri;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class OperasiCrud {
     // Path file .csv yang digunakan sebagai database
    private static final String FILE_PATH = "database.csv";
    // List untuk menyimpan data mahasiswa
    private List<Mahasiswa> mhs;

    // Constructor untuk inisialisasi CRUDOperations
    public OperasiCrud() {
        mhs = new ArrayList<>();
        loadDataFromFile();  // Memuat data dari file saat objek dibuat
    }

    // Method untuk memuat data dari file .csv ke dalam list mhs
    private void loadDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            // Membaca setiap baris dari file
            while ((line = reader.readLine()) != null) {
                // Memisahkan data berdasarkan koma
                String[] data = line.split(",");
                // Membuat objek Mahasiswa dari data yang dibaca
                Mahasiswa mahasiswa = new Mahasiswa(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Double.parseDouble(data[5]));
                // Menambahkan objek Mahasiswa ke dalam list
                mhs.add(mahasiswa);
            }
        } catch (IOException e) {
            // Jika file tidak ditemukan, buat file baru
            System.out.println("File tidak ditemukan, membuat file baru...");
        }
    }

    // Method untuk menyimpan data dari list mhs ke file .csv
    private void saveDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            // Menulis setiap objek Mahasiswa ke dalam file
            for (Mahasiswa student : mhs) {
                writer.write(student.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method untuk menambahkan data mahasiswa baru
    public void createMahasiswa(Mahasiswa student) {
        mhs.add(student);  // Menambahkan objek Mahasiswa ke list
        saveDataToFile();       // Menyimpan perubahan ke file
    }

    // Method untuk membaca semua data mahasiswa
    public List<Mahasiswa> readMahasiswas() {
        return mhs;  // Mengembalikan list mhs
    }

    // Method untuk mengupdate data mahasiswa berdasarkan NIM
    public void updateMahasiswa(String nim, Mahasiswa updatedMahasiswa) {
        for (int i = 0; i < mhs.size(); i++) {
            // Mencari mahasiswa dengan NIM yang sesuai
            if (mhs.get(i).getNim().equals(nim)) {
                mhs.set(i, updatedMahasiswa);  // Mengupdate data mahasiswa
                saveDataToFile();                   // Menyimpan perubahan ke file
                break;
            }
        }
    }

    // Method untuk menghapus data mahasiswa berdasarkan NIM
    public void deleteMahasiswa(String nim) {
        mhs.removeIf(student -> student.getNim().equals(nim));  // Menghapus mahasiswa dengan NIM yang sesuai
        saveDataToFile();                                           // Menyimpan perubahan ke file
    }
    
}


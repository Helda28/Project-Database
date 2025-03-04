
package tugasmandiri;


public class Mahasiswa {

    private String nim;
    private String nama;
    private String alamat;
    private int semester;
    private int sks;
    private double ipk;

    public Mahasiswa(String nim, String nama, String alamat, int semester, int sks, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
        this.semester = semester;
        this.sks = sks;
        this.ipk = ipk;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

}


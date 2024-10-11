
class Kue {

    private String nama;
    private int harga;


    public Kue(String nama, int harga) {
        this.nama = nama;  
        this.harga = harga;  
    }

    
    public String getNama() {
        return nama;  
    }


    public void setNama(String nama) {
        this.nama = nama;  
    }

    
    public int getHarga() {
        return harga;
    }


    public void setHarga(int harga) {
        this.harga = harga; 
    }

    
    public String info() {
        return "Kue " + nama + ", dengan harga " + harga + "."; 
    }
}


class Topping {
    protected String topping;

    public Topping(String topping) {
        this.topping = topping;  
    }
    public String deskripsiTopping() {
        return "Dilengkapi dengan topping " + topping + ".";  
    }
}

 
class Roti extends Kue {
    private String isian;

    
    public Roti(String nama, int harga, String topping, String isian) {
        super(nama, harga); 
        this.isian = isian;  
    }

    @Override
    public String info() {
        return "Roti " + getNama() + ", harga " + getHarga() + ", isian " + isian + ", topping " + topping() + ".";
    }

    public int hargaTotal(int tambahanTopping) {
        return getHarga() + tambahanTopping;  // Menambahkan biaya untuk topping tambahan
    }

    public int hargaTotal() {
        return getHarga();  // Jika tidak ada topping tambahan, hanya mengembalikan harga asli
    }
}

// Kelas Anak 2 yang menginduk ke Kue dan Topping
class KueTart extends Kue {
    private int ukuran;

    // Constructor
    public KueTart(String nama, int harga, String topping, int ukuran) {
        super(nama, harga);  // Memanggil konstruktor kelas induk Kue
        this.ukuran = ukuran;  // Menyimpan ukuran kue tart
    }

    // Overriding method info dari Kue
    @Override
    public String info() {
        return "Kue Tart " + getNama() + ", harga " + getHarga() + ", ukuran " + ukuran + " cm, topping " + topping() + ".";  // Menampilkan informasi tentang kue tart
    }

    // Method overloading untuk menghitung harga dengan ukuran tambahan
    public int hargaTotal(int tambahanUkuran) {
        return getHarga() + (tambahanUkuran * 2000);  // Menghitung harga berdasarkan tambahan ukuran kue
    }
}

// Kelas Anak 3 yang menginduk ke Kue dan Topping
class Donat extends Kue {
    private int jumlahLubang;

    
    public Donat(String nama, int harga, String topping, int jumlahLubang) {
        super(nama, harga);  // Memanggil konstruktor kelas induk Kue
        this.jumlahLubang = jumlahLubang;  // Menyimpan jumlah lubang pada donat
    }

    // Overriding method info dari Kue
    @Override
    public String info() {
        return "Donat " + getNama() + ", harga " + getHarga() + ", jumlah lubang " + jumlahLubang + ", topping " + topping() + ".";  // Menampilkan informasi tentang donat
    }

    // Method overloading untuk menghitung harga dengan tambahan lubang
    public int hargaTotal(int tambahanLubang) {
        return getHarga() + (tambahanLubang * 500);  // Menghitung harga berdasarkan jumlah lubang tambahan
    }
}

// Kelas Main
public class MainProgram {
    public static void main(String[] args) {
        // Membuat objek roti, kue tart, dan donat
        Roti roti = new Roti("Roti Coklat", 10000, "Coklat", "Keju");  // Membuat objek Roti
        KueTart kueTart = new KueTart("Kue Ulang Tahun", 150000, "Krim", 20);  // Membuat objek Kue Tart
        Donat donat = new Donat("Donat Gula", 5000, "Gula Halus", 1);  // Membuat objek Donat

        // Menampilkan informasi dengan polymorphism
        Kue[] kueList = {roti, kueTart, donat};  // Membuat array berisi objek-objek kue

        for (Kue kue : kueList) {
            System.out.println(kue.info());  // Menampilkan info dari setiap objek kue
        }
    }
}
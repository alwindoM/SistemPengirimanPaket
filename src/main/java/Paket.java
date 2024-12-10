import java.util.Scanner;

abstract class LayananPengiriman 
{
    public abstract double hitungBiaya();
    public abstract String estimasiWaktu();
}

// Kelas turunan untuk Pengiriman Cepat
class PengirimanCepat extends LayananPengiriman 
{
    private double berat; // dalam kg

    public PengirimanCepat(double berat) 
    {
        this.berat = berat;
    }

    @Override
    public double hitungBiaya() 
    {
        return berat * 1000; // Biaya per kg untuk pengiriman cepat
    }

    @Override
    public String estimasiWaktu() 
    {
        return "1-2 hari kerja";
    }
}

// Kelas turunan untuk Pengiriman Reguler
class PengirimanReguler extends LayananPengiriman 
{
    private double berat; // dalam kg

    public PengirimanReguler(double berat)
    {
        this.berat = berat;
    }

    @Override
    public double hitungBiaya()
    {
        return berat * 500; // Biaya per kg untuk pengiriman reguler
    }

    @Override
    public String estimasiWaktu()
    {
        return "3-5 hari kerja";
    }
}

// Kelas turunan untuk Pengiriman Internasional
class PengirimanInternasional extends LayananPengiriman 
{
    private double berat; // dalam kg

    public PengirimanInternasional(double berat) 
    {
        this.berat = berat;
    }

    @Override
    public double hitungBiaya() 
    {
        return berat * 2000; // Biaya per kg untuk pengiriman internasional
    }

    @Override
    public String estimasiWaktu() 
    {
        return "7-14 hari kerja";
    }
}

// Kelas utama untuk demonstrasi
public class Paket 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan nama barang: ");
        String namaBarang = scanner.nextLine();
        
        System.out.print("Masukkan berat barang (kg): ");
        double beratBarang = scanner.nextDouble();
        
        LayananPengiriman[] pengiriman = new LayananPengiriman[3];
        pengiriman[0] = new PengirimanCepat(beratBarang); // Pengiriman Cepat
        pengiriman[1] = new PengirimanReguler(beratBarang); // Pengiriman Reguler
        pengiriman[2] = new PengirimanInternasional(beratBarang); // Pengiriman Internasional

        System.out.println("\nInformasi Pengiriman untuk barang: " + namaBarang);
        for (LayananPengiriman layanan : pengiriman)
        {
            System.out.println("Biaya: Rp " + layanan.hitungBiaya());
            System.out.println("Estimasi Waktu: " + layanan.estimasiWaktu());
            System.out.println();
        }

        scanner.close();
    }
}
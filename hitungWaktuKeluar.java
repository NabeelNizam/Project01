import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class hitungWaktuKeluar{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Proses Input
        System.out.println("Masukkan Nama Perwakilan : ");
        String namaPerwakilan = input.next();
        System.out.println("Masukkan NIM : ");
        String nim = input.next();
        System.out.println("Selamat Datang " +namaPerwakilan);

        System.out.println("Masukkan ruangan yang ingin anda gunakan : ");
        String ruangan = input.next();

        System.out.println("Masukkan waktu (jam) : ");
        int jam = input.nextInt();
        System.out.println("Masukkan waktu(Menit) : ");
        int menit = input.nextInt();

        System.out.println("INPUT JAM HARUS DIBAWAH 24!");
        System.out.println("INPUT WAKTU HARUS DIBAWAH 60");
        System.out.println("Masukkan durasi (Jam) : ");
        int durasijam = input.nextInt();
        System.out.println("Masukkan durasi (Menit) : ");
        int durasiMenit = input.nextInt();

        System.out.println("Jumlah siswa yang ingin menggunakan ruangan : ");
        int jumlah = input.nextInt();
        boolean jumlahMaksimal = jumlah <=30;

        //Perhitungan waktu keluar
        int menitkeluar = menit+durasiMenit;
        int jamkeluar = jam+durasijam;

        //Hasil Akhir
        System.out.println("Atas Nama : " +namaPerwakilan);
        System.out.println("Menggunakan Ruangan " +ruangan);
        System.out.println("Dengan jumlah orang " +jumlah);
        System.out.println("Masuk pada pukul " +jam + "." + menit);
        System.out.println("Dan keluar pada pukul " + jamkeluar +"." +menitkeluar);

    }
}
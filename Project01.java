import java.util.Scanner;

public class Project01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Membuat INPUT
        System.out.print("Masukkan nama perwakilan : ");
        String namaPerwakilan = scanner.nextLine();
        System.out.print("Masukkan nim : ");
        String nim = scanner.nextLine();
        System.out.println("\nHalo " + namaPerwakilan + " dengan NIM " + nim  + " \nKira - kira mau di ruangan mana nih?" );

        System.out.print("Masukkan Nama ruangan : ");
        String ruangan = scanner.nextLine();

        System.out.print("Masukkan waktu (Jam): ");
        int waktuJam = scanner.nextInt();
        System.out.print("Masukkan waktu (Menit): ");
        int waktuMenit = scanner.nextInt();

        System.out.println("!! INPUT WAKTU UNTUK JAM JIKA DIJUMLAHKAN DIBAWAH 24 !!");
        System.out.println("!! INPUT WAKTU UNTUK MENIT JIKA DIJUMLAHKAN DIBAWAH 60 !!");
        System.out.println("!! CONTOH JIKA ANDA MENGGUNAKAN RUANGAN 90 MENIT MAKA ISI 1 JAM 30 MENIT !!");
        System.out.print("Lama penggunaan ruangan (Jam): " );
        int durasiJam = scanner.nextInt();
        System.out.print("Lama penggunaan ruangan (Menit): " );
        int durasi = scanner.nextInt();

        System.out.print("jumlah orang : " );
        int orang = scanner.nextInt();
        boolean jumlahMaksimal = orang <= 30; 

        //Perhitungan
        int menitKeluar = waktuMenit + durasi;
        int jamKeluar = waktuJam + durasiJam;
        //int jam,menit;
       
        
        //Membuat printoutnya
        System.out.print("Atas nama : " + namaPerwakilan);
        System.out.print("\nMenggunakan ruangan : " + ruangan);
        System.out.print("\nDengan jumlah orang :" + orang + "/" + jumlahMaksimal);
        System.out.print("\nKalian masuk pada pukul: " + waktuJam + ":" + waktuMenit);
        System.out.print("\nKalian keluar pukul: " + jamKeluar + ":" + menitKeluar );

        scanner.close();
    }
}

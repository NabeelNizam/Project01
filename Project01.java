import java.util.Scanner;

public class Project01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Membuat input
        System.out.print("Masukkan nama perwakilan : ");
        String namaPerwakilan = scanner.nextLine();
        System.out.print("Masukkan Nama ruangan : ");
        String ruangan = scanner.nextLine();
        System.out.print("Masukkan waktu (Jam): ");
        int waktuJam = scanner.nextInt();
        System.out.print("Masukkan waktu (Menit): ");
        int waktuMenit = scanner.nextInt();
        System.out.print("Lama penggunaan ruangan (Menit): " );
        int durasi = scanner.nextInt();

        System.out.print("jumlah orang : " );
        int orang = scanner.nextInt();
        boolean jumlahMaksimal = orang <= 30; 

        //Perhitungan
        int menitKeluar = waktuMenit + durasi;
        int jam,menit;
        if (menitKeluar > 60) {
            jam = menitKeluar / 60;
            jam = jam + waktuJam;
            menit = menitKeluar % 60;
        } else {
            jam = waktuJam;
            menit = menitKeluar;
        }
        
        //Membuat printoutnya
        System.out.print("Atas nama : " + namaPerwakilan);
        System.out.print("\nMenggunakan ruangan : " + ruangan);
        System.out.print("\nDengan jumlah orang :" + orang + "/" + jumlahMaksimal);
        System.out.print("\nKalian masuk pada pukul: " + waktuJam + ":" + waktuMenit);
        System.out.print("\nKalian keluar pukul: " + jam + ":" + menit );

        scanner.close();
    }
}

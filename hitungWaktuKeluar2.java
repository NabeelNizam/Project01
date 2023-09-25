import java.util.Scanner;
public class hitungWaktuKeluar2{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Proses Input                      
        System.out.print("Masukkan Nama Perwakilan : ");
        String namaPerwakilan = input.next();
        System.out.print("Masukkan NIM : ");
        String nim = input.next();
        System.out.println("Selamat Datang " +namaPerwakilan);

        System.out.println("Masukkan ruangan yang ingin anda gunakan : ");
        String ruangan = input.next();

        System.out.print("Masukkan waktu (jam) : ");
        int jam = input.nextInt();
        System.out.print("Masukkan waktu (Menit) : ");
        int menit = input.nextInt();

        System.out.println("INPUT JAM HARUS DIBAWAH 24!");
        System.out.println("INPUT MENIT HARUS DIBAWAH 60!");
        System.out.print("Masukkan durasi (Jam) : ");
        int durasijam = input.nextInt();
        System.out.print("Masukkan durasi (Menit) : ");
        int durasiMenit = input.nextInt();

        System.out.print("Jumlah siswa yang ingin menggunakan ruangan : ");
        int jumlah = input.nextInt();
        if(jumlah >30){
            System.out.println("Ruangan Tidak Muat");
            
        }else{
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
}
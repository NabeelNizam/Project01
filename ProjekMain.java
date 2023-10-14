import java.util.Scanner;

public class ProjekMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Membuat Fitur Login
        String username,pin;
        System.out.print("==========================================================================================================================================");
        System.out.println("                                    SELAMAT DATANG DI SISTEM RUANG KELAS POLINEMA!!                                                                                                     ");
        System.out.print("==========================================================================================================================================");
        System.out.print("\nApakah anda warga POLINEMA? (yes/no) : ");
        String jawaban = scanner.next();

        //JIKA JAWABAN YES
        int attempts = 0, maxattempts=3;
        while (attempts<maxattempts) {
            if(jawaban.equals("yes")){
            System.out.print("Masukkan Username (POLINEMA): ");
            username = scanner.next();
            System.out.print("Masukkan PIN (12345): ");
            pin = scanner.next();

                if(username.equals("POLINEMA")&& pin.equals("12345")){
                System.out.println("Selamat Datang Warga POLINEMA :p");
                } else{
                System.out.println("Username atau PIN anda salah");
                attempts++;
                continue;
                }
            System.out.print("Masukkan waktu (Jam): ");
            int waktuJam = scanner.nextInt();
            System.out.print("Masukkan waktu (Menit): ");
            int waktuMenit = scanner.nextInt();
            System.out.print("Lama penggunaan ruangan (Menit): " );
            int durasi = scanner.nextInt();
            System.out.print("Berapa jumlah orang yang ingin masuk : " );
            int orang = scanner.nextInt();
            if (orang<=30) {
                System.out.print("Kapasitas Ruangan Mencukupi");
            }else{
                System.out.print("Kapasitas Ruangan Tidak Mencukupi, Silahkan Mencari Ruangan Lain");
            }

            int menitKeluar = waktuMenit + durasi, menitbi,jambi;
            int jam,menit,jamAwal;
            if (menitKeluar >= 60) {
            jamAwal = menitKeluar / 60;
            jam = jamAwal + waktuJam;
            menit = menitKeluar % 60;
            
            jambi=durasi/60;
            menitbi = durasi % 60;
            System.out.print("\nAnda menggunakan ruangan selama " + jambi + " jam " + menitbi + " menit ");
            } else {
            jam = waktuJam;
            menit = menitKeluar;
            }
            System.out.print("\nKalian masuk pada pukul: " + waktuJam + ":" + waktuMenit);
            if (menit==0) {
                System.out.print("\nKalian keluar pukul: " + jam + ":" + menit + "0");
            }else{
                System.out.print("\nKalian keluar pukul: " + jam + ":" + menit);
            }
        
            
            
            //JIKA JAWABAN NO
        } else if (jawaban.equals("no")){
            System.out.println("Penggunaan gedung akan dikenakan biaya per jamnya dan juga akan ada biaya untuk kebersihan dan operasional lainnya");
            System.out.print("Masukkan Username (GUEST): ");
            username = scanner.next();
            System.out.print("Masukkan PIN (4567): ");
            pin = scanner.next();
            if(username.equals("GUEST")&& pin.equals("4567")){
                System.out.println("Selamat Datang di POLINEMA :p");
                } else{
                System.out.println("Username atau PIN anda salah");
                attempts++;
                continue;
                }

            System.out.print("Masukkan waktu (Jam): ");
            int waktuJam = scanner.nextInt();
            System.out.print("Masukkan waktu (Menit): ");
            int waktuMenit = scanner.nextInt();
            System.out.print("Lama penggunaan ruangan (Menit): " );
            int durasi = scanner.nextInt();
            System.out.print("Berapa jumlah orang yang ingin masuk : " );
            int orang = scanner.nextInt();
            if (orang<=30) {
                System.out.print("Kapasitas Ruangan Mencukupi");
            }else{
                System.out.print("Kapasitas Ruangan Tidak Mencukupi, Silahkan Mencari Ruangan Lain");
            }

            int menitKeluar = waktuMenit + durasi, menitbi,jambi;
            int jam,menit,jamAwal, biaya;
            if (menitKeluar >= 60) {
            jamAwal = menitKeluar / 60;
            jam = jamAwal + waktuJam;
            menit = menitKeluar % 60;

            menitbi = durasi %60;
            jambi = durasi / 60;
            biaya = (jamAwal * 100000) + 100000;
            System.out.print("\nAnda menggunakan ruangan selama " + jambi + " jam " + menitbi + " menit");
            System.out.print("\nJumlah biaya yang harus anda bayarkan " + biaya);
            } else {
            jam = waktuJam;
            menit = menitKeluar;
            } 
            if (menit==0) {
                System.out.print("\nKalian keluar pukul: " + jam + ":" + menit + "0");
            }else{
                System.out.print("\nKalian keluar pukul: " + jam + ":" + menit);
            }   
            
        } else{
            System.out.println("Mohon mengisi sesuai opsi yang kami berikan");
        }
    } if(attempts>=maxattempts){
        System.out.println("Maaf anda terlalu banyak mencoba, tunggu beberapa saat dan coba lagi");
        System.exit(1);

        //TAHAP VERIFIKASI ULANG
        }else{
        System.out.print("\nMasukan Nama Perwakilan : ");
        String nama = scanner.next();
        System.out.print("Masukkan Nama ruangan : ");
        String ruangan = scanner.next();
        System.out.print("Masukkan Acara apa yang anda lakukan : ");
        String keperluan = scanner.next();
        System.out.print("Masukkan waktu masuk anda kembali (Jam:Menit): ");
        String verifMasuk = scanner.next();
        System.out.print("Masukkan waktu keluar anda kembali (Jam:Menit): ");
        String verifKeluar = scanner.next();

        System.out.print("\nAtas nama : " + nama);
        System.out.print("\nMenggunakan ruangan : " + ruangan);
        System.out.print("\nDalam Rangka : " + keperluan);
        System.out.print("\nAnda masuk pada pukul : " + verifMasuk);
        System.out.print("\nDan akan keluar pada pukul : " + verifKeluar);
        System.out.print("\nSelamat menikmati ruangan :) ");
        
   
        scanner.close();
        } 
    }
    
}
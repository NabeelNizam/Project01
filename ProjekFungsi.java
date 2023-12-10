import java.util.Scanner;

public class ProjekFungsi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nApakah anda warga POLINEMA? (yes/no)");
        System.out.print("\nAtau mungkin anda hanya mau reservasi? (Res) :");
        String jawaban = sc.next();
        String nama,ruangan;
        //
        login(sc, jawaban);
        verifRuangan(nama, ruangan);
        //
        System.out.print("Masukkan waktu (Jam): ");
        int waktuJam = sc.nextInt();
        System.out.print("Masukkan waktu (Menit): ");
        int waktuMenit = sc.nextInt();
        System.out.print("Lama penggunaan ruangan (Menit): " );
        int durasi = sc.nextInt();
        //
        
        perhitunganWaktu(waktuJam, waktuMenit, durasi, jawaban);

        
        verifUlang(jawaban, jawaban);

    }
    public static boolean login(Scanner sc, String jawaban) {
        String username, pin;
        if(jawaban.equalsIgnoreCase("yes")){
        System.out.print("Masukkan username (POLINEMA): ");
        username = sc.next();
        System.out.print("Masukkan PIN (12345): ");
        pin = sc.next();
      
        if (username.equals("POLINEMA") && pin.equals("12345")) {
          return true;

        } else {
            System.exit(0);
          return false;
        }
     }else if(jawaban.equalsIgnoreCase("no")){
        System.out.println("Penggunaan gedung akan dikenakan biaya per jamnya dan juga akan ada biaya untuk kebersihan dan operasional lainnya");
            System.out.print("Masukkan Username (GUEST): ");
            username = sc.next();
            System.out.print("Masukkan PIN (4567): ");
            pin = sc.next();
            if(username.equals("GUEST")&& pin.equals("4567")){
                System.out.println("Selamat Datang di POLINEMA :p");
                return true;
            }else {
                System.exit(0);
                return false;
            }
     }else
        if (jawaban.equalsIgnoreCase("Res")) {
            
            int kapasitas = 10; // Misalnya, kapasitas maksimum 10 reservasi
            String[] pemesan = new String[kapasitas];
            String[] tanggal = new String[kapasitas];
            String[] ruangKelas = new String[kapasitas];
            int jumlahReservasi = 0;
            
    
            while (true) {
                System.out.println("Pilih tindakan:");
                System.out.println("1. Tambah Reservasi");
                System.out.println("2. Lihat Reservasi");
                System.out.println("3. Keluar");
    
                int pilihan = sc.nextInt();
                sc.nextLine(); 
    
                switch (pilihan) {
                    case 1:
                        if (jumlahReservasi < kapasitas) {
                            System.out.print("Masukkan nama pemesan: ");
                            pemesan[jumlahReservasi] = sc.nextLine();
                            System.out.print("Masukkan tanggal (contoh: 2023-11-01): ");
                            tanggal[jumlahReservasi] = sc.nextLine();
                            System.out.print("Masukkan ruang kelas: ");
                            ruangKelas[jumlahReservasi] = sc.nextLine();
                            jumlahReservasi++;
                            System.out.println("Reservasi berhasil ditambahkan.");
                        } else {
                            System.out.println("Kapasitas reservasi penuh.");
                        }
                        break;
    
                    case 2:
                        if (jumlahReservasi > 0) {
                            System.out.println("Daftar Reservasi:");
                            for (int i = 0; i < jumlahReservasi; i++) {
                                System.out.println("Pemesan: " + pemesan[i] + ", Tanggal: " + tanggal[i] + ", Ruang Kelas: " + ruangKelas[i]);
                            }
                        } else {
                            System.out.println("Tidak ada reservasi.");
                        }
                        break;
    
                    case 3:
                        System.out.println("Terima kasih! Sampai jumpa!");
                        System.exit(0);
    
                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                    }
             }
        }else{
        System.out.println("Masukkan sesuai input");
        return false;
        } 
    }

    public static int perhitunganWaktu(int waktuJam, int waktuMenit, int durasi, String jawaban){
        if (jawaban.equalsIgnoreCase("yes")) {
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
            if(waktuMenit==0){
                System.out.print("\nKalian masuk pada pukul: " + waktuJam + ":" + waktuMenit+"0");
            }else{
                System.out.print("\nKalian masuk pada pukul: " + waktuJam + ":" + waktuMenit);
            }
            
            if (menit==0) {
                System.out.print("\nKalian keluar pukul: " + jam + ":" + menit + "0");
            }else{
                System.out.print("\nKalian keluar pukul: " + jam + ":" + menit);
            }
        } else if (jawaban.equalsIgnoreCase("no")) {
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
        }
        return 0;
    }

    public static void verifRuangan(String nama, String ruangan){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.print("Masukan Nama Perwakilan : ");
        nama = scanner.next();
        System.out.print("Masukkan Nama ruangan : ");
        ruangan = scanner.next();
        rekomendasiRuangan(ruangan);
        scanner.close();
    }

    public static void verifUlang(String nama,String ruangan){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Acara apa yang anda lakukan : ");
        String keperluan = scanner.next();
        System.out.print("Masukkan waktu masuk anda kembali (Jam:Menit): ");
        String verifMasuk = scanner.next();
        System.out.print("Masukkan waktu keluar anda kembali (Jam:Menit): ");
        String verifKeluar = scanner.next();

        System.out.print("==============================================================================================================");
        System.out.print("                                    STRUK ANDA!!                                                                                                     ");
        System.out.print("================================================================================================================");
        System.out.print("\nAtas nama : " + nama);
        System.out.print("\nMenggunakan ruangan : " + ruangan);
        System.out.print("\nDalam Rangka : " + keperluan);
        System.out.print("\nAnda masuk pada pukul : " + verifMasuk);
        System.out.print("\nDan akan keluar pada pukul : " + verifKeluar);
        System.out.print("\nSelamat menikmati ruangan :) ");
        scanner.close();
    }

    public static void rekomendasiRuangan (String ruangan){
        String[] ruanganPengganti = {"LSI1","LSI2","LSI3","RT04","RT05","RT06"};
        String[] ruanganTerpakai  = {"RT01","RT02","RT03","LPY1","LPY2","LPY3"};

        for(int i = 0;i<ruanganTerpakai.length;i++){
            if(ruangan==ruanganTerpakai[i]){
                System.out.print("Ruangan sedang dipakai");
                System.out.print("Kami merekomendasikan ruangan " + ruanganPengganti[i] + " sebagai ruangan pengganti");
                break;
            }
        }
    }

}
    

import java.util.Scanner;
public class percobaanAdmin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] hasil = new String[3];
        String[] ruanganTerpakai = {"RT06", "LSI1", "RT07"};
        String[] ruanganPengganti = {"RT04", "LSI3", "RT03"};

        System.out.println("Mohon maaf ada sebelunya beberapa ruangan yang telah digunakan diantaranya :");
        for (int i = 0; i < ruanganTerpakai.length; i++) {
            System.out.println("Ruangan yang terpakai " + ruanganTerpakai[i] + " akan digantikan dengan ruangan " + ruanganPengganti[i]);
        }
        System.out.println();
        System.out.println("\nApakah anda warga POLINEMA? (yes/no/admin)");
        System.out.print("Atau mungkin anda hanya mau reservasi? (Res) : ");
        
        String jawaban = sc.next();
        login(sc, jawaban, hasil);
        rekomendasiRuangan(hasil, jawaban, ruanganTerpakai, ruanganPengganti);
        mencetakStruk(hasil, ruanganPengganti, jawaban);
    }

    public static void pengisianWaktu(String jawaban, String[] hasil){
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan waktu (Jam): ");
        int waktuJam = sc.nextInt();
        System.out.print("Masukkan waktu (Menit): ");
        int waktuMenit = sc.nextInt();
        System.out.print("Lama penggunaan ruangan (Menit): ");
        int durasi = sc.nextInt();

        perhitunganWaktu(waktuJam, waktuMenit, durasi, jawaban, hasil);
    }

    public static boolean login(Scanner sc, String jawaban, String[] hasil ) {
        String username, pin,nama,ruangan;
        int attempts = 0, maxattempts=3;
    while (attempts<maxattempts) {
         if (jawaban.equalsIgnoreCase("admin")) {
            System.out.print("Masukkan username (admin): ");
            username = sc.next();
            sc.nextLine();
            System.out.print("Masukkan PIN (POLINEMA): ");
            pin = sc.next();
            if (username.equals("admin")&& pin.equals("POLINEMA")) {
                adminFunction(hasil, jawaban);
                break;
            }
        }
        
        if (jawaban.equalsIgnoreCase("yes")) {
            System.out.println();
            System.out.print("Masukkan username (POLINEMA): ");
            username = sc.next();
            System.out.print("Masukkan PIN (12345): ");
            pin = sc.next();

            if (username.equals("POLINEMA") && pin.equals("12345")) {
                System.out.println();
                System.out.print("Masukan Nama Perwakilan : ");
                nama = sc.next();
                System.out.print("Masukkan Nama ruangan : ");
                ruangan = sc.next();
                hasil[0] = nama;
                hasil[1] = ruangan;
                pengisianWaktu(jawaban, hasil);
                return true;
            } 
        } else 
        
        if (jawaban.equalsIgnoreCase("no")) {
            System.out.println();
            System.out.println("Penggunaan gedung akan dikenakan biaya per jamnya dan juga akan ada biaya untuk kebersihan dan operasional lainnya");
            System.out.print("Masukkan Username (GUEST): ");
            username = sc.next();
            System.out.print("Masukkan PIN (4567): ");
            pin = sc.next();
            if (username.equals("GUEST") && pin.equals("4567")) {
                System.out.println("Selamat Datang di POLINEMA :p");    
                System.out.print("Masukan Nama Perwakilan : ");
                nama = sc.next();
                System.out.print("Masukkan Nama ruangan : ");
                ruangan = sc.next();
                hasil[0] = nama;
                hasil[1] = ruangan;
                pengisianWaktu(jawaban, hasil);
                return true;
            } 
        }
        attempts++;
    } if (attempts>=maxattempts) {
        System.exit(0);;
    }
            if (jawaban.equalsIgnoreCase("Res")) {
            int kapasitas = 10;
            String[] pemesan = new String[kapasitas];
            String[] tanggal = new String[kapasitas];
            String[] ruangKelas = new String[kapasitas];
            int jumlahReservasi = 0;
            
    
            while (true) {
                System.out.println("Pilih tindakan:");
                System.out.println("1. Tambah Reservasi");
                System.out.println("2. Lihat Reservasi");
                System.out.println("3. Keluar");
                System.out.println("--------------------");
    
                int pilihan = sc.nextInt();
                sc.nextLine(); 
    
                switch (pilihan) {
                    case 1:
                        if (jumlahReservasi < kapasitas) {
                            System.out.print("Masukkan nama pemesan: ");
                            pemesan[jumlahReservasi] = sc.nextLine();
                            System.out.print("Masukkan tanggal (Hari-Bulan-Tahun, contoh: 24-02-2023): ");
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
                        System.out.println();
                        break;
    
                    case 3:
                        System.out.println("Terima kasih! Sampai jumpa!");
                        System.exit(0);
    
                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                    }
             }
             
            }
            else{
                System.out.println("Masukkan sesuai input");
                return false;
                } 
                
    }


    public static String[] perhitunganWaktu(int waktuJam, int waktuMenit, int durasi, String jawaban, String[] hasil) {
        int biaya = 0;
        if (jawaban.equalsIgnoreCase("yes")) {
            int menitKeluar = waktuMenit + durasi, menitbi, jambi;
            int jam, menit, jamAwal;
            if (menitKeluar >= 60) {
                jamAwal = menitKeluar / 60;
                jam = jamAwal + waktuJam;
                menit = menitKeluar % 60;
    
                jambi = durasi / 60;
                menitbi = durasi % 60;
                System.out.print("\nAnda menggunakan ruangan selama " + jambi + " jam " + menitbi + " menit ");
            } else {
                jam = waktuJam;
                menit = menitKeluar;
            }
            if (waktuMenit == 0) {
                System.out.print("\nKalian masuk pada pukul: " + waktuJam + ":" + waktuMenit + "0");
            } else {
                System.out.print("\nKalian masuk pada pukul: " + waktuJam + ":" + waktuMenit);
            }
    
            if (menit == 0) {
                System.out.print("\nKalian keluar pukul: " + jam + ":" + menit + "0");
            } else {
                System.out.print("\nKalian keluar pukul: " + jam + ":" + menit);
            }
        } else if (jawaban.equalsIgnoreCase("no")) {
            int menitKeluar = waktuMenit + durasi, menitbi, jambi;
            int jam, menit, jamAwal;
            if (menitKeluar >= 60) {
                jamAwal = menitKeluar / 60;
                jam = jamAwal + waktuJam;
                menit = menitKeluar % 60;
    
                menitbi = durasi % 60;
                jambi = durasi / 60;
                biaya = (jamAwal * 100000) + 100000;
                hasil[2] = Integer.toString(biaya);
                System.out.print("\nAnda menggunakan ruangan selama " + jambi + " jam " + menitbi + " menit");
                System.out.print("\nJumlah biaya yang harus anda bayarkan " + hasil[2]);
            } else {
                jam = waktuJam;
                menit = menitKeluar;
            }
            if (menit == 0) {
                System.out.print("\nKalian keluar pukul: " + jam + ":" + menit + "0");
            } else {
                System.out.print("\nKalian keluar pukul: " + jam + ":" + menit);
                System.out.println();
                System.out.println();
            }
        }
    
        return hasil;
    }
    

    

    public static void mencetakStruk(String[] hasil, String[] ruanganPengganti, String jawaban) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nMasukkan Acara apa yang anda lakukan : ");
        String keperluan = sc.nextLine();
        System.out.print("Masukkan waktu masuk anda kembali (Jam:Menit): ");
        String verifMasuk = sc.nextLine();
        System.out.print("Masukkan waktu keluar anda kembali (Jam:Menit): ");
        String verifKeluar = sc.nextLine();
        System.out.println();

        if(jawaban.equalsIgnoreCase("yes")){
        System.out.print("=============================================");
        System.out.print("\n               STRUK ANDA!!                ");
        System.out.println("=============================================");
        System.out.print("\nAtas nama : " + hasil[0]);
        System.out.print("\nMenggunakan ruangan : " + hasil[1]);
        System.out.print("\nDalam Rangka : " + keperluan);
        System.out.print("\nAnda masuk pada pukul : " + verifMasuk);
        System.out.print("\nDan akan keluar pada pukul : " + verifKeluar);
        System.out.print("\nSelamat menikmati ruangan :) ");
        System.exit(0);
    }else{
        System.out.print("=============================================");
        System.out.print("\n               STRUK ANDA!!                ");
        System.out.println("\n=============================================");
        System.out.print("\nAtas nama : " + hasil[0]);
         System.out.print("\nMenggunakan ruangan : " + hasil[1]);
        
        System.out.print("\nDalam Rangka : " + keperluan);
        System.out.print("\nAnda masuk pada pukul : " + verifMasuk);
        System.out.print("\nDan akan keluar pada pukul : " + verifKeluar);
        System.out.print("\nTotal biaya adalah : " +hasil[2]);
        System.out.print("\nSelamat menikmati ruangan :) ");
        sc.close();
        System.exit(0);
    }
    }

    public static String[] rekomendasiRuangan(String[] hasil, String jawaban,  String[]ruanganTerpakai, String[] ruanganPengganti){
        for (int i = 0; i < ruanganTerpakai.length; i++) {
            if (hasil[1].equals(ruanganTerpakai[i])) {
                hasil[1] = ruanganPengganti[i];
                System.out.println("\nRuangan " + ruanganTerpakai[i] + " sedang digunakan, kami akan otomatis memindahkan ke ruangan " + ruanganPengganti[i]);
                break;
            }
        }
        return hasil;
        
    }

    public static void adminFunction(String[] hasil, String jawaban) {
    Scanner scanner = new Scanner(System.in);
    String[] ruanganTerpakai = {"RT06", "LSI1", "RT07"};
    String[] ruanganPengganti = {"RT04", "LSI3", "RT03"};
    boolean returnToMain = true;
    String[][] riwayatTransaksi = new String[10][4];
    int transactionCount = 0;

    do {
        System.out.println("\n-- Admin Menu --");
        System.out.println("1. Lihat Ruangan Terpakai");
        System.out.println("2. Lihat Ruangan Pengganti");
        System.out.println("3. Lihat Daftar Riwayat Transaksi");
        System.out.println("4. Keluar Aplikasi");
        System.out.println("------------------------------");
        int adminChoice = scanner.nextInt();
        scanner.nextLine();

        switch (adminChoice) {
            case 1:
            System.out.println("\nRuangan Terpakai:");
            for (String ruangan : ruanganTerpakai) {
                System.out.println(ruangan);
            }
            break;

            case 2:
            System.out.println("\nRuangan Pengganti:");
            for (int i = 0; i < ruanganPengganti.length; i++) {
                System.out.println(ruanganPengganti[i]);
            }
            break;

                case 3:
                handleRiwayatTransaksi(riwayatTransaksi, transactionCount);
                break;

            case 4:
                System.exit(0);
                break;

            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }

    } while (returnToMain);

    scanner.close();
}


public static void handleRiwayatTransaksi(String[][] riwayatTransaksi, int transactionCount) {
    Scanner sc = new Scanner(System.in);

    do {
        System.out.println("\n-- Riwayat Transaksi --");
        System.out.println("1. Tambah Transaksi");
        System.out.println("2. Lihat Daftar Transaksi");
        System.out.println("3. Kembali ke Menu Admin");
        System.out.println("------------------------------");
        int adminChoice = sc.nextInt();
        sc.nextLine();

        switch (adminChoice) {
            case 1:
                addTransaksi(riwayatTransaksi, transactionCount);
                transactionCount++;
                break;

            case 2:
                printDaftarTransaksi(riwayatTransaksi, transactionCount);
                break;

            case 3:
                return;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }

    } while (true);
}

public static void addTransaksi(String[][] riwayatTransaksi, int transactionCount) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Masukkan informasi transaksi:");
    System.out.print("Pengguna: ");
    String pengguna = sc.nextLine();
    System.out.print("Ruangan: ");
    String ruangan = sc.nextLine();
    System.out.print("Waktu: ");
    String waktu = sc.nextLine();
    System.out.print("Biaya: Rp ");
    String cetakBiaya = sc.nextLine();

    // Store the transaction details in the riwayatTransaksi array
    riwayatTransaksi[transactionCount][0] = pengguna;
    riwayatTransaksi[transactionCount][1] = ruangan;
    riwayatTransaksi[transactionCount][2] = waktu;
    riwayatTransaksi[transactionCount][3] = cetakBiaya;

    System.out.println("Transaksi berhasil ditambahkan.");

}

public static void printDaftarTransaksi(String[][] riwayatTransaksi, int transactionCount) {
    System.out.println("\nDaftar Riwayat Transaksi:");
    if (transactionCount > 0) {
        for (int i = 0; i < transactionCount; i++) {
            System.out.println("Pengguna: " + riwayatTransaksi[i][0] +
                    "| Ruangan: " + riwayatTransaksi[i][1] +
                    "| Waktu: " + riwayatTransaksi[i][2] + 
                    "| Biaya: Rp" + riwayatTransaksi[i][3]);
        }
    } else {
        System.out.println("Tidak ada riwayat transaksi.");
    }

    }
}

    
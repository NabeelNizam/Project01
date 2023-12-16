import java.util.Scanner;
public class ProjectAdmin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] hasil = new String[2];
        String[][] daftarTransaksi = new String[10][5];
        String[] ruanganPengganti = new String[20];
        String[] ruanganTerpakai = new String [20];
        
        int counter = 0;
        while (counter<=10) {
        System.out.println("\nApakah anda warga POLINEMA? (yes/no/admin)");
        System.out.print("Atau mungkin anda hanya mau reservasi? (Res)");
        System.out.print("\nJika ingin keluar dari program ketik (x) : ");
        String jawaban = sc.next();
        login(sc, jawaban, hasil, 0);
            
        counter++;
        }

        
        
    }

    public static void pengisianWaktu(String jawaban){
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan waktu (Jam): ");
        int waktuJam = sc.nextInt();
        System.out.print("Masukkan waktu (Menit): ");
        int waktuMenit = sc.nextInt();
        System.out.print("Lama penggunaan ruangan (Menit): ");
        int durasi = sc.nextInt();

        perhitunganWaktu(waktuJam, waktuMenit, durasi, jawaban);
    }

    public static boolean login(Scanner sc, String jawaban, String[] hasil,int biaya ) {
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
                adminFunction(hasil, hasil, hasil, maxattempts, null, sc);
                break;
            }
        }
        
        if (jawaban.equalsIgnoreCase("yes")) {
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
                pengisianWaktu(jawaban);
                rekomendasiRuangan(ruangan, hasil, biaya, jawaban, hasil, hasil, ruangan);
                return true;
            } 
        } else 
        
        if (jawaban.equalsIgnoreCase("no")) {
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
                pengisianWaktu(jawaban);
                rekomendasiRuangan(ruangan, hasil, biaya, jawaban, hasil, hasil, ruangan);
                return true;
            } 
        }
        attempts++;
        if (attempts>=maxattempts) {

        break;
    }
    }

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
            else if (jawaban.equalsIgnoreCase("x")) {
            System.exit(0);
            }else {
                System.out.println("Masukkan sesuai input");
                return false;
                }
            return false; 
                
    }


    public static int perhitunganWaktu(int waktuJam, int waktuMenit, int durasi, String jawaban) {
        int biaya = 0;
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
            int jam,menit,jamAwal;
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
            }if(waktuMenit==0){
                System.out.print("\nKalian masuk pada pukul: " + waktuJam + ":" + waktuMenit+"0");
            }else{
                System.out.print("\nKalian masuk pada pukul: " + waktuJam + ":" + waktuMenit);
            }
            if (menit==0) {
                System.out.print("\nKalian keluar pukul: " + jam + ":" + menit + "0");
            }else{
                System.out.print("\nKalian keluar pukul: " + jam + ":" + menit);
                System.out.println();
                System.out.println();
            }

        }
        return biaya;
    }

    

    public static void mencetakStruk(String[] hasil, int indexRuangan, String[] ruanganPengganti, int biaya, String jawaban, int counter, String[][] daftarTransaksi) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nMasukkan Acara apa yang anda lakukan : ");
        String keperluan = sc.nextLine();
        System.out.print("Masukkan waktu masuk anda kembali (Jam:Menit): ");
        String verifMasuk = sc.nextLine();
        System.out.print("Masukkan waktu keluar anda kembali (Jam:Menit): ");
        String verifKeluar = sc.nextLine();
        
        if(jawaban.equalsIgnoreCase("no")){
        System.out.println();
        System.out.print("Masukan tagihan anda: Rp ");
        String verifBiaya = sc.nextLine();
        System.out.print("=============================================");
        System.out.print("\n               STRUK ANDA!!                 ");
        System.out.print("\n=============================================");
        System.out.print("\nAtas nama : " + hasil[0]);
        if (indexRuangan != -1) {
            System.out.print("\nMenggunakan ruangan : " + ruanganPengganti[indexRuangan]);
        } else {
            System.out.print("\nMenggunakan ruangan : " + hasil[1]);
        }
        System.out.print("\nDalam Rangka : " + keperluan);
        System.out.print("\nAnda masuk pada pukul : " + verifMasuk);
        System.out.print("\nDan akan keluar pada pukul : " + verifKeluar);
        System.out.print("\nTotal biaya adalah : " + verifBiaya);
        System.out.print("\nSelamat menikmati ruangan :) ");

        daftarTransaksi[counter][0] = hasil[0]; // Simpan nama
        daftarTransaksi[counter][1] = keperluan; // Simpan keperluan
        daftarTransaksi[counter][2] = verifMasuk; // Simpan waktu masuk
        daftarTransaksi[counter][3] = verifKeluar; // Simpan waktu keluar
        daftarTransaksi[counter][4] = verifBiaya; // Simpan biaya
        main(ruanganPengganti);
        }
        else{
            System.out.print("=============================================");
            System.out.print("\n               STRUK ANDA!!                                                                                                     ");
            System.out.println("=============================================");
            System.out.print("\nAtas nama : " + hasil[0]);
            if (indexRuangan != -1) {
                System.out.print("\nMenggunakan ruangan : " + ruanganPengganti[indexRuangan]);
            } else {
                System.out.print("\nMenggunakan ruangan : " + hasil[1]);
            }
            System.out.print("\nDalam Rangka : " + keperluan);
            System.out.print("\nAnda masuk pada pukul : " + verifMasuk);
            System.out.print("\nDan akan keluar pada pukul : " + verifKeluar);
            System.out.print("\nSelamat menikmati ruangan :) ");
            main(ruanganPengganti);
        }
    }


    public static String[] rekomendasiRuangan(String ruangan, String[] hasil, int biaya, String jawaban, String[] ruanganPengganti, String[] ruanganTerpakai, String ruanganTerpakaiBaru) {
        
        int indexRuangan = -1; // Menandai jika ruangan tidak ditemukan
        for (int i = 0; i < ruanganTerpakai.length; i++) {
            ruanganTerpakai[i] = ruanganTerpakaiBaru;
            String cekRuanganTerpakai = ruanganTerpakai[i];
            if (ruangan.equals(cekRuanganTerpakai)) {
                System.out.print("\nRuangan sedang dipakai");
                System.out.print("\nKami pindahkan ke ruangan " + ruanganPengganti[i] + " sebagai ruangan pengganti");
                System.out.println();
                indexRuangan = i; 
                break;
            }
        }mencetakStruk(hasil, indexRuangan, ruanganPengganti, biaya, jawaban, indexRuangan, null);
        if (indexRuangan != -1) {
            ruanganPengganti[indexRuangan] = "Ruangan pengganti yang baru"; // Ganti dengan logika yang sesuai
            mencetakStruk(hasil, indexRuangan, ruanganPengganti, biaya, jawaban, indexRuangan, null);
        } else {
            mencetakStruk(hasil, indexRuangan, ruanganPengganti, biaya, jawaban, indexRuangan, null);
        }
    
        return ruanganPengganti;
    }

    public static void adminFunction(String[] ruanganPengganti, String[] ruanganTerpakai, String[] hasil, int counter, String[][] daftarTransaksi, Scanner sc) {
        Scanner scanner = new Scanner(System.in);
        boolean returnToMain = true;
    
        do {
            System.out.println("\n-- Admin Menu --");
            System.out.println("1. Set Ruangan Terpakai");
            System.out.println("2. Set Ruangan Pengganti");
            System.out.println("3. Daftar Riwayat Transaksi");
            System.out.println("4. Kembali ke Menu Login/Keluar Aplikasi ");
            System.out.println("------------------------------");
            int adminChoice = scanner.nextInt();
            scanner.nextLine();
    
            switch (adminChoice) {
                case 1:
                    System.out.print("Masukkan ruangan yang sedang dipakai: ");
                    String ruanganTerpakaiBaru = scanner.next();
                    boolean exists = false;
                    for (String ruangan : ruanganTerpakai) {
                        if (ruangan != null && ruangan.equals(ruanganTerpakaiBaru)) {
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                        for (int i = 0; i < ruanganTerpakai.length; i++) {
                            if (ruanganTerpakai[i] == null) {
                                ruanganTerpakai[i] = ruanganTerpakaiBaru;
                                System.out.println("Ruangan " + ruanganTerpakaiBaru + " telah ditandai sebagai terpakai.");
    
                                // Memanggil rekomendasiRuangan untuk memperbarui ruanganPengganti

                                break;
                            }
                        }
                    } else {
                        System.out.println("Ruangan sudah ditandai sebagai terpakai sebelumnya.");
                    }
                    break;
    
                case 2:
                    System.out.println("Masukkan ruangan pengganti yang akan disarankan:");
                    String ruanganPenggantiBaru = scanner.next();
                    boolean existsPengganti = false;
                    for (String ruangan : ruanganPengganti) {
                        if (ruangan != null && ruangan.equals(ruanganPenggantiBaru)) {
                            existsPengganti = true;
                            break;
                        }
                    }
                    if (!existsPengganti) {
                        for (int i = 0; i < ruanganPengganti.length; i++) {
                            if (ruanganPengganti[i] == null) {
                                ruanganPengganti[i] = ruanganPenggantiBaru;
                                System.out.println("Ruangan " + ruanganPenggantiBaru + " telah ditambahkan sebagai ruangan pengganti.");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Ruangan sudah ada dalam daftar ruangan pengganti sebelumnya.");
                    }
                    break;
                case 3:
                System.out.println("Daftar Riwayat Transaksi:");
                for (int i = counter; i < counter; i++) {
                    for (int j = 0; j < daftarTransaksi[i].length; j++) {
                    System.out.print(daftarTransaksi[i][j] + "|");
                    }
                    System.out.println();
                }
                break;
                case 4:
                    System.out.println("Mau yang mana? (login/exit)");
                    Scanner input = new Scanner(System.in);
                    String answer = input.next();
                    if(answer.equalsIgnoreCase("login")){
                        returnToMain = false;
                        main(ruanganTerpakai);
                        break;
                    }else{
                        System.exit(0);                    
                    }
                    
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
    
        } while (returnToMain);
    
        scanner.close();
    }
    /* 
    public static void pemindahanRuangan(String[] ruanganPengganti, String[] ruanganTerpakai, String ruangan, String []hasil){
        for (int i = 0; i < ruanganTerpakai.length; i++) {
            String cekRuanganTerpakai = ruanganTerpakai[i];
            if (ruangan.equals(cekRuanganTerpakai)) {
                System.out.print("\nRuangan sedang dipakai");
                System.out.print("\nKami pindahkan ke ruangan " + ruanganPengganti[i] + " sebagai ruangan pengganti");
                System.out.println();
                break;
            }else{
                System.out.println("OI");
            }
        }rekomendasiRuangan(ruangan, hasil);
    }
    */
}
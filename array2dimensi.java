import java.util.Scanner;

public class array2dimensi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Membuat Fitur Login
        String username,pin;
        System.out.println("==========================================================================================================================================");
        System.out.println("                                    SELAMAT DATANG DI SISTEM RUANG KELAS POLINEMA!!                                                                                                     ");
        System.out.print("==========================================================================================================================================");
        System.out.print("\nApakah anda warga POLINEMA? (yes/no)");
        System.out.print("\nAtau mungkin anda hanya mau reservasi? (Res) :");
        String jawaban = scanner.next();


        // Array 2 dimensi untuk menyimpan informasi ruangan dan pelanggan
        String[][] ruanganPelanggan = new String[10][3]; // Misalnya, 10 ruangan dengan 3 kolom informasi (nama ruangan, nama pelanggan, dan keperluan)


        //MENU RESERVASI
         if (jawaban.equals("Res")) {
            int kapasitas = 10; // Misalnya, kapasitas maksimum 10 reservasi
            String[] pemesan = new String[kapasitas];
            String[] tanggal = new String[kapasitas];
            String[] ruangKelas = new String[kapasitas];
            int jumlahReservasi = 0;
            scanner.close();
    

        while (true) {
            System.out.println("Pilih tindakan:");
            System.out.println("1. Tambah Reservasi");
            System.out.println("2. Lihat Reservasi");
            System.out.println("3. Keluar");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    if (jumlahReservasi < kapasitas) {
                        System.out.print("Masukkan nama pemesan: ");
                        pemesan[jumlahReservasi] = scanner.nextLine();
                        System.out.print("Masukkan tanggal (contoh: 2023-11-01): ");
                        tanggal[jumlahReservasi] = scanner.nextLine();
                        System.out.print("Masukkan ruang kelas: ");
                        ruangKelas[jumlahReservasi] = scanner.nextLine();
                    

                         // Simpan informasi ruangan dan pelanggan ke dalam array 2 dimensi
                         ruanganPelanggan[jumlahReservasi][0] = ruangKelas[jumlahReservasi];
                         ruanganPelanggan[jumlahReservasi][1] = pemesan[jumlahReservasi];
                         ruanganPelanggan[jumlahReservasi][2] = "Reservasi";
                     
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

                         // Menampilkan informasi ruangan dan pelanggan dari array 2 dimensi
                         System.out.println("Informasi Ruangan dan Pelanggan:");
                         for (int i = 0; i < jumlahReservasi; i++) {
                         System.out.println("Ruang Kelas: " + ruanganPelanggan[i][0] + ", Nama Pelanggan: " + ruanganPelanggan[i][1] + ", Keperluan: " + ruanganPelanggan[i][2]);
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
         }

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
            break;


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
            System.exit(0);;
        }
        break;
    } if(attempts>=maxattempts){
        System.out.println("Maaf anda terlalu banyak mencoba, tunggu beberapa saat dan coba lagi");

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
    

    

    


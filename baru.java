import java.util.Scanner;

public class baru {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
            scanner.nextLine(); // Untuk membersihkan karakter newline (\n) dari input sebelumnya

            switch (pilihan) {
                case 1:
                    if (jumlahReservasi < kapasitas) {
                        System.out.print("Masukkan nama pemesan: ");
                        pemesan[jumlahReservasi] = scanner.nextLine();
                        System.out.print("Masukkan tanggal (contoh: 2023-11-01): ");
                        tanggal[jumlahReservasi] = scanner.nextLine();
                        System.out.print("Masukkan ruang kelas: ");
                        ruangKelas[jumlahReservasi] = scanner.nextLine();
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
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
          
    }
    
}

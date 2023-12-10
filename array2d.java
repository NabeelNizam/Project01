
import java.util.Scanner;
public class array2d {      
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        // Membuat Fitur Login
        String username, pin;
        System.out.print("==========================================================================================================================================");
        System.out.println("                                    SELAMAT DATANG DI SISTEM RUANG KELAS POLINEMA!!                                                                                                     ");
        System.out.print("==========================================================================================================================================");
        System.out.print("\nApakah anda warga POLINEMA? (yes/no) : ");
        String jawaban = sc.nextLine();

        // JIKA JAWABAN YES
        int attempts = 0, maxattempts = 3;
        while (attempts < maxattempts) {
            if (jawaban.equals("yes")) {
                // Your existing code for POLINEMA users

                // Adding 2D array for seat availability
                int rows = 5; // Number of rows (you can adjust as needed)
                int cols = 6; // Number of columns (you can adjust as needed)
                boolean[][] seatAvailability = new boolean[rows][cols];

                // Initialize all seats to be available
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        seatAvailability[i][j] = true;
                    }
                }

                // Your existing code continues...

                System.out.print("\nMasukkan baris kursi yang ingin dipesan: ");
                int selectedRow = sc.nextInt();
                System.out.print("Masukkan kolom kursi yang ingin dipesan: ");
                int selectedCol = sc.nextInt();

                if (seatAvailability[selectedRow - 1][selectedCol - 1]) {
                    System.out.println("Kursi tersedia. Selamat duduk!");
                    seatAvailability[selectedRow - 1][selectedCol - 1] = false; // Mark the seat as unavailable
                } else {
                    System.out.println("Maaf, kursi sudah dipesan. Silakan pilih kursi lain.");
                }

                // Your existing code continues...

            } else if (jawaban.equals("no")) {
                // Your existing code for GUEST users

                // Adding 2D array for seat availability (similar to the above)

                // Your existing code continues...
            } else {
                System.out.println("Mohon mengisi sesuai opsi yang kami berikan");
            }
        }

        // Rest of your code...

        sc.close();
    }

}

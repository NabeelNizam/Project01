import java.util.Scanner;

public class login3{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String username = "Caesar";
        String password = "12345";
        int percobaanMax = 3;
        int percobaan = 0;



        while (true) {
            System.out.print("Masukkan username: ");
            String enteredUsername = input.next();
            System.out.print("Masukkan password: ");
            String enteredPassword = input.next();

            if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
                System.out.println("Login berhasil!");
                break;
            } else {
                percobaan++;
                System.out.println("Login gagal. Sisa percobaan: " + (percobaanMax - percobaan));
                if (percobaan == percobaanMax) {
                    System.out.println("Anda sudah mencoba 3 kali. Apakah Anda ingin mencoba lagi? (yes/no): ");
                    String jawaban = input.next();
                    if (jawaban.equals("no")) {
                        break;
                    } else {
                        percobaan = 0; // Reset jumlah percobaan
                        percobaanMax += 3; // Menambah jumlah maksimum percobaan
                    }
                }
            }
        }

        input.close();
    }
}

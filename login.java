import java.util.Scanner;
public class login{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String username,pin;
        System.out.print("Apakah anda warga POLINEMA? (yes/no) : ");
        String jawaban = input.next();

        if(jawaban.equals("yes")){
            System.out.print("Masukkan Username (Caesar): ");
            username = input.next();
            System.out.print("Masukkan PIN (12345): ");
            pin = input.next();

                if(username.equals("Caesar")&& pin.equals("12345")){
                System.out.println("Selamat Datang Caesar :p");
                } else{
                System.out.println("Username atau PIN anda salah");
                }
        } 
        else if (jawaban.equals("no")){
            System.out.println("Penggunaan gedung akan dikenakan biaya per jamnya");
        } else{
            System.out.println("Mohon mengisi sesuai opsi yang kami berikan");
        }
        

    }
}
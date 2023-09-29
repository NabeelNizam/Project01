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
                System.out.print("Masukkan Nama Perwakilan : ");
                String namaPerwakilan = input.next();
                System.out.print("Masukkan NIM : ");
                String nim = input.next();
                System.out.println("Selamat Datang " +namaPerwakilan);

                System.out.print("Masukkan ruangan yang ingin anda gunakan : ");
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
            else{
                System.out.println("Username atau PIN anda salah");
                }
        }
        //Jika Bukan Warga POLINEMA 
        else if (jawaban.equals("no")){
            System.out.println("Penggunaan gedung akan dikenakan biaya per jamnya");
            int biaya=2000000;
            System.out.print("Masukkan ruangan yang ingin anda gunakan : ");
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
                biaya=(biaya*durasijam) + (biaya*durasiMenit/60);
                //Hasil Akhir
                System.out.println("Anda Menggunakan Ruangan " +ruangan);
                System.out.println("Dengan jumlah orang " +jumlah);
                System.out.println("Masuk pada pukul " +jam + "." + menit);
                System.out.println("Dan keluar pada pukul " + jamkeluar +"." +menitkeluar);
                System.out.println("Dikenakan biaya sebesar " + biaya);
             } 
            }else{
                System.out.println("Mohon mengisi sesuai opsi yang kami berikan");
            }
    }
}


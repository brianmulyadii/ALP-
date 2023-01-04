/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @Author Filbert Patricio & Bryan
 */
public class CariKalori {

    DecimalFormat dfrmt = new DecimalFormat("#0.00");

    public void boot() {
        String[] carikalori;
        carikalori = new String[5];

        carikalori[0] = " ****** ******* ******  *   *  * ******* *       ******* ******   *";
        carikalori[1] = "*       *     * *     * *   * *  *     * *       *     * *     *  *";
        carikalori[2] = "*       ******* ******  *   **   ******* *       *     * ******   *";
        carikalori[3] = "*       *     * *    *  *   * *  *     * *       *     * *    *   *";
        carikalori[4] = " ****** *     * *     * *   *  * *     * ******* ******* *     *  *";

        try {
            Thread.sleep(500);
            System.out.println("====================================================================");

        } catch (InterruptedException e) {

        }
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(carikalori[i]);
                Thread.sleep(500);

            }
        } catch (InterruptedException e) {

        }
        try {
            System.out.println("====================================================================");
            Thread.sleep(500);

        } catch (InterruptedException e) {

        }
        System.out.println("");
    }

    public int pilih() {
        int pilih;
        System.out.println("Menu: ");
        System.out.println("1. Menghitung kalori harian yang dibutuhkan");
        System.out.println("2. Menghitung BMI");
        System.out.println("3. Melihat daftar olahraga");
        System.out.println("4. Menambah daftar olahraga");
        System.out.println("5. Mengedit daftar olahraga");
        System.out.println("6. Menghapus daftar olahraga");
        System.out.println("7. Melihat daftar makanan ");
        System.out.println("8. Menambah daftar makanan");
        System.out.println("9. Mengedit daftar makanan");
        System.out.println("10. Menghapus daftar makanan");
        System.out.println("11. Target Kalori");
        System.out.println("12. Keluar");
        System.out.print("Masukkan pilihan: ");

        //error check pada pilihan jika tidak masuk integer
        while (!scan.hasNextInt()) {
            System.out.println("Input tidak valid !!");
            scan.next();
            System.out.print("Masukkan pilihan: ");
        }
        pilih = scan.nextInt();
        return pilih;
    }
    Scanner scan = new Scanner(System.in);

    public float kalhari() {
        float berat, tinggi, bmr, kalori;
        int umur, olahraga;
        double faktor;
        String jeniskelamin;
        System.out.print("Masukkan berat badan(Kg): ");
        while (!scan.hasNextFloat()) {
            System.out.println("Input tidak valid !!");
            scan.next();
            System.out.print("Masukkan berat badan (Kg): ");
        }
        berat = scan.nextFloat();
        System.out.print("Masukkan tinggi badan (cm): ");
        while (!scan.hasNextFloat()) {
            System.out.println("Input tidak valid !!");
            scan.next();
            System.out.print("Masukkan tinggi badan (cm): ");
        }
        tinggi = scan.nextFloat();
        System.out.print("Masukkan umur anda (tahun): ");
        while (!scan.hasNextFloat()) {
            System.out.println("Input tidak valid !!");
            scan.next();
            System.out.print("Masukkan umur anda(tahun): ");
        }
        umur = scan.nextInt();
        System.out.print("Berapa kali anda berolahraga selama seminggu: ");
        while (!scan.hasNextInt()) {
            System.out.println("Input tidak valid !!");
            scan.next();
            System.out.print("Berapa kali anda berolahraga selama seminggu: ");
        }
        olahraga = scan.nextInt();
        if (olahraga == 0) {
            faktor = 1.2;
        } else if (olahraga <= 3) {
            faktor = 1.375;
        } else if (olahraga <= 5) {
            faktor = 1.55;
        } else if (olahraga <= 7) {
            faktor = 1.725;
        } else {
            faktor = 1.9;
        }

        do {
            System.out.print("Pria atau Wanita(P/W): ");
            jeniskelamin = scan.next() + scan.nextLine();
            if ((!jeniskelamin.equalsIgnoreCase("p")) && (!jeniskelamin.equalsIgnoreCase("w"))) {
                System.out.println("Jenis kelamin tidak sesuai !");
            }
        } while ((!jeniskelamin.equalsIgnoreCase("p")) && (!jeniskelamin.equalsIgnoreCase("w")));
        System.out.println("");

        System.out.println("***************************************************************");

        if (jeniskelamin.equalsIgnoreCase("p")) {
            bmr = (float) (10 * berat + 6.25 * tinggi - 5 * umur + 5);
            kalori = (float) (bmr * faktor);
            System.out.println("*" + " " + "BMR : " + dfrmt.format(bmr) + "                                               *");
            System.out.println("*" + " " + "Kalori harian yang anda butuhkan adalah : " + dfrmt.format(kalori) + "           " + "*");
        } else {
            bmr = (float) (10 * berat + 6.25 * tinggi - 5 * umur + 5 - 161);
            kalori = (float) (bmr * faktor);
            System.out.println("*" + " " + "BMR : " + dfrmt.format(bmr) + "                                               *");
            System.out.println("Kalori harian yang anda butuhkan adalah : " + dfrmt.format(kalori) + "           " + "*");
        }
        System.out.println("***************************************************************");
        System.out.println("");

        return kalori;

    }

    public void bmi() {
        float massa, tinggi, bmi;
        System.out.println("Menghitung BMI:");
        System.out.print("Masukkan berat badan (kg): ");
        while (!scan.hasNextFloat()) {
            System.out.println("Input tidak valid !!");
            scan.next();
            System.out.print("Masukkan berat badan (kg): ");
        }
        massa = scan.nextFloat();
        System.out.print("Masukkan tinggi badan (cm) : ");
        while (!scan.hasNextFloat()) {
            System.out.println("Input tidak valid !!");
            scan.next();
            System.out.print("Masukkan tinggi badan (cm) : ");
        }
        tinggi = scan.nextFloat();
        tinggi = tinggi / 100;
        bmi = massa / (tinggi * tinggi);
        System.out.println("BMI : " + dfrmt.format(bmi));
        System.out.println("");
    }

    public ArrayList<String> daftarolahraga(ArrayList<String> olahraga) {

        System.out.println("Daftar Olahraga: ");
        for (int i = 0; i < olahraga.size(); i++) {
            System.out.println((i + 1) + ". " + olahraga.get(i));
        }
        System.out.println("");
        return olahraga;
    }

    public ArrayList<String> tambaholahraga(ArrayList<String> olahraga) {
        String tambah, ya;
        boolean lagi;
        int angka;
        System.out.println("Tambah daftar olahraga: ");
        System.out.println("Daftar Olahraga: ");
        for (int i = 0; i < olahraga.size(); i++) {
            System.out.println((i + 1) + ". " + olahraga.get(i));
        }
        System.out.println("");
        do {
            System.out.println("1. Tambah olahraga");
            System.out.println("2. Kembali ke menu awal");
            System.out.print("Pilihan: ");
            while (!scan.hasNextInt()) {
                System.out.println("Input tidak valid !!");
                scan.next();
                System.out.print("Pilihan: ");
            }
            angka = scan.nextInt();
            if (angka == 2) {
                break;
            } else if (angka != 1) {
                System.out.println("Tidak ada pilihan yang tersedia");
                break;
            }
            System.out.print("Nama olahraga: ");
            tambah = scan.next() + scan.nextLine();
            olahraga.add(tambah);
            System.out.println("Olahraga berhasil ditambahkan !!");
            System.out.println("Apakah anda ingin menambah daftar olahraga lagi ? (y/n)");
            ya = scan.next();
            if (ya.equalsIgnoreCase("y")) {
                lagi = true;
            } else {
                lagi = false;
            }
        } while (lagi);
        System.out.println("");
        return olahraga;
    }

    public ArrayList<String> editolahraga(ArrayList<String> olahraga) {
        int angka, pilih;
        String nama;
        System.out.println("Edit daftar olahraga: ");
        System.out.println("Daftar Olahraga: ");
        for (int i = 0; i < olahraga.size(); i++) {
            System.out.println((i + 1) + ". " + olahraga.get(i));
        }
        System.out.println("");
        System.out.print("Edit daftar olahraga no berapa?(pilih 0 untuk keluar): ");
        while (!scan.hasNextInt()) {
            System.out.println("Input tidak valid !!");
            scan.next();
            System.out.print("Edit daftar olahraga no berapa?(pilih 0 untuk keluar): ");
        }
        angka = scan.nextInt();
        if (angka > 0) {
            if (angka > olahraga.size()) {
                System.out.println("Tidak ada yang bisa diedit !!");
            } else {
                System.out.print("Nama olahraga: ");
                nama = scan.nextLine() + scan.nextLine();
                olahraga.set(angka - 1, nama);
                System.out.println("Olahraga berhasil diedit !!");
            }
        } 
        else if (angka < 0){
            System.out.println("Angka tidak valid !!");
        }
        System.out.println("");
        return olahraga;
    }

    public ArrayList<String> hapusolahraga(ArrayList<String> olahraga) {
        int angka, pilih;
        String nama;
        System.out.println("Hapus daftar olahraga: ");
        System.out.println("Daftar Olahraga: ");
        for (int i = 0; i < olahraga.size(); i++) {
            System.out.println((i + 1) + ". " + olahraga.get(i));
        }
        System.out.println("");
        System.out.print("Hapus daftar olahraga no berapa?(pilih 0 untuk keluar): ");
        while (!scan.hasNextInt()) {
            System.out.println("Input tidak valid !!");
            scan.next();
            System.out.print("Hapus daftar olahraga no berapa?(pilih 0 untuk keluar): ");
        }
        angka = scan.nextInt();
        if (angka > 0) {
            if (angka > olahraga.size()) {
                System.out.println("Tidak ada yang bisa dihapus !!");
            } else {
                olahraga.remove(angka - 1);
            }
        }
        else if (angka < 0){
            System.out.println("Angka tidak valid !!");
        }
        System.out.println("");
        return olahraga;
    }

    public ArrayList<String> daftarmakan(ArrayList<String> makan) {
        System.out.println("Daftar Makan: ");
        for (int i = 0; i < makan.size(); i++) {
            System.out.println((i + 1) + ". " + makan.get(i));
        }
        System.out.println("");
        return makan;
    }

    public ArrayList<String> tambahmakan(ArrayList<String> makan) {
        String tambah, ya;
        boolean lagi;
        int angka;
        System.out.println("Tambah daftar makanan: ");
        System.out.println("Daftar Makanan: ");
        for (int i = 0; i < makan.size(); i++) {
            System.out.println((i + 1) + ". " + makan.get(i));
        }
        System.out.println("");
        do {
            System.out.println("1. Tambah makanan");
            System.out.println("2. Kembali ke menu awal");
            System.out.print("Pilihan: ");
            while (!scan.hasNextInt()) {
                System.out.println("Input tidak valid !!");
                scan.next();
                System.out.print("Pilihan: ");
            }
            angka = scan.nextInt();
            if (angka == 2) {
                break;
            } else if (angka != 1) {
                System.out.println("Tidak ada pilihan yang tersedia");
                break;
            }
            System.out.print("Nama makanan: ");
            tambah = scan.next() + scan.nextLine();
            makan.add(tambah);
            System.out.println("Makanan berhasil ditambahkan !!");
            System.out.println("Apakah anda ingin menambah daftar makanan lagi ? (y/n)");
            ya = scan.next();
            if (ya.equalsIgnoreCase("y")) {
                lagi = true;
            } else {
                lagi = false;
            }
        } while (lagi);
        System.out.println("");
        return makan;
    }

    public ArrayList<String> editmakan(ArrayList<String> makan) {
        int angka, pilih;
        String makanan;
        System.out.print("Edit daftar makanan: ");
        System.out.println("Daftar Makanan: ");
        for (int i = 0; i < makan.size(); i++) {
            System.out.println((i + 1) + ". " + makan.get(i));
        }
        System.out.println("");
        System.out.print("Edit daftar makanan nomor berapa?(pilih 0 untuk keluar): ");
        while(!scan.hasNextInt()){
            System.out.println("Input tidak valid !!");
            scan.next();
            System.out.print("Edit daftar makanan no berapa?(pilih 0 untuk keluar): ");
        }
        angka = scan.nextInt();
        if (angka > 0) {

            if (makan.size() > angka) {
                System.out.println("Nama makanan: ");
                makanan = scan.nextLine() + scan.nextLine();
                makan.set(angka - 1, makanan);
            } else {
                System.out.println("Tidak ada yang bisa diedit !!");
            }
        }
        else if (angka < 0){
            System.out.println("Angka tidak valid !!");
        }
        System.out.println("");
        return makan;
    }

    public ArrayList<String> hapusmakan(ArrayList<String> makan) {
        int angka, pilih;
        System.out.print("Hapus daftar makanan = ");
        System.out.println("Daftar Makanan: ");
        for (int i = 0; i < makan.size(); i++) {
            System.out.println((i + 1) + ". " + makan.get(i));
        }
        System.out.println("");
        System.out.print("Hapus daftar makanan no berapa?(pilih 0 untuk keluar): ");
        while(!scan.hasNextInt()){
            System.out.println("Input tidak valid !!");
            scan.next();
            System.out.print("Hapus daftar makanan no berapa?(pilih 0 untuk keluar): ");
        }
        angka = scan.nextInt();
        if (angka > 0) {
            if (angka > makan.size()) {
                System.out.println("Tidak ada yang bisa dihapus !!");
            } else {
                makan.remove(angka - 1);
            }
        }
        else if (angka < 0){
            System.out.println("Angka tidak valid !!");
        }
        System.out.println("");
        return makan;
    }

    public ArrayList<String> targetkalori(ArrayList<String> olahraga) {
        int target;
        return olahraga;
    }

    public void keluar() {
        System.exit(0);
    }

    public static void main(String[] args) {
        int pilih;
        float bmr;
        ArrayList<String> olahraga = new ArrayList<String>();
        ArrayList<String> makan = new ArrayList<String>();
        System.out.println("Starting the Application");
        CariKalori fungsi = new CariKalori();
        fungsi.boot();
        System.out.println("");
        do {
            pilih = fungsi.pilih();
            System.out.println("");

            switch (pilih) {
                case 1: {
                    bmr = fungsi.kalhari();
                    break;
                }
                case 2: {
                    fungsi.bmi();
                    break;
                }
                case 3: {
                    fungsi.daftarolahraga(olahraga);
                    break;
                }
                case 4: {
                    fungsi.tambaholahraga(olahraga);
                    break;
                }
                case 5: {
                    fungsi.editolahraga(olahraga);
                    break;
                }
                case 6: {
                    fungsi.hapusolahraga(olahraga);
                    break;
                }
                case 7: {
                    fungsi.daftarmakan(makan);
                    break;
                }
                case 8: {
                    fungsi.tambahmakan(makan);
                    break;
                }
                case 9: {
                    fungsi.editmakan(makan);
                    break;
                }
                case 10: {
                    fungsi.hapusmakan(makan);
                    break;
                }
                case 11: {
                    fungsi.targetkalori(makan);
                    break;
                }
                case 12: {
                    fungsi.keluar();
                    break;
                }
                default: {
                    System.out.println("Tidak ada pada menu !!");
                }
            }

        } while (pilih != 12);

    }
}

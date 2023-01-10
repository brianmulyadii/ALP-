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
 * @Author Filbert Patricio & Brian
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

    public int pilih(int kalori) {
        int pilih;
        System.out.println("Target kalori harian = " + kalori);
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
        System.out.println("12. Simulasi Makan dan Olahraga (Peringatan : Input Daftar Olahraga, Makanan, serta Target Kalori sebelum menggunakan fitur ini !!)");
        System.out.println("13. Keluar");
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

    public void daftarolahraga(ArrayList<String> olahraga, ArrayList<Integer> kaloriolahraga) {

        System.out.println("Daftar Olahraga: ");
        for (int i = 0; i < olahraga.size(); i++) {
            System.out.println((i + 1) + ". " + olahraga.get(i) + " " + "\t" + kaloriolahraga.get(i) + " kalori");
        }
        System.out.println("");
    }

    public ArrayList<String> tambaholahraga(ArrayList<String> olahraga, ArrayList<Integer> kaloriolahraga) {
        String tambah, ya;
        boolean lagi;
        int angka, kalori;
        System.out.println("Tambah daftar olahraga: ");
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
            System.out.print("Berapa Kalori: ");
            while (!scan.hasNextInt()) {
                System.out.println("Input tidak valid !!");
                scan.next();
                System.out.print("Berapa Kalori: ");
            }
            kalori = scan.nextInt();
            kaloriolahraga.add(kalori);
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

    public ArrayList<String> editolahraga(ArrayList<String> olahraga, ArrayList<Integer> kaloriolahraga) {
        int angka, pilih, kalori;
        String nama;
        System.out.println("Edit daftar olahraga: ");
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
                System.out.print("Berapa Kalori: ");
                while (!scan.hasNextInt()) {
                    System.out.println("Input tidak valid !!");
                    scan.next();
                    System.out.print("Berapa Kalori: ");
                }
                kalori = scan.nextInt();
                kaloriolahraga.set(angka - 1, kalori);
                System.out.println("Olahraga berhasil diedit !!");
            }
        } else if (angka < 0) {
            System.out.println("Angka tidak valid !!");
        }
        System.out.println("");
        return olahraga;
    }

    public void hapusolahraga(ArrayList<String> olahraga, ArrayList<Integer> kaloriolahraga) {
        int angka, pilih;
        String nama;
        System.out.println("Hapus daftar olahraga: ");
        System.out.println("");
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
                kaloriolahraga.remove(angka - 1);
            }
        } else if (angka < 0) {
            System.out.println("Angka tidak valid !!");
        }
        System.out.println("");
    }

    public ArrayList<String> daftarmakan(ArrayList<String> makan, ArrayList<Integer> kalorimakan) {
        System.out.println("Daftar Makan: ");
        for (int i = 0; i < makan.size(); i++) {
            System.out.println((i + 1) + ". " + makan.get(i) + " " + "\t" + kalorimakan.get(i) + " kalori");
        }
        System.out.println("");
        return makan;
    }

    public void tambahmakan(ArrayList<String> makan, ArrayList<Integer> kalorimakan) {
        String tambah, ya;
        boolean lagi;
        int angka, kalori;
        System.out.println("Tambah daftar makanan: ");
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
            System.out.print("Berapa kalori: ");
            while (!scan.hasNextInt()) {
                System.out.println("Input tidak valid !!");
                scan.next();
                System.out.print("Berapa kalori: ");
            }
            kalori = scan.nextInt();
            kalorimakan.add(kalori);
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
    }

    public ArrayList<String> editmakan(ArrayList<String> makan, ArrayList<Integer> kalorimakan) {
        int angka, pilih, kalori;
        String makanan;
        System.out.print("Edit daftar makanan: ");
        System.out.print("Edit daftar makanan nomor berapa?(pilih 0 untuk keluar): ");
        while (!scan.hasNextInt()) {
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
                System.out.println("Berapa kalori: ");
                while (!scan.hasNextInt()) {
                    System.out.println("Input tidak valid !!");
                    scan.next();
                    System.out.print("Berapa kalori: ");
                }
                kalori = scan.nextInt();
                kalorimakan.set(angka - 1, kalori);
            } else {
                System.out.println("Tidak ada yang bisa diedit !!");
            }
        } else if (angka < 0) {
            System.out.println("Angka tidak valid !!");
        }
        System.out.println("");
        return makan;
    }

    public ArrayList<String> hapusmakan(ArrayList<String> makan, ArrayList<Integer> kalorimakan) {
        int angka, pilih;
        System.out.print("Hapus daftar makanan = ");
        System.out.println("");
        System.out.print("Hapus daftar makanan no berapa?(pilih 0 untuk keluar): ");
        while (!scan.hasNextInt()) {
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
                kalorimakan.remove(angka - 1);
            }
        } else if (angka < 0) {
            System.out.println("Angka tidak valid !!");
        }
        System.out.println("");
        return makan;
    }

    public int targetkalori() {
        int target;
        System.out.print("Target kalori yang ingin dicapai : ");
        while (!scan.hasNextInt()) {
            System.out.println("Input tidak valid !!");
            scan.next();
            System.out.print("Target kalori yang ingin dicapai : ");
        }
        target = scan.nextInt();

        return target;
    }

    public void simulasi(int kalori, ArrayList<Integer> kaloriolahraga, ArrayList<Integer> kalorimakan) {
        int makankali, olahragakali, pilihmakan, totalkalorimakan, piliholahraga, totalkaloriolahraga, total;
        totalkalorimakan = 0;
        totalkaloriolahraga = 0;
        System.out.println("");
        System.out.println("Target Kalori = " + kalori);
        System.out.print("Makan berapa kali ? ");
        while (!scan.hasNextInt()) {
            System.out.println("Input tidak valid !!");
            scan.next();
            System.out.print("Makan berapa kali ? ");
        }
        makankali = scan.nextInt();
        for (int i = 0; i < makankali; i++) {
            do {
                System.out.print("pilih makanan ke-" + (i + 1) + "(masukkan nomor makanan pilihan) : ");
                while (!scan.hasNextInt()) {
                    System.out.println("Input tidak valid !!");
                    scan.next();
                    System.out.print("pilih makanan ke-" + (i + 1) + "(masukkan nomor makanan pilihan) : ");
                }
                pilihmakan = scan.nextInt();
                if ((kalorimakan.size() < pilihmakan) && (pilihmakan < 0)) {
                    System.out.println("Input tidak valid !!");
                }
            } while ((kalorimakan.size() < pilihmakan) && (pilihmakan < 0));
            totalkalorimakan = totalkalorimakan + kalorimakan.get(pilihmakan - 1);
        }
        System.out.print("Olahraga berapa kali ? ");
        while (!scan.hasNextInt()) {
            System.out.println("Input tidak valid !!");
            scan.next();
            System.out.print("Olahraga berapa kali ? ");
        }
        olahragakali = scan.nextInt();
        for (int i = 0; i < olahragakali; i++) {
            do {
                System.out.print("pilih olahraga ke-" + (i + 1) + "(masukkan nomor makanan pilihan) : ");
                while (!scan.hasNextInt()) {
                    System.out.println("Input tidak valid !!");
                    scan.next();
                    System.out.print("pilih olahraga ke-" + (i + 1) + "(masukkan nomor makanan pilihan) : ");
                }
                piliholahraga = scan.nextInt();
                if (kaloriolahraga.size() < piliholahraga) {
                    System.out.println("Input tidak valid !!");
                }
            } while (kalorimakan.size() < piliholahraga);
            totalkaloriolahraga = totalkaloriolahraga + kaloriolahraga.get(piliholahraga - 1);
        }
        total = totalkalorimakan - totalkaloriolahraga;
        if (total < kalori) {
            System.out.println("Target kalori harian sudah tercapai !!");
        } else {
            System.out.println("Target kalori harian belum tercapai !!");
        }
    }

    public void keluar() {
        System.exit(0);
    }

    public static void main(String[] args) {
        int pilih, kalori;
        float bmr;
        ArrayList<String> olahraga = new ArrayList<String>();
        ArrayList<Integer> kaloriolahraga = new ArrayList<Integer>();
        ArrayList<String> makan = new ArrayList<String>();
        ArrayList<Integer> kalorimakan = new ArrayList<Integer>();
        System.out.println("Starting the Application");
        CariKalori fungsi = new CariKalori();
        fungsi.boot();
        System.out.println("");
        kalori = 0;
        do {
            pilih = fungsi.pilih(kalori);
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
                    fungsi.daftarolahraga(olahraga, kaloriolahraga);
                    break;
                }
                case 4: {
                    fungsi.daftarolahraga(olahraga, kaloriolahraga);
                    fungsi.tambaholahraga(olahraga, kaloriolahraga);
                    break;
                }
                case 5: {
                    fungsi.daftarolahraga(olahraga, kaloriolahraga);
                    fungsi.editolahraga(olahraga, kaloriolahraga);
                    break;
                }
                case 6: {
                    fungsi.daftarolahraga(olahraga, kaloriolahraga);
                    fungsi.hapusolahraga(olahraga, kaloriolahraga);
                    break;
                }
                case 7: {
                    fungsi.daftarmakan(makan, kalorimakan);
                    break;
                }
                case 8: {
                    fungsi.daftarmakan(makan, kalorimakan);
                    fungsi.tambahmakan(makan, kalorimakan);
                    break;
                }
                case 9: {
                    fungsi.daftarmakan(makan, kalorimakan);
                    fungsi.editmakan(makan, kalorimakan);
                    break;
                }
                case 10: {
                    fungsi.daftarmakan(makan, kalorimakan);
                    fungsi.hapusmakan(makan, kalorimakan);
                    break;
                }
                case 11: {
                    kalori = fungsi.targetkalori();
                    break;
                }
                case 12: {
                    fungsi.daftarolahraga(olahraga, kaloriolahraga);
                    fungsi.daftarmakan(makan, kalorimakan);
                    fungsi.simulasi(kalori, kaloriolahraga, kalorimakan);
                }
                case 13: {
                    fungsi.keluar();
                    break;
                }
                default: {
                    System.out.println("Tidak ada pada menu !!");
                }
            }

        } while (pilih != 13);

    }
}



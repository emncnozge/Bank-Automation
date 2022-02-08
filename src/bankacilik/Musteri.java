package bankacilik;

import static bankacilik.Login.A;
import java.time.*;
import java.io.BufferedReader;
import java.io.File;
import bankacilik.MusteriEkran.*;
import static bankacilik.MusteriEkran.sethesaplarTbl;
import static bankacilik.MusteriEkran.setkredikartlariTbl;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Musteri extends Kullanici implements IParaIslemleri, IKrediler, IDegistir {

    ArrayList<String> bakiye = new ArrayList<>();

    public Musteri(long tc) {
        super(tc);
    }

    @Override
    public void paraGonder(Musteri m1, String iban, String iban2, String miktar, JTable hesaplarTbl) throws IOException {
        int i = 0;
        while (!m1.hesaplar.get(i).equals(iban)) {
            i++;
        }

        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/hesaplar.txt"), StandardCharsets.UTF_8));
            int j = 0;
            for (j = 0; j < fileContent.size(); j++) {
                if (fileContent.get(j).split("/")[2].equals(iban)) {
                    fileContent.set(j, m1.getTc() + "/" + m1.hesap_adi.get(i) + "/" + iban + "/" + String.valueOf(Double.valueOf(m1.bakiye.get(i)) - Double.valueOf(miktar)) + "/" + m1.tur.get(i));
                    break;
                }
            }
            if (!fileContent.get(j).split("/")[2].equals(iban)) {
                JOptionPane.showMessageDialog(null, "Böyle bir hesap bulunamadı");
                return;
            }
            Files.write(Paths.get("src/files/hesaplar.txt"), fileContent, StandardCharsets.UTF_8);
        } catch (IOException ex) {
        }
        m1.bakiye.set(i, String.valueOf(Double.valueOf(m1.bakiye.get(i)) - Double.valueOf(miktar)));
        sethesaplarTbl(m1, hesaplarTbl);
        File file = new File("src/files/hesaplar.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int count = 0;
        String ad = "";
        String tur = "";
        String bakiye = "", kimlik = "";
        while ((st = br.readLine()) != null) {
            if (st.split("/")[2].equals(String.valueOf(iban2))) {
                count++;
                kimlik = st.split("/")[0];
                ad = (st.split("/")[1]);
                tur = (st.split("/")[4]);
                bakiye = st.split("/")[3];
            }
        }
        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/hesaplar.txt"), StandardCharsets.UTF_8));
            for (int j = 0; j < fileContent.size(); j++) {
                if (fileContent.get(j).split("/")[2].equals(iban2)) {

                    fileContent.set(j, kimlik + "/" + ad + "/" + iban2 + "/" + (Double.valueOf(bakiye) + Double.valueOf(miktar)) + "/" + tur);

                    break;
                }
            }
            Files.write(Paths.get("src/files/hesaplar.txt"), fileContent, StandardCharsets.UTF_8);
        } catch (IOException ex) {
        }
        sethesaplarTbl(m1, hesaplarTbl);
        br.close();
        hesapGecmis(m1.getTc() + "/" + miktar + "TL ücret " + iban + " hesabınızdan çekilerek " + iban2 + " hesabına gönderildi.");
        JOptionPane.showMessageDialog(null, "Para gönderme işlemi başarılı!");
    }

    @Override
    public void paraYatir(Musteri m1, String iban, String miktar, JTable hesaplarTbl) throws IOException {
        int i = 0;
        while (!m1.hesaplar.get(i).equals(iban)) {
            i++;
        }
        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/hesaplar.txt"), StandardCharsets.UTF_8));
            for (int j = 0; j < fileContent.size(); j++) {
                if (fileContent.get(j).split("/")[2].equals(iban)) {
                    fileContent.set(j, m1.getTc() + "/" + m1.hesap_adi.get(i) + "/" + iban + "/" + String.valueOf(Double.valueOf(m1.bakiye.get(i)) + Double.valueOf(miktar)) + "/" + m1.tur.get(i));
                    break;
                }
            }
            Files.write(Paths.get("src/files/hesaplar.txt"), fileContent, StandardCharsets.UTF_8);
        } catch (IOException ex) {
        }
        m1.bakiye.set(i, String.valueOf(Double.valueOf(m1.bakiye.get(i)) + Double.valueOf(miktar)));
        sethesaplarTbl(m1, hesaplarTbl);
        JOptionPane.showMessageDialog(null, miktar + "TL hesabınıza başarıyla yatırıldı!");
        hesapGecmis(m1.getTc() + "/" + miktar + "TL ücret " + iban + " hesabınıza yatırıldı.");

    }

    @Override
    public void paraCek(Musteri m1, String iban, String miktar, JTable hesaplarTbl) throws IOException {
        int i = 0;
        while (!m1.hesaplar.get(i).equals(iban)) {
            i++;
        }
        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/hesaplar.txt"), StandardCharsets.UTF_8));
            for (int j = 0; j < fileContent.size(); j++) {
                if (fileContent.get(j).split("/")[2].equals(iban)) {
                    fileContent.set(j, m1.getTc() + "/" + m1.hesap_adi.get(i) + "/" + iban + "/" + String.valueOf(Double.valueOf(m1.bakiye.get(i)) - Double.valueOf(miktar)) + "/" + m1.tur.get(i));
                    break;
                }
            }
            Files.write(Paths.get("src/files/hesaplar.txt"), fileContent, StandardCharsets.UTF_8);
        } catch (IOException ex) {
        }
        m1.bakiye.set(i, String.valueOf(Double.valueOf(m1.bakiye.get(i)) - Double.valueOf(miktar)));
        sethesaplarTbl(m1, hesaplarTbl);
        JOptionPane.showMessageDialog(null, miktar + "TL hesabınızdan başarıyla çekildi!");

        hesapGecmis(m1.getTc() + "/" + miktar + "TL ücret " + iban + " hesabınızdan çekildi.");

    }

    @Override
    public int krediOde(Musteri m1, String kredi, String borc, String miktar, String iban) {
        int i = 0;
        while (!(Double.parseDouble(m1.kredimiktari.get(i)) == Double.parseDouble(kredi)) && !(Double.parseDouble(m1.kredikalanborc.get(i)) == Double.parseDouble(borc))) {
            i++;
        }
        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/krediler.txt"), StandardCharsets.UTF_8));
            for (int j = 0; j < fileContent.size(); j++) {

                if (Double.parseDouble(fileContent.get(j).split("/")[1]) == (Double.parseDouble(kredi)) && Double.parseDouble(fileContent.get(j).split("/")[2]) == (Double.parseDouble(borc))) {
                    fileContent.set(j, m1.getTc() + "/" + m1.kredimiktari.get(i) + "/" + String.valueOf(Double.valueOf(m1.kredikalanborc.get(i)) - Double.valueOf(miktar)) + "/" + m1.kredisonodeme.get(i));
                    if (fileContent.get(j).split("/")[2].equals("0") || fileContent.get(j).split("/")[2].equals("0.0")) {
                        fileContent.set(j, "");
                    }
                    break;
                }
            }

            Files.write(Paths.get("src/files/krediler.txt"), fileContent, StandardCharsets.UTF_8);
        } catch (IOException ex) {
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/files/krediler.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/files/krediler2.txt"));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals("")) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            File file1 = new File("src/files/krediler.txt");
            File file2 = new File("src/files/krediler2.txt");
            file1.delete();
            file2.renameTo(new File("src/files/krediler.txt"));
            File f1 = new File("src/files/krediler2.txt");
            f1.delete();
            
        } catch (IOException e) {
            
        }
        i = 0;
        while (!m1.hesaplar.get(i).equals(iban)) {
            i++;
        }
        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/hesaplar.txt"), StandardCharsets.UTF_8));
            for (int j = 0; j < fileContent.size(); j++) {
                if (fileContent.get(j).split("/")[2].equals(iban)) {
                    fileContent.set(j, m1.getTc() + "/" + m1.hesap_adi.get(i) + "/" + iban + "/" + String.valueOf(Double.valueOf(m1.bakiye.get(i)) - Double.valueOf(miktar)) + "/" + m1.tur.get(i));
                    break;
                }
            }
            Files.write(Paths.get("src/files/hesaplar.txt"), fileContent, StandardCharsets.UTF_8);
        } catch (IOException ex) {
        }
        JOptionPane.showMessageDialog(null, "Kredi ödemesi başarıyla gerçekleşti!");
        hesapGecmis(m1.getTc() + "/" + miktar + "TL ücretli " + " kredi faturası " + iban + " numaralı hesabınızdan ödendi");

        return i;

    }

    public void kartBorcOde(Musteri m1, String kartno, String miktar, JTable kartlarTbl, String iban, JTable hesaplarTbl) throws IOException {
        int i = 0;
        while (!m1.kartno.get(i).equals(kartno)) {
            i++;
        }
        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/kredikartlari.txt"), StandardCharsets.UTF_8));
            for (int j = 0; j < fileContent.size(); j++) {
                if (fileContent.get(j).split("/")[1].equals(kartno)) {
                    fileContent.set(j, m1.getTc() + "/" + m1.kartno.get(i) + "/" + m1.kart_ay.get(i) + "/" + m1.kart_yil.get(i) + "/" + m1.kart_cvv.get(i) + "/" + m1.kart_limit.get(i) + "/" + m1.kart_adi.get(i) + "/" + m1.kart_ekstre.get(i) + "/" + (Double.parseDouble(m1.kart_bakiye.get(i)) + Double.parseDouble(miktar)));
                    break;
                }
            }
            Files.write(Paths.get("src/files/kredikartlari.txt"), fileContent, StandardCharsets.UTF_8);
        } catch (IOException ex) {
        }
        m1.kart_bakiye.set(i, String.valueOf(Double.valueOf(m1.kart_bakiye.get(i)) + Double.valueOf(miktar)));
        setkredikartlariTbl(m1, kartlarTbl);
        i = 0;
        while (!m1.hesaplar.get(i).equals(iban)) {
            i++;
        }
        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/hesaplar.txt"), StandardCharsets.UTF_8));
            for (int j = 0; j < fileContent.size(); j++) {
                if (fileContent.get(j).split("/")[2].equals(iban)) {
                    fileContent.set(j, m1.getTc() + "/" + m1.hesap_adi.get(i) + "/" + iban + "/" + String.valueOf(Double.valueOf(m1.bakiye.get(i)) - Double.valueOf(miktar)) + "/" + m1.tur.get(i));
                    break;
                }
            }
            Files.write(Paths.get("src/files/hesaplar.txt"), fileContent, StandardCharsets.UTF_8);

        } catch (IOException ex) {
        }
        m1.bakiye.set(i, String.valueOf(Double.valueOf(m1.bakiye.get(i)) - Double.valueOf(miktar)));
        sethesaplarTbl(m1, hesaplarTbl);
        JOptionPane.showMessageDialog(null, "Borç ödeme başarıyla gerçekleşti!");
        hesapGecmis(m1.getTc() + "/" + iban + " hesabınızdan " + miktar + "TL çekilerek " + kartno + " numaralı kartınızın borcu ödenmiştir.");

    }

    public void faturaOde(Musteri m1, String iban, String miktar, boolean bank, String fatura) throws IOException {

        if (bank == true) {
            int i = 0;
            while (!m1.hesaplar.get(i).equals(iban)) {
                i++;
            }

            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/hesaplar.txt"), StandardCharsets.UTF_8));
            for (int j = 0; j < fileContent.size(); j++) {
                if (fileContent.get(j).split("/")[2].equals(iban)) {
                    fileContent.set(j, m1.getTc() + "/" + m1.hesap_adi.get(i) + "/" + iban + "/" + String.valueOf(Double.valueOf(m1.bakiye.get(i)) - Double.valueOf(miktar)) + "/" + m1.tur.get(i));
                    break;
                }
            }
            Files.write(Paths.get("src/files/hesaplar.txt"), fileContent, StandardCharsets.UTF_8);
            m1.bakiye.set(i, String.valueOf(Double.valueOf(m1.bakiye.get(i)) - Double.valueOf(miktar)));
        } else if (bank == false) {
            int i = 0;
            while (!m1.kartno.get(i).equals(iban)) {
                i++;
            }

            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/kredikartlari.txt"), StandardCharsets.UTF_8));
            for (int j = 0; j < fileContent.size(); j++) {
                if (fileContent.get(j).split("/")[1].equals(iban)) {
                    fileContent.set(j, m1.getTc() + "/" + m1.kartno.get(i) + "/" + m1.kart_ay.get(i) + "/" + m1.kart_yil.get(i) + "/" + m1.kart_cvv.get(i) + "/" + m1.kart_limit.get(i) + "/" + m1.kart_adi.get(i) + "/" + m1.kart_ekstre.get(i) + "/" + (Double.parseDouble(m1.kart_bakiye.get(i)) - Double.parseDouble(miktar)));
                    break;
                }
            }
            Files.write(Paths.get("src/files/kredikartlari.txt"), fileContent, StandardCharsets.UTF_8);

        }
        if (bank == true) {
            hesapGecmis(m1.getTc() + "/" + miktar + "TL ücretli " + fatura + " faturası " + iban + " numaralı hesabınızdan ödendi");
        } else if (bank == false) {
            hesapGecmis(m1.getTc() + "/" + miktar + "TL ücretli " + fatura + " faturası " + iban + " numaralı kredi kartınızdan ödendi");
        }
        JOptionPane.showMessageDialog(null, miktar + "TL tutarındaki " + fatura + " faturanız başarıyla ödendi.");
    }

    public static void hesapBasvur(String tc, String hAd, String tur) {
        try {
            String kayit = tc + "/" + hAd + "/" + createIban() + "/" + "0.0" + "/" + "Vadesiz TL" + "\n";
            Files.write(Paths.get("src/files/hesapBasvuru.txt"), kayit.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
        hesapGecmis(tc + "/" + "Hesap başvurusu yapıldı.");
        JOptionPane.showMessageDialog(null, "Hesap başvurunuz alındı!", "Başvuru tamamlandı.", JOptionPane.INFORMATION_MESSAGE);

    }

    public static void kredikartiBasvur(String tc, String kAd, String lim) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("u");

        LocalDateTime ay = LocalDateTime.now();
        LocalDateTime yil = LocalDateTime.now().plusYears(10);

        try {
            String kayit = tc + "/" + createCreditCard() + "/" + dtf.format(ay) + "/" + dtf2.format(yil) + "/" + createcvv() + "/" + lim + "/" + kAd + "/" + createekstre() + "/" + lim + "\n";
            Files.write(Paths.get("src/files/krediKartiBasvuru.txt"), kayit.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {

        }
        hesapGecmis(tc + "/" + "Kredi kartı başvurusu yapıldı.");
        JOptionPane.showMessageDialog(null, "Kredi kartı başvurunuz alındı!", "Başvuru tamamlandı.", JOptionPane.INFORMATION_MESSAGE);

    }

    public static void krediBasvur(String tc, String neden, String miktar, String tarih) {
        try {
            String kayit = tc + "/" + miktar + "/" + miktar + "/" + tarih + "/" + neden + "\n";
            Files.write(Paths.get("src/files/krediBasvuru.txt"), kayit.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {

        }
        hesapGecmis(tc + "/" + "Kredi başvurusu yapıldı.");
        JOptionPane.showMessageDialog(null, "Kredi başvurunuz alındı!", "Başvuru tamamlandı.", JOptionPane.INFORMATION_MESSAGE);

    }

    public void limitGuncelle(Musteri m1, String kartno, String yenilimit) {
        int i = 0;
        while (!m1.kartno.get(i).equals(kartno)) {
            i++;
        }
        try {
            String kayit = m1.getTc() + "/" + kartno + "/" + m1.kart_ay.get(i) + "/" + m1.kart_yil.get(i) + "/" + m1.kart_cvv.get(i) + "/" + m1.kart_limit.get(i) + "/" + m1.kart_adi.get(i) + "/" + m1.kart_ekstre.get(i) + "/" + m1.kart_bakiye.get(i) + "/" + yenilimit + "\n";
            Files.write(Paths.get("src/files/KrediKartiLimitBasvuru.txt"), kayit.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {

        }
        hesapGecmis(m1.getTc() + "/" + kartno + " numaralı kartınızda limit değişikliği başvurusu yapıldı. Talep edilen limit: " + yenilimit);

        JOptionPane.showMessageDialog(null, "Limit güncelleme talebiniz başarıyla alındı!");
    }

    @Override
    public void sifreDegistir(Musteri m1, String eskisifre, String yenisifre) {
        if (eskisifre.equals(m1.getSifre())) {

            try {
                List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/musteriInfo.txt"), StandardCharsets.UTF_8));
                for (int j = 0; j < fileContent.size(); j++) {
                    if (fileContent.get(j).split("/")[0].equals(String.valueOf(m1.getTc()))) {
                        fileContent.set(j, m1.getTc() + "/" + yenisifre + "/" + m1.getAnnekizlik() + "/" + m1.getAd() + "/" + m1.getSoyad() + "/" + m1.getTel() + "/" + m1.getEmail() + "/" + m1.getDgmgn());
                        m1.setSifre(yenisifre);
                        break;
                    }
                }
                Files.write(Paths.get("src/files/musteriInfo.txt"), fileContent, StandardCharsets.UTF_8);
                JOptionPane.showMessageDialog(null, "Şifreniz başarıyla değiştirildi!", "Şifre değiştirildi.", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "İlk şifre hatalı!", "Hata", JOptionPane.WARNING_MESSAGE);
        }
        hesapGecmis(m1.getTc() + "/" + "Şifre değişikliği yapıldı.");

    }

    @Override
    public void mailDegistir(Musteri m1, String mail) {
        String old = m1.getEmail();
        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/musteriInfo.txt"), StandardCharsets.UTF_8));
            for (int j = 0; j < fileContent.size(); j++) {
                if (fileContent.get(j).split("/")[0].equals(String.valueOf(m1.getTc()))) {
                    fileContent.set(j, m1.getTc() + "/" + m1.getSifre() + "/" + m1.getAnnekizlik() + "/" + m1.getAd() + "/" + m1.getSoyad() + "/" + m1.getTel() + "/" + mail + "/" + m1.getDgmgn());
                    m1.setEmail(mail);
                    break;
                }
            }
            Files.write(Paths.get("src/files/musteriInfo.txt"), fileContent, StandardCharsets.UTF_8);
            JOptionPane.showMessageDialog(null, "E-Mailiniz başarıyla değiştirildi!", "E-mail değiştirildi.", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
        }
        hesapGecmis(m1.getTc() + "/" + "E-Mail değişikliği yapıldı. Önceki e-mail: " + old + " Yeni e-mail: " + m1.getEmail());

    }

    @Override
    public void telDegistir(Musteri m1, String tel) {
        String old = m1.getTel();
        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/musteriInfo.txt"), StandardCharsets.UTF_8));
            for (int j = 0; j < fileContent.size(); j++) {
                if (fileContent.get(j).split("/")[0].equals(String.valueOf(m1.getTc()))) {
                    fileContent.set(j, m1.getTc() + "/" + m1.getSifre() + "/" + m1.getAnnekizlik() + "/" + m1.getAd() + "/" + m1.getSoyad() + "/" + tel + "/" + m1.getEmail() + "/" + m1.getDgmgn());
                    m1.setTel(tel);
                    break;
                }
            }
            Files.write(Paths.get("src/files/musteriInfo.txt"), fileContent, StandardCharsets.UTF_8);
            JOptionPane.showMessageDialog(null, "Telefon numaranız başarıyla değiştirildi!", "Telefon numarası değiştirildi.", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
        }
        hesapGecmis(m1.getTc() + "/" + "Telefon numarası değişikliği yapıldı. Önceki telefon numarası: " + old + " Yeni telefon numarası: " + m1.getTel());

    }

    public static String createIban() throws FileNotFoundException, IOException {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 24; i++) {
            str.append(random.nextInt(10));
        }
        File file = new File("src/files/hesaplar.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            if (st.split("/")[2].equals("TR" + str.toString())) {
                createIban();
            }
        }
        File file2 = new File("src/files/hesapBasvuru.txt");
        BufferedReader br2 = new BufferedReader(new FileReader(file2));
        String st2;
        if (br2.readLine() != null) {
            while ((st2 = br2.readLine()) != null) {

                if (st2.split("/")[2].equals("TR" + str.toString())) {
                    createIban();
                }

            }
        }
        br.close();
        br2.close();
        return "TR" + str.toString();
    }

    public static String createCreditCard() throws FileNotFoundException, IOException {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            str.append(random.nextInt(10));
        }
        File file = new File("src/files/kredikartlari.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            if (st.split("/")[1].equals(str.toString())) {
                createCreditCard();
            }
        }
        File file2 = new File("src/files/krediKartiBasvuru.txt");
        BufferedReader br2 = new BufferedReader(new FileReader(file2));
        String st2;
        while ((st2 = br2.readLine()) != null) {
            if (st2.split("/")[1].equals(str.toString())) {
                createCreditCard();
            }
        }
        br.close();
        br2.close();
        return str.toString();
    }

    public static String createcvv() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

    public static String createekstre() {

        int rnd = new Random().nextInt(27) + 1;
        return String.valueOf(rnd);
    }

    public static void hesapGecmis(String a) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            LocalDateTime tarih = LocalDateTime.now();
            String kayit = a + "/" + dtf.format(tarih) + "\n";
            Files.write(Paths.get("src/files/musteriGecmis.txt"), kayit.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {

        }

    }

    public void kredikartiIptal(String kartno, String tc) throws Throwable {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/files/kredikartlari.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/files/kredikartlari2.txt"));

            String lineToRemove = kartno;
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {

                String trimmedLine = currentLine.trim();
                if (trimmedLine.split("/")[1].equals(lineToRemove)) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            File file1 = new File("src/files/kredikartlari.txt");
            File file2 = new File("src/files/kredikartlari2.txt");
            file1.delete();
            file2.renameTo(new File("src/files/kredikartlari.txt"));
            File f1 = new File("src/files/kredikartlari2.txt");
            f1.delete();
            JOptionPane.showMessageDialog(null, "Kredi kartınız başarıyla iptal edildi!");
            hesapGecmis(tc + "/" + kartno + " numaralı kartınız iptal edildi.");
        } catch (IOException ex) {
        }
    }

    public Musteri giris(String tc, String parola) throws IOException {
        File file = new File("src/files/musteriInfo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            if (st.split("/")[0].equals(tc)) {
                if (st.split("/")[1].equals(parola)) {
                    Musteri m1 = new Musteri(Long.valueOf(tc));
                    m1.setSifre(st.split("/")[1]);
                    m1.setAnnekizlik(st.split("/")[2]);
                    m1.setAd(st.split("/")[3]);
                    m1.setSoyad(st.split("/")[4]);
                    m1.setTel(st.split("/")[5]);
                    m1.setEmail(st.split("/")[6]);
                    m1.setDgmgn(st.split("/")[7]);
                    A.setVisible(false);
                    MusteriEkran me = new MusteriEkran(m1);
                    me.setVisible(true);
                    br.close();
                    return m1;
                }
            }
        }
        br.close();
        return null;
    }
    @Override
    public void girisyapildi(){
    JOptionPane.showMessageDialog(null, "Müşteri girişi yapıldı.");
}
    public static void kaydol(String tc, String sifre, String annekizlik, String ad, String soyad, String telefon, String email, String dg) {
        try {
            String kayit = tc + "/" + sifre + "/" + annekizlik + "/" + ad + "/" + soyad + "/" + telefon + "/" + email + "/" + dg + "\n";
            Files.write(Paths.get("src/files/musteriInfo.txt"), kayit.getBytes(), StandardOpenOption.APPEND);
            JOptionPane.showMessageDialog(null, "Kaydınız başarıyla gerçekleşti!");
        } catch (IOException e) {

        }

    }
}

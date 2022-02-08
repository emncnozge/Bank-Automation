package bankacilik;

import static bankacilik.Login.A;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Yonetici extends Calisan {
    ArrayList<String> personelAd = new ArrayList<>();
    ArrayList<String> personelSoyad = new ArrayList<>();
    ArrayList<String> personelKimlik = new ArrayList<>();
    ArrayList<String> personelAnne = new ArrayList<>();
    ArrayList<String> personelSifre = new ArrayList<>();
    ArrayList<String> personelMaas = new ArrayList<>();
    ArrayList<String> personelMaasGun = new ArrayList<>();
    ArrayList<String> personelDg = new ArrayList<>();
    ArrayList<String> personelTel = new ArrayList<>();
    ArrayList<String> personelMail = new ArrayList<>();


    public Yonetici(long tc) throws FileNotFoundException, IOException {
        super(tc);
    }
    public static void personelGuncelle(JButton b1,String a,String b){
            try {
                List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/personelInfo.txt"), StandardCharsets.UTF_8));
                for (int j = 0; j < fileContent.size(); j++) {
                    if (fileContent.get(j).equals(a)) {
                    fileContent.set(j, b);   
                    break;
                    }
                }
                Files.write(Paths.get("src/files/personelInfo.txt"), fileContent, StandardCharsets.UTF_8);
                b1.doClick();
                
                JOptionPane.showMessageDialog(null, "Personel başarıyla güncellendi!");
                
            } catch (IOException ex) {
            }
        
    }
    public static void personelSil(String a) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/files/personelInfo.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/files/personelInfo2.txt"));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(a)) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            File file1 = new File("src/files/personelInfo.txt");
            File file2 = new File("src/files/personelInfo2.txt");
            file1.delete();
            file2.renameTo(new File("src/files/personelInfo.txt"));
            File f1 = new File("src/files/personelInfo2.txt");
            f1.delete();
            JOptionPane.showMessageDialog(null, "Personel silindi!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Personel silinemedi!");
        }
        

    }
    public void personelEkle(JButton b1,String a){
    try {
            Files.write(Paths.get("src/files/personelInfo.txt"), a.getBytes(), StandardOpenOption.APPEND);
            JOptionPane.showMessageDialog(null, "Personel başarıyla eklendi!");
            b1.doClick();
    }
    catch(Exception e){}
}
public void telDegistir(Yonetici y1, String tel) {

        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/yoneticiInfo.txt"), StandardCharsets.UTF_8));
            for (int j = 0; j < fileContent.size(); j++) {
                if (fileContent.get(j).split("/")[0].equals(String.valueOf(y1.getTc()))) {
                    fileContent.set(j, y1.getTc() + "/" + y1.getSifre() + "/" + y1.getAnnekizlik() + "/" + y1.getAd() + "/" + y1.getSoyad() + "/" + tel + "/" + y1.getEmail() + "/" + y1.getDgmgn()+"/"+y1.getMaasgun()+"/"+y1.getMaas());
                    y1.setTel(tel);
                    break;
                }
            }
            Files.write(Paths.get("src/files/yoneticiInfo.txt"), fileContent, StandardCharsets.UTF_8);
            JOptionPane.showMessageDialog(null, "Telefon numaranız başarıyla değiştirildi!", "Telefon numarası değiştirildi.", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
        }

    }
public void mailDegistir(Yonetici y1, String email) {

        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/yoneticiInfo.txt"), StandardCharsets.UTF_8));
            for (int j = 0; j < fileContent.size(); j++) {
                if (fileContent.get(j).split("/")[0].equals(String.valueOf(y1.getTc()))) {
                    fileContent.set(j, y1.getTc() + "/" + y1.getSifre() + "/" + y1.getAnnekizlik() + "/" + y1.getAd() + "/" + y1.getSoyad() + "/" + y1.getTel() + "/" + email + "/" + y1.getDgmgn()+"/"+y1.getMaasgun()+"/"+y1.getMaas());
                    y1.setEmail(email);
                    break;
                }
            }
            Files.write(Paths.get("src/files/yoneticiInfo.txt"), fileContent, StandardCharsets.UTF_8);
            JOptionPane.showMessageDialog(null, "Telefon numaranız başarıyla değiştirildi!", "Telefon numarası değiştirildi.", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
        }

    }
public void sifreDegistir(Yonetici y1, String eskisifre, String yenisifre) {
        if (eskisifre.equals(y1.getSifre())) {
            try {
                List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/yoneticiInfo.txt"), StandardCharsets.UTF_8));
                for (int j = 0; j < fileContent.size(); j++) {
                    if (fileContent.get(j).split("/")[0].equals(String.valueOf(y1.getTc()))) {
                    fileContent.set(j, y1.getTc() + "/" + yenisifre + "/" + y1.getAnnekizlik() + "/" + y1.getAd() + "/" + y1.getSoyad() + "/" + y1.getTel() + "/" + y1.getEmail() + "/" + y1.getDgmgn()+"/"+y1.getMaasgun()+"/"+y1.getMaas());                        y1.setSifre(yenisifre);
                    y1.setSifre(yenisifre);    
                    break;
                    }
                }
                Files.write(Paths.get("src/files/yoneticiInfo.txt"), fileContent, StandardCharsets.UTF_8);
                JOptionPane.showMessageDialog(null, "Şifreniz başarıyla değiştirildi!", "Şifre değiştirildi.", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "İlk şifre hatalı!", "Hata", JOptionPane.WARNING_MESSAGE);
        }
    }
    public Yonetici giris(String tc, String parola) throws IOException {
        File file = new File("src/files/yoneticiInfo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            if (st.split("/")[0].equals(tc)) {
                if (st.split("/")[1].equals(parola)) {
                    Yonetici y1 = new Yonetici(Long.valueOf(tc));
                    y1.setSifre(st.split("/")[1]);
                    y1.setAnnekizlik(st.split("/")[2]);
                    y1.setAd(st.split("/")[3]);
                    y1.setSoyad(st.split("/")[4]);
                    y1.setTel(st.split("/")[5]);
                    y1.setEmail(st.split("/")[6]);
                    y1.setDgmgn(st.split("/")[7]);
                    y1.setMaasgun(st.split("/")[8]);
                    y1.setMaas(st.split("/")[9]);
                    A.setVisible(false);
                    YoneticiEkran ye = new YoneticiEkran(y1);
                    ye.setVisible(true);
                    br.close();
                    return y1;
                }
            }
        }
        br.close();
        return null;
    }
    @Override
    public void girisyapildi(){
    JOptionPane.showMessageDialog(null, "Yönetici girişi yapıldı.");
}
}

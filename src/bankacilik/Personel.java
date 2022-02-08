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
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Personel extends Calisan {

    public Personel(long tc) throws FileNotFoundException, IOException {
        super(tc);
    }

    public void telDegistir(Personel p1, String tel) {

        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/personelInfo.txt"), StandardCharsets.UTF_8));
            for (int j = 0; j < fileContent.size(); j++) {
                if (fileContent.get(j).split("/")[0].equals(String.valueOf(p1.getTc()))) {
                    fileContent.set(j, p1.getTc() + "/" + p1.getSifre() + "/" + p1.getAnnekizlik() + "/" + p1.getAd() + "/" + p1.getSoyad() + "/" + tel + "/" + p1.getEmail() + "/" + p1.getDgmgn() + "/" + p1.getMaasgun() + "/" + p1.getMaas());
                    p1.setTel(tel);
                    break;
                }
            }
            Files.write(Paths.get("src/files/personelInfo.txt"), fileContent, StandardCharsets.UTF_8);
            JOptionPane.showMessageDialog(null, "Telefon numaranız başarıyla değiştirildi!", "Telefon numarası değiştirildi.", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
        }

    }

    public void mailDegistir(Personel p1, String email) {

        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/personelInfo.txt"), StandardCharsets.UTF_8));
            for (int j = 0; j < fileContent.size(); j++) {
                if (fileContent.get(j).split("/")[0].equals(String.valueOf(p1.getTc()))) {
                    fileContent.set(j, p1.getTc() + "/" + p1.getSifre() + "/" + p1.getAnnekizlik() + "/" + p1.getAd() + "/" + p1.getSoyad() + "/" + p1.getTel() + "/" + email + "/" + p1.getDgmgn() + "/" + p1.getMaasgun() + "/" + p1.getMaas());
                    p1.setEmail(email);
                    break;
                }
            }
            Files.write(Paths.get("src/files/personelInfo.txt"), fileContent, StandardCharsets.UTF_8);
            JOptionPane.showMessageDialog(null, "Telefon numaranız başarıyla değiştirildi!", "Telefon numarası değiştirildi.", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
        }

    }

    public void sifreDegistir(Personel p1, String eskisifre, String yenisifre) {
        if (eskisifre.equals(p1.getSifre())) {
            try {
                List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/personelInfo.txt"), StandardCharsets.UTF_8));
                for (int j = 0; j < fileContent.size(); j++) {
                    if (fileContent.get(j).split("/")[0].equals(String.valueOf(p1.getTc()))) {
                        fileContent.set(j, p1.getTc() + "/" + yenisifre + "/" + p1.getAnnekizlik() + "/" + p1.getAd() + "/" + p1.getSoyad() + "/" + p1.getTel() + "/" + p1.getEmail() + "/" + p1.getDgmgn() + "/" + p1.getMaasgun() + "/" + p1.getMaas());
                        p1.setSifre(yenisifre);
                        p1.setSifre(yenisifre);
                        break;
                    }
                }
                Files.write(Paths.get("src/files/personelInfo.txt"), fileContent, StandardCharsets.UTF_8);
                JOptionPane.showMessageDialog(null, "Şifreniz başarıyla değiştirildi!", "Şifre değiştirildi.", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "İlk şifre hatalı!", "Hata", JOptionPane.WARNING_MESSAGE);
        }
    }
    @Override
    public void girisyapildi(){
    JOptionPane.showMessageDialog(null, "Personel girişi yapıldı.");
}
    public Personel giris(String tc, String parola) throws IOException {
        File file = new File("src/files/personelInfo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            if (st.split("/")[0].equals(tc)) {
                if (st.split("/")[1].equals(parola)) {
                    Personel p1 = new Personel(Long.valueOf(tc));
                    p1.setSifre(st.split("/")[1]);
                    p1.setAnnekizlik(st.split("/")[2]);
                    p1.setAd(st.split("/")[3]);
                    p1.setSoyad(st.split("/")[4]);
                    p1.setTel(st.split("/")[5]);
                    p1.setEmail(st.split("/")[6]);
                    p1.setDgmgn(st.split("/")[7]);
                    p1.setMaasgun(st.split("/")[8]);
                    p1.setMaas(st.split("/")[9]);
                    A.setVisible(false);
                    PersonelEkran pe = new PersonelEkran(p1);
                    pe.setVisible(true);
                    br.close();
                    return p1;
                }
            }
        }
        br.close();
        return null;
    }
}

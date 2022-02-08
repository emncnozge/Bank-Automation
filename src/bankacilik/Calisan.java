
package bankacilik;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public abstract class Calisan extends Kullanici{
    String Maas;
    String Maasgun;

    public String getMaasgun() {
        return Maasgun;
    }

    public void setMaasgun(String Maasgun) {
        this.Maasgun = Maasgun;
    }
    
    ArrayList<String> kimlik = new ArrayList<>();
    ArrayList<String> kartkimlik = new ArrayList<>();
    ArrayList<String> kartyenilimit = new ArrayList<>();
    ArrayList<String> kredikimlik = new ArrayList<>();
    ArrayList<String> kredineden = new ArrayList<>();
    
    public Calisan(long tc) {
        super(tc);
    }

    public String getMaas() {
        return Maas;
    }

    public void setMaas(String maas) {
        this.Maas = maas;
    }
    
    public static void hesapOnay(String tc, String ad, String iban) {
        try {
            String hesap = tc + "/" + ad + "/" + iban + "/" + "0.0" + "/" + "Vadesiz TL" + "\n";
            Files.write(Paths.get("src/files/hesaplar.txt"), hesap.getBytes(), StandardOpenOption.APPEND);

            BufferedReader reader = new BufferedReader(new FileReader("src/files/hesapBasvuru.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/files/hesapBasvuru2.txt"));

            String lineToRemove = tc + "/" + ad + "/" + iban + "/" + "0.0" + "/" + "Vadesiz TL";
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(lineToRemove)) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            File file1 = new File("src/files/hesapBasvuru.txt");
            File file2 = new File("src/files/hesapBasvuru2.txt");
            file1.delete();
            file2.renameTo(new File("src/files/hesapBasvuru.txt"));
            File f1 = new File("src/files/hesapBasvuru2.txt");
            f1.delete();
        } catch (IOException e) {

        }
        JOptionPane.showMessageDialog(null, "Hesap başvurusu onaylandı!");

    }

    public static void hesapSil(String tc, String ad, String iban) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/files/hesapBasvuru.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/files/hesapBasvuru2.txt"));

            String lineToRemove = tc + "/" + ad + "/" + iban + "/" + "0.0" + "/" + "Vadesiz TL";
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(lineToRemove)) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            File file1 = new File("src/files/hesapBasvuru.txt");
            File file2 = new File("src/files/hesapBasvuru2.txt");
            file1.delete();
            file2.renameTo(new File("src/files/hesapBasvuru.txt"));
            File f1 = new File("src/files/hesapBasvuru2.txt");
            f1.delete();
        } catch (IOException e) {

        }
        JOptionPane.showMessageDialog(null, "Hesap başvurusu silindi!");

    }

    public static void kartOnay(String a) {
        try {
            String hesap = a + "\n";
            Files.write(Paths.get("src/files/kredikartlari.txt"), hesap.getBytes(), StandardOpenOption.APPEND);

            BufferedReader reader = new BufferedReader(new FileReader("src/files/krediKartiBasvuru.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/files/krediKartiBasvuru2.txt"));

            String lineToRemove = a;
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {

                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(lineToRemove)) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            File file1 = new File("src/files/krediKartiBasvuru.txt");
            File file2 = new File("src/files/krediKartiBasvuru2.txt");
            file1.delete();
            file2.renameTo(new File("src/files/krediKartiBasvuru.txt"));
            File f1 = new File("src/files/krediKartiBasvuru2.txt");
            f1.delete();
        } catch (IOException e) {

        }
        JOptionPane.showMessageDialog(null, "Kredi kartı başvurusu onaylandı!");

    }

    public static void limitOnay(String yeni, String eski) {
        try {

            BufferedReader reader = new BufferedReader(new FileReader("src/files/kredikartlari.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/files/kredikartlari2.txt"));

            String lineToRemove = eski;
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {

                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(lineToRemove)) {
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
            System.out.println(eski);
            System.out.println(yeni.split("/")[5]);
            yeni=yeni.split("/")[0]+"/"+yeni.split("/")[1]+"/"+yeni.split("/")[2]+"/"+yeni.split("/")[3]+"/"+yeni.split("/")[4]+"/"+yeni.split("/")[5]+"/"+yeni.split("/")[6]+"/"+yeni.split("/")[7]+"/"+(Double.parseDouble(yeni.split("/")[5])-(Double.parseDouble(eski.split("/")[5])-Double.parseDouble(eski.split("/")[8])));
            String hesap = yeni + "\n";
            Files.write(Paths.get("src/files/kredikartlari.txt"), hesap.getBytes(), StandardOpenOption.APPEND);

            BufferedReader reader2 = new BufferedReader(new FileReader("src/files/KrediKartiLimitBasvuru.txt"));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("src/files/KrediKartiLimitBasvuru2.txt"));

            String lineToRemove2 = eski + "/" + yeni.split("/")[5];
            String currentLine2;

            while ((currentLine2 = reader2.readLine()) != null) {

                String trimmedLine2 = currentLine2.trim();
                if (trimmedLine2.equals(lineToRemove2)) {
                    continue;
                }
                writer2.write(currentLine2 + System.getProperty("line.separator"));
            }
            writer2.close();
            reader2.close();
            File file3 = new File("src/files/KrediKartiLimitBasvuru.txt");
            File file4 = new File("src/files/KrediKartiLimitBasvuru2.txt");
            file3.delete();
            file4.renameTo(new File("src/files/KrediKartiLimitBasvuru.txt"));
            File f2 = new File("src/files/KrediKartiLimitBasvuru2.txt");
            f2.delete();
        } catch (IOException e) {
        }
        JOptionPane.showMessageDialog(null, "Limit güncelleme başvurusu onaylandı!");

    }
    public static void limitSil(String yeni, String eski) {
        try {
            BufferedReader reader2 = new BufferedReader(new FileReader("src/files/KrediKartiLimitBasvuru.txt"));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("src/files/KrediKartiLimitBasvuru2.txt"));

            String lineToRemove2 = eski + "/" + yeni.split("/")[5];
            String currentLine2;

            while ((currentLine2 = reader2.readLine()) != null) {

                String trimmedLine2 = currentLine2.trim();
                if (trimmedLine2.equals(lineToRemove2)) {
                    continue;
                }
                writer2.write(currentLine2 + System.getProperty("line.separator"));
            }
            writer2.close();
            reader2.close();
            File file3 = new File("src/files/KrediKartiLimitBasvuru.txt");
            File file4 = new File("src/files/KrediKartiLimitBasvuru2.txt");
            file3.delete();
            file4.renameTo(new File("src/files/KrediKartiLimitBasvuru.txt"));
            File f2 = new File("src/files/KrediKartiLimitBasvuru2.txt");
            f2.delete();
        } catch (IOException e) {
        }
        JOptionPane.showMessageDialog(null, "Limit güncelleme başvurusu silindi!");

    }

    public static void kartSil(String a) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/files/krediKartiBasvuru.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/files/krediKartiBasvuru2.txt"));

            String lineToRemove = a;
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {

                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(lineToRemove)) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            File file1 = new File("src/files/krediKartiBasvuru.txt");
            File file2 = new File("src/files/krediKartiBasvuru2.txt");
            file1.delete();
            file2.renameTo(new File("src/files/krediKartiBasvuru.txt"));
            File f1 = new File("src/files/krediKartiBasvuru2.txt");
            f1.delete();
        } catch (IOException e) {

        }
        JOptionPane.showMessageDialog(null, "Kredi kartı başvurusu silindi!");

    }

    public static void krediOnay(String a, String neden) {
        try {
            String hesap = a + "\n";
            Files.write(Paths.get("src/files/krediler.txt"), hesap.getBytes(), StandardOpenOption.APPEND);

            BufferedReader reader = new BufferedReader(new FileReader("src/files/krediBasvuru.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/files/krediBasvuru2.txt"));

            String lineToRemove = a + "/" + neden;

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {

                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(lineToRemove)) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            File file1 = new File("src/files/krediBasvuru.txt");
            File file2 = new File("src/files/krediBasvuru2.txt");
            file1.delete();
            file2.renameTo(new File("src/files/krediBasvuru.txt"));
            File f1 = new File("src/files/krediBasvuru2.txt");
            f1.delete();
        } catch (IOException e) {

        }
        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/files/hesaplar.txt"), StandardCharsets.UTF_8));
            for (int j = 0; j < fileContent.size(); j++) {
                if (fileContent.get(j).split("/")[0].equals(a.split("/")[0])) {
                    fileContent.set(j, fileContent.get(j).split("/")[0]+"/"+fileContent.get(j).split("/")[1]+"/"+fileContent.get(j).split("/")[2]+"/"+(Double.parseDouble(fileContent.get(j).split("/")[3])+Double.parseDouble(a.split("/")[1]))+"/"+fileContent.get(j).split("/")[4]);
                    break;
                }
            }
            Files.write(Paths.get("src/files/hesaplar.txt"), fileContent, StandardCharsets.UTF_8);
        } catch (IOException ex) {
        }
        JOptionPane.showMessageDialog(null, "Kredi başvurusu onaylandı!");

    }

    public static void krediSil(String a, String neden) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/files/krediBasvuru.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/files/krediBasvuru2.txt"));

            String lineToRemove = a + "/" + neden;

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {

                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(lineToRemove)) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            File file1 = new File("src/files/krediBasvuru.txt");
            File file2 = new File("src/files/krediBasvuru2.txt");
            file1.delete();
            file2.renameTo(new File("src/files/krediBasvuru.txt"));
            File f1 = new File("src/files/krediBasvuru2.txt");
            f1.delete();
        } catch (IOException e) {

        }
        JOptionPane.showMessageDialog(null, "Kredi başvurusu silindi!");

    }

    public ArrayList<Object[]> kartGetir() {
        ArrayList<Object[]> temp = new ArrayList<>();
        for (int i = 0; i < kartno.size(); i++) {
            Object[] obj = {i + 1, kartkimlik.get(i), kart_adi.get(i), kartno.get(i), kart_ay.get(i), kart_yil.get(i), kart_limit.get(i), kart_cvv.get(i), kart_ekstre.get(i)};
            temp.add(obj);
        }
        return temp;
    }

    public void setkredikartlariTbl(JTable kartlarTbl) throws IOException {
        File file = new File("src/files/krediKartiBasvuru.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        kartkimlik.clear();
        kartno.clear();
        kart_adi.clear();
        kart_limit.clear();
        kart_ay.clear();
        kart_yil.clear();
        kart_cvv.clear();
        kart_ekstre.clear();
        kart_bakiye.clear();
        while ((st = br.readLine()) != null) {
            kartkimlik.add(st.split("/")[0]);
            kartno.add(st.split("/")[1]);
            kart_ay.add(st.split("/")[2]);
            kart_yil.add(st.split("/")[3]);
            kart_cvv.add(st.split("/")[4]);
            kart_limit.add(st.split("/")[5]);
            kart_adi.add(st.split("/")[6]);
            kart_ekstre.add(st.split("/")[7]);
            kart_bakiye.add(st.split("/")[8]);
        }
        br.close();
    }
    @Override
    public void girisyapildi(){
    JOptionPane.showMessageDialog(null, "Çalışan girişi yapıldı.");
}
}

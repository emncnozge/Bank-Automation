package bankacilik;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public abstract class Kullanici {

    private String ad, soyad, annekizlik, tel, email, dgmgn, hesap, sifre = "";
    private long tc;
    ArrayList<String> hesaplar = new ArrayList<>();
    ArrayList<String> hesap_adi = new ArrayList<>();
    ArrayList<String> tur = new ArrayList<>();
    ArrayList<String> kartno = new ArrayList<>();
    ArrayList<String> kart_adi = new ArrayList<>();
    ArrayList<String> kart_ay = new ArrayList<>();
    ArrayList<String> kart_yil = new ArrayList<>();
    ArrayList<String> kart_limit = new ArrayList<>();
    ArrayList<String> kart_bakiye = new ArrayList<>();
    ArrayList<String> kart_cvv = new ArrayList<>();
    ArrayList<String> kart_ekstre = new ArrayList<>();
    ArrayList<String> kredimiktari = new ArrayList<>();
    ArrayList<String> kredikalanborc = new ArrayList<>();
    ArrayList<String> kredisonodeme = new ArrayList<>();

    public String getAnnekizlik() {
        return annekizlik;
    }

    public void setAnnekizlik(String annekizlik) {
        this.annekizlik = annekizlik;
    }

    public Kullanici(long tc) {
        this.tc = tc;
        setAd("");
        setSoyad("");
        setTel("");
        setEmail("");
        setDgmgn("");
        setHesap("");
        setSifre("");
        setAnnekizlik("");
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDgmgn() {
        return dgmgn;
    }

    public void setDgmgn(String dgmgn) {
        this.dgmgn = dgmgn;
    }

    public String getHesap() {
        return hesap;
    }

    public void setHesap(String hesap) {
        this.hesap = hesap;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public long getTc() {
        return tc;
    }

    public void setTc(long tc) {
        this.tc = tc;
    }
    public void girisyapildi() {
        JOptionPane.showMessageDialog(null, "Kullanıcı girişi yapıldı.");
    }
    public static void giristmm(Kullanici k1){
    k1.girisyapildi();
}
}

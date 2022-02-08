package bankacilik;

import java.io.IOException;
import javax.swing.JTable;

public interface IParaIslemleri {

    public void paraGonder(Musteri m1, String iban, String iban2, String miktar, JTable hesaplarTbl) throws IOException;

    public void paraYatir(Musteri m1, String iban, String miktar, JTable hesaplarTbl) throws IOException;

    public void paraCek(Musteri m1, String iban, String miktar, JTable hesaplarTbl) throws IOException;

}

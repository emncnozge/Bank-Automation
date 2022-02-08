package bankacilik;

public interface IDegistir {

    public void sifreDegistir(Musteri m1, String eskisifre, String yenisifre);

    public void mailDegistir(Musteri m1, String mail);

    public void telDegistir(Musteri m1, String tel);
}

public class Zamowienie {
    protected String nazwaTowaru;
    protected int cenaJednostkowa;
    protected int ilosc;

    public Zamowienie(String nazwaTowaru, int cenaJednostkowa, int ilosc) {
        this.nazwaTowaru = nazwaTowaru;
        this.cenaJednostkowa = cenaJednostkowa;
        this.ilosc = ilosc;
    }

}

import java.util.concurrent.ThreadLocalRandom;

public class Klient {
    protected String nazwaKlienta;
    protected FIFO<Zamowienie> zamowienia;

    public Klient(String nazwaKlienta, FIFO<Zamowienie> zamowienia) {
        this.nazwaKlienta = nazwaKlienta;
        this.zamowienia = zamowienia;
    }

    public void zamow() {
        Magazyn.GlownaKolejkaKlientow.enqueue(this);
        System.out.println("Klient numer " + this.nazwaKlienta + " złożył zamówienie.");
    }
    public static Klient losowyKlient() {
        String nazwa = "Klient " + ThreadLocalRandom.current().nextInt(1,100);
        FIFO<Zamowienie> zamowienia = new FIFO<>();
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(1,10); i++) {  //Generuje 1-10 zamówień dla każdego klienta.
            String nazwaTowaru = "Towar numer: " + ThreadLocalRandom.current().nextInt(1,100);
            int cenaJednostkowa = ThreadLocalRandom.current().nextInt(1,1000);
            int ilosc = ThreadLocalRandom.current().nextInt(1,10);
            zamowienia.enqueue(new Zamowienie(nazwaTowaru, cenaJednostkowa, ilosc));
        }
        return new Klient(nazwa, zamowienia);
    }

}

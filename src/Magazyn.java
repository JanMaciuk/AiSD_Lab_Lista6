public class Magazyn {
    protected FIFO<Klient> GlownaKolejkaKlientow;
    protected int SumaWszystkichZamowien;

    public Magazyn() {
        GlownaKolejkaKlientow = new FIFO<>();
        SumaWszystkichZamowien = 0;
    }

    public void ObslugaZamowieniaKlienta(Klient klient) {
        int dozaplaty = 0;
        while (!klient.zamowienia.isEmpty()) {
            Zamowienie zamowienie;
            try {
                zamowienie = klient.zamowienia.dequeue();
                dozaplaty += zamowienie.cenaJednostkowa*zamowienie.ilosc;
            }
            catch (Exception e) {e.printStackTrace();} //Wykona się, tylko jeżeli kolejka nie jest pusta, więc błąd powinien być niemożliwy.

        }
        SumaWszystkichZamowien += dozaplaty;
        System.out.println("Zlecenie zrealizowane: " + klient.nazwaKlienta + ". kwota do zapłaty: "+ dozaplaty + " złotych.");
    }

    public void ObslugaWszystkichZamowien() {
        System.out.println("\n"+"Rozpoczęcie realizacji zamówień klientów w kolejności ich złożenia:");
        while (!GlownaKolejkaKlientow.isEmpty()) {
            try { ObslugaZamowieniaKlienta(GlownaKolejkaKlientow.dequeue()); }
            catch (Exception e) {e.printStackTrace();} //Wykona się, tylko jeżeli kolejka nie jest pusta, więc błąd powinien być niemożliwy.
        }
        System.out.println("\n"+"Suma kwot wszystkich zamówień w magazynie: " + SumaWszystkichZamowien + " złotych");
    }
}





import java.util.concurrent.ThreadLocalRandom;

public class Firma {
        protected static FIFO<Magazyn> Magazyny = new FIFO<>();
        protected static int sumaWszystkichZamowien;

        public static void stworzMagazynyZamowienia() {
            for (int i = 0; i < ThreadLocalRandom.current().nextInt(2,5); i++) {  //Ile magazynow ma firma
                Magazyn magazyn = new Magazyn();
                for (int j = 0; j < ThreadLocalRandom.current().nextInt(3,10); j++) {Klient.losowyKlient().zamow(magazyn);}
                Magazyny.enqueue(magazyn);
            }
        }

        public static void ObslugaWszystkichZamowien() {
            while (!Magazyny.isEmpty()) {
                System.out.println("\n"+"Obsługa zamówień w magazynie numer: " + Magazyny.size());
                try {
                    Magazyn magazyn = Magazyny.dequeue();
                    magazyn.ObslugaWszystkichZamowien();
                    sumaWszystkichZamowien += magazyn.SumaWszystkichZamowien;
                } catch (Exception e) {
                    System.out.println("Błąd przy obsłudze zamówień.");
                }
            }
            System.out.println("Suma przychodów firmy: " + sumaWszystkichZamowien);
        }


}

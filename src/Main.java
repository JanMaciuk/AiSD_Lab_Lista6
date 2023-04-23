import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(2,12); i++) {  //Ilu klientów złoży zamówienie tego dnia
            Klient.losowyKlient().zamow();
        }
        Magazyn.ObslugaWszystkichZamowien();
    }



}



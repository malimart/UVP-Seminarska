import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ucbenik extends Gradivo{

    // polja

    private String predmet;
    private String zahtevnost;

    // konstruktorji

    public Ucbenik() {
    }

    public Ucbenik(String naslov, String avtor, String vrstaGradiva, int letoIzdaje, int sifra, String[] kljucneBesede, String status, String predmet, String zahtevnost) {
        super(naslov, avtor, vrstaGradiva, letoIzdaje, sifra, kljucneBesede, status);
        this.predmet = predmet;
        this.zahtevnost = zahtevnost;
    }

    // set metode

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public void setZahtevnost(String zahtevnost) {
        this.zahtevnost = zahtevnost;
    }

    // get metode

    public String getPredmet() {
        return predmet;
    }

    public String getZahtevnost() {
        return zahtevnost;
    }

    // metoda za vnos

    public static Ucbenik vnesiGradivo() throws Exception {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String predmet;
        String zahtevnost;

        Gradivo gradivo = Gradivo.vnesiGradivo();

        String naslov = gradivo.getNaslov();
        String avtor = gradivo.getAvtor();
        String vrstaGradiva = "Ucbenik";
        int letoIzdaje = gradivo.getLetoIzdaje();
        int sifra = gradivo.getSifra();
        String kljucneBesede[] = gradivo.getKljucneBesede();
        String status = gradivo.getStatus();

        System.out.print("Predmet: ");
        predmet = bufferedReader.readLine();
        System.out.print("Zahtevnost: ");
        zahtevnost = bufferedReader.readLine();

        Ucbenik ucbenik = new Ucbenik(naslov, avtor, vrstaGradiva, letoIzdaje, sifra, kljucneBesede, status, predmet, zahtevnost);

        return ucbenik;
    }

    // metoda za izpis gradiva

    public void izpis() {
        super.izpis();
        System.out.println("Predmet: " + this.predmet);
        System.out.println("Zahtevnost: " + this.zahtevnost);
    }
}

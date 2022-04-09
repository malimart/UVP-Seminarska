import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TiskaniUcbenik extends Ucbenik {

    // polja

    private String vrstaVezave;

    // konstruktorji

    public TiskaniUcbenik() {
    }

    public TiskaniUcbenik(String naslov, String avtor, String vrstaGradiva, int letoIzdaje, int sifra, String[] kljucneBesede, String status, String predmet, String zahtevnost, String vrstaVezave) {
        super(naslov, avtor, vrstaGradiva, letoIzdaje, sifra, kljucneBesede, status, predmet, zahtevnost);
        this.vrstaVezave = vrstaVezave;
    }

    // set metode

    public void setVrstaVezave(String vrstaVezave) {
        this.vrstaVezave = vrstaVezave;
    }

    // get metode

    public String getVrstaVezave() {
        return vrstaVezave;
    }

    // metoda za vnos

    public static TiskaniUcbenik vnesiGradivo() throws Exception {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String vrstaVezave;

        Ucbenik ucbenik = Ucbenik.vnesiGradivo();

        String naslov = ucbenik.getNaslov();
        String avtor = ucbenik.getAvtor();
        String vrstaGradiva = "Tiskani ucbenik";
        int letoIzdaje = ucbenik.getLetoIzdaje();
        int sifra = ucbenik.getSifra();
        String kljucneBesede[] = ucbenik.getKljucneBesede();
        String status = ucbenik.getStatus();
        String predmet = ucbenik.getPredmet();
        String zahtevnost = ucbenik.getZahtevnost();

        System.out.print("Vrsta vezave: ");
        vrstaVezave = bufferedReader.readLine();

        TiskaniUcbenik tiskaniUcbenik = new TiskaniUcbenik(naslov, avtor, vrstaGradiva, letoIzdaje, sifra, kljucneBesede, status, predmet, zahtevnost, vrstaVezave);

        return tiskaniUcbenik;
    }

    // metoda za izpis gradiva

    public void izpis() {
        super.izpis();
        System.out.println("Vrsta vezave: " + this.vrstaVezave);
    }
}

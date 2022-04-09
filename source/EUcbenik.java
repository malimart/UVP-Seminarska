import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EUcbenik extends Ucbenik {

    // polja

    private String formatDatoteke;

    // konstruktorji

    public EUcbenik() {
    }

    public EUcbenik(String naslov, String avtor, String vrstaGradiva, int letoIzdaje, int sifra, String[] kljucneBesede, String status, String predmet, String zahtevnost, String formatDatoteke) {
        super(naslov, avtor, vrstaGradiva, letoIzdaje, sifra, kljucneBesede, status, predmet, zahtevnost);
        this.formatDatoteke = formatDatoteke;
    }

    // set metode

    public void setFormatDatoteke(String formatDatoteke) {
        this.formatDatoteke = formatDatoteke;
    }

    // get metode

    public String getFormatDatoteke() {
        return formatDatoteke;
    }

    // metoda za vnos

    public static EUcbenik vnesiGradivo() throws Exception {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String formatDatoteke;

        Ucbenik ucbenik = Ucbenik.vnesiGradivo();

        String naslov = ucbenik.getNaslov();
        String avtor = ucbenik.getAvtor();
        String vrstaGradiva = "eUcbenik";
        int letoIzdaje = ucbenik.getLetoIzdaje();
        int sifra = ucbenik.getSifra();
        String kljucneBesede[] = ucbenik.getKljucneBesede();
        String status = ucbenik.getStatus();
        String predmet = ucbenik.getPredmet();
        String zahtevnost = ucbenik.getZahtevnost();

        System.out.print("Format datoteke: ");
        formatDatoteke = bufferedReader.readLine();

        EUcbenik eUcbenik = new EUcbenik(naslov, avtor, vrstaGradiva, letoIzdaje, sifra, kljucneBesede, status, predmet, zahtevnost, formatDatoteke);

        return eUcbenik;
    }

    // metoda za izpis gradiva

    public void izpis() {
        super.izpis();
        System.out.println("Format datoteke: " + this.formatDatoteke);
    }

}

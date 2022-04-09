import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Roman extends Gradivo {

    // polja

    private String zvrst;
    private int steviloStrani;

    // konstruktorji

    public Roman() {
    }

    public Roman(String naslov, String avtor, String vrstaGradiva, int letoIzdaje, int sifra, String[] kljucneBesede, String status, String zvrst, int steviloStrani) {
        super(naslov, avtor, vrstaGradiva, letoIzdaje, sifra, kljucneBesede, status);
        this.zvrst = zvrst;
        this.steviloStrani = steviloStrani;
    }

    // set metode

    public void setZvrst(String zvrst) {
        this.zvrst = zvrst;
    }

    public void setSteviloStrani(int steviloStrani) {
        this.steviloStrani = steviloStrani;
    }

    // get metode

    public String getZvrst() {
        return zvrst;
    }

    public int getSteviloStrani() {
        return steviloStrani;
    }

    // metoda za vnos romana

    public static Roman vnesiGradivo() throws Exception {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String zvrst;
        int steviloStrani;

        Gradivo gradivo = Gradivo.vnesiGradivo();

        String naslov = gradivo.getNaslov();
        String avtor = gradivo.getAvtor();
        String vrstaGradiva = "Roman";
        int letoIzdaje = gradivo.getLetoIzdaje();
        int sifra = gradivo.getSifra();
        String kljucneBesede[] = gradivo.getKljucneBesede();
        String status = gradivo.getStatus();

        System.out.print("Zvrst: ");
        zvrst = bufferedReader.readLine();
        System.out.print("Stevilo strani: ");
        steviloStrani = Integer.parseInt(bufferedReader.readLine());

        Roman roman = new Roman(naslov, avtor, vrstaGradiva, letoIzdaje, sifra, kljucneBesede, status, zvrst, steviloStrani);

        return roman;
    }

    // metoda za izpis gradiva

    public void izpis() {
        super.izpis();
        System.out.println("Zvrst: " + this.zvrst);
        System.out.println("Stevilo strani: " + this.steviloStrani);
    }
}

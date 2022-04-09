import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Glasba extends Gradivo {

    // polja

    private String zvrst;
    private int dolzinaPosnetka;

    // konstruktorji

    public Glasba() {
    }

    public Glasba(String naslov, String avtor, String vrstaGradiva, int letoIzdaje, int sifra, String[] kljucneBesede, String status, String zvrst, int dolzinaPosnetka) {
        super(naslov, avtor, vrstaGradiva, letoIzdaje, sifra, kljucneBesede, status);
        this.zvrst = zvrst;
        this.dolzinaPosnetka = dolzinaPosnetka;
    }

    // set metode

    public void setZvrst(String zvrst) {
        this.zvrst = zvrst;
    }

    public void setDolzinaPosnetka(int dolzinaPosnetka) {
        this.dolzinaPosnetka = dolzinaPosnetka;
    }

    // get metode

    public String getZvrst() {
        return zvrst;
    }

    public int getDolzinaPosnetka() {
        return dolzinaPosnetka;
    }

    // metoda za vnos

    public static Glasba vnesiGradivo() throws Exception {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String zvrst;
        int dolzinaPosnetka;

        Gradivo gradivo = Gradivo.vnesiGradivo();

        String naslov = gradivo.getNaslov();
        String avtor = gradivo.getAvtor();
        String vrstaGradiva = "Glasba";
        int letoIzdaje = gradivo.getLetoIzdaje();
        int sifra = gradivo.getSifra();
        String kljucneBesede[] = gradivo.getKljucneBesede();
        String status = gradivo.getStatus();

        System.out.print("Zvrst: ");
        zvrst = bufferedReader.readLine();
        System.out.print("Dolzina posnetka (min): ");
        dolzinaPosnetka = Integer.parseInt(bufferedReader.readLine());

        Glasba glasba = new Glasba(naslov, avtor, vrstaGradiva, letoIzdaje, sifra, kljucneBesede, status, zvrst, dolzinaPosnetka);

        return glasba;
    }

    // metoda za izpis gradiva

    public void izpis() {
        super.izpis();
        System.out.println("Zvrst: " + this.zvrst);
        System.out.println("Dolzina posnetka (min): " + this.dolzinaPosnetka);
    }
}

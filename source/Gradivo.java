import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Gradivo {

    // polja

    private String naslov;
    private String avtor;
    private String vrstaGradiva;
    private int letoIzdaje;
    private int sifra;
    private String kljucneBesede[];
    private String status;

    // konstruktorji

    public Gradivo() {
    }

    public Gradivo(String naslov, String avtor, String vrstaGradiva, int letoIzdaje, int sifra, String[] kljucneBesede, String status) {
        this.naslov = naslov;
        this.avtor = avtor;
        this.vrstaGradiva = vrstaGradiva;
        this.letoIzdaje = letoIzdaje;
        this.sifra = sifra;
        this.kljucneBesede = kljucneBesede;
        this.status = status;
    }

    // set metode

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public void setAvtor(String avtor) {
        this.avtor = avtor;
    }

    public void setVrstaGradiva(String vrstaGradiva) {
        this.vrstaGradiva = vrstaGradiva;
    }

    public void setLetoIzdaje(int letoIzdaje) {
        this.letoIzdaje = letoIzdaje;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public void setKljucneBesede(String[] kljucneBesede) {
        this.kljucneBesede = kljucneBesede;
    }

    public void setStatus(String status) {
        status = status.toLowerCase();
        if (status.equals("prosto") || status.equals("rezervirano") || status.equals("izposojeno")) {
            this.status = status;
        } else {
            System.out.println("* Napaka pri vnosu statusa, poskusite ponovno.\n");
        }
    }

    // get metode

    public String getNaslov() {
        return naslov;
    }

    public String getAvtor() {
        return avtor;
    }

    public String getVrstaGradiva() {
        return vrstaGradiva;
    }

    public int getLetoIzdaje() {
        return letoIzdaje;
    }

    public int getSifra() {
        return sifra;
    }

    public String[] getKljucneBesede() {
        return kljucneBesede;
    }

    public String getStatus() {
        return status;
    }

    // metoda za vnos gradiva

    public static Gradivo vnesiGradivo() throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String naslov;
        String avtor;
        // String vrstaGradiva;
        int letoIzdaje;
        int sifra;
        String kljucneBesede[];
        String status;

        System.out.println("* Vnos novega gradiva *");
        System.out.print("Naslov: ");
        naslov = bufferedReader.readLine();
        System.out.print("Avtor: ");
        avtor = bufferedReader.readLine();
        // System.out.print("Vrsta gradiva: ");
        // vrstaGradiva = bufferedReader.readLine();
        System.out.print("Leto izdaje: ");
        letoIzdaje = Integer.parseInt(bufferedReader.readLine());
        System.out.print("Sifra: ");
        sifra = Integer.parseInt(bufferedReader.readLine());
        System.out.print("Vnesi kljucne besede (locene s presledkom): ");
        String niz = bufferedReader.readLine();
        kljucneBesede = niz.trim().split("\\s* \\s*");
        // potrebna validacija
        System.out.print("Status (Prosto, Izposojeno, Rezervirano): ");
        status = bufferedReader.readLine();

        Gradivo gradivo = new Gradivo(naslov, avtor, "neznana", letoIzdaje, sifra, kljucneBesede, status);
        return gradivo;
    }

    // metoda za izpis gradiva

    public void izpis() {
        System.out.println("* Podatki o gradivu *");
        System.out.println("Naslov: " + this.getNaslov());
        System.out.println("Avtor: " + this.getAvtor());
        System.out.println("Vrsta gradiva: " + this.getVrstaGradiva());
        System.out.println("Leto izdaje: " + this.getLetoIzdaje());
        System.out.println("Sifra: " + this.getSifra());
        System.out.print("Kljucne besede: ");

        for (String string : this.kljucneBesede) {
            System.out.print(string + " ");
        }
        System.out.println("\nStatus: " + this.getStatus());
    }

    // metoda za pretvorbo gradiva v niz

    public String shraniKotNiz() {

        String niz = "*Gradivo*\r\n";

        niz += this.naslov + "\r\n";
        niz += this.avtor + "\r\n";
        niz += this.vrstaGradiva + "\r\n";
        niz += this.letoIzdaje + "\r\n";
        niz += this.sifra + "\r\n";
        for (String beseda : this.kljucneBesede) {
            niz += beseda + "\r\n";
        }
        niz += this.status + "\r\n";
        niz += "**\r\n";

        return niz;
    }

    // metoda za ustvarjanje novega gradiva iz podatkov iz datoteke

    public static Gradivo preberiIzNiza(ArrayList<String> podatkiOGradivu) {

        String kljucneBesede[] = podatkiOGradivu.get(5).trim().split("\\s* \\s*");;

        try {
            Gradivo gradivo = new Gradivo(podatkiOGradivu.get(0), podatkiOGradivu.get(1), podatkiOGradivu.get(2),
                    Integer.parseInt(podatkiOGradivu.get(3)), Integer.parseInt(podatkiOGradivu.get(4)),
                    kljucneBesede, podatkiOGradivu.get(6));

            return gradivo;

        } catch (Exception e) {

            System.out.println("* Napaka pri pretvarjanju, poskusite ponovno.\n");
            throw e;
        }
    }
}

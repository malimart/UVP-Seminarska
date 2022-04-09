import java.io.*;
import java.util.ArrayList;

public class Polica {

    // polja

    private ArrayList<Gradivo> polica;

    // konstruktorji

    public Polica() {
        this.polica = new ArrayList<Gradivo>();
    }

    // get metode

    public ArrayList<Gradivo> getPolica() {
        return polica;
    }

    // dodaj gradivo na polico

    public void dodajGradivo(Gradivo gradivo) {
        if (preveriSifro(gradivo)) {
            System.out.println("* Gradivo s to sifro ze obstaja.\n");
        } else {
            this.polica.add(gradivo);
            System.out.println("* Gradivo je bilo uspesno vneseno.\n");
        }
    }

    // preveri sifro

    public boolean preveriSifro(Gradivo gradivo) {
        int sifra = gradivo.getSifra();
        int temp;

        for (int i = 0; i < this.polica.size(); i++) {
            temp = this.polica.get(i).getSifra();
            if (sifra == temp) {
                return true;
            }
        }
        return false;
    }

    // metoda za izpis

    public void izpis() {
        int flag = 0;
        if (getPolica().size() > 0) {
            for (int i = 0; i < getPolica().size(); i++) {
                getPolica().get(i).izpis();
                System.out.println();
                flag++;
            }
            if (flag > 0) {
                System.out.printf("* Izpisanih je bilo %d kom. gradiva.\n\n", flag);
            }
        } else {
            System.out.println("* Polica je prazna.\n");
        }
    }

    // metoda za izbris

    public void izbris() throws Exception {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        if (getPolica().size() > 0) {

            int flag = 0;

            System.out.print("Vnesi sifro gradiva za izbris: ");
            int sifra = Integer.parseInt(bufferedReader.readLine());

            for (int i = 0; i < getPolica().size(); i++) {
                if (sifra == getPolica().get(i).getSifra()) {
                    getPolica().remove(i);
                    System.out.println("* Gradivo je bilo uspesno izbrisano.\n");
                    flag++;
                }
            }
            if (flag == 0) {
                System.out.println("* Gradivo s to sifro ne obstaja.\n");
            }
        } else {
            System.out.println("* Polica je ze prazna.\n");
        }
    }

    // spremeni status gradiva (prosto, rezervirazno, izposojeno)

    public void spremeniStatus() throws Exception {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        if (getPolica().size() > 0) {
            System.out.print("Vnesi sifro gradiva za spremembo statusa: ");
            int sifra = Integer.parseInt(bufferedReader.readLine());

            zanka:
            for (int i = 0; i < getPolica().size(); i++) {
                if (sifra == getPolica().get(i).getSifra()) {

                    System.out.println("Izberi nov status: ");
                    System.out.println("(1) Prosto");
                    System.out.println("(2) Rezervirano");
                    System.out.println("(3) Izposojeno");

                    String status = bufferedReader.readLine();
                    char znak = status.charAt(0);

                    switch (znak) {
                        case '1':
                            getPolica().get(i).setStatus("Prosto");
                            break;
                        case '2':
                            getPolica().get(i).setStatus("Rezervirano");
                            break;
                        case '3':
                            getPolica().get(i).setStatus("Izposojeno");
                            break;
                        default:
                            System.out.println("* Izbira ni pravilna, poskusite ponovno.\n");
                            break zanka;
                    }
                    System.out.println("* Nov status gradiva: " + getPolica().get(i).getStatus() + "\n");
                    return;
                } else if (i == (getPolica().size()) - 1) {
                    System.out.println("* Gradivo s to sifro ne obstaja.\n");
                }
            }
        } else {
            System.out.println("* Polica je prazna.\n");
        }
    }

    // metode za iskanje gradiva po sifri

    public void isciPoSifri(int sifra) {

        if (getPolica().size() > 0) {

            for (int i = 0; i < getPolica().size(); i++) {
                if (sifra == getPolica().get(i).getSifra()) {
                    getPolica().get(i).izpis();
                    System.out.println();
                    return;
                } else if (i == (getPolica().size() - 1)) {
                    System.out.println("* Gradivo s to sifro ne obstaja.\n");
                }
            }
        } else {
            System.out.println("* Polica je prazna.\n");
        }
    }

    // metode za iskanje gradiva po kljucni besedi

    public void isciPoKljucniBesedi(String beseda) {

        beseda = beseda.toLowerCase();
        int flag = 0;

        if (getPolica().size() > 0) {

            for (int i = 0; i < this.polica.size(); i++) {

                String tabelaBesed[] = this.polica.get(i).getKljucneBesede();

                for (int j = 0; j < tabelaBesed.length; j++) {

                    if (beseda.equals(tabelaBesed[j].toLowerCase())) {
                        this.polica.get(i).izpis();
                        System.out.println();
                        flag++;
                    }
                }
            }
            if (flag > 0) {
                System.out.printf("* Izpisanih je bilo %d kom. gradiva.\n\n", flag);
            }
            if (flag == 0) {
                System.out.println("* Nobeno gradivo ne ustreza danemu kriteriju.\n");
            }
        } else {
            System.out.println("* Polica je prazna.\n");
        }

    }

    // metoda za iskanje gradiva po statusu

    public void isciPoStatusu(String status) {

        int flag = 0;

        if (getPolica().size() > 0) {

            for (int i = 0; i < getPolica().size(); i++) {
                if (status.equals(getPolica().get(i).getStatus().toLowerCase())) {
                    getPolica().get(i).izpis();
                    System.out.println();
                    flag++;
                } if (flag == 0) {
                    System.out.println("* Nobeno gradivo ne ustreza danemu kriteriju.\n");
                }
            }
            if (flag > 0) {
                System.out.printf("* Izpisanih je bilo %d kom. gradiva.\n\n", flag);
            }
        } else {
            System.out.println("* Polica je prazna.\n");
        }
    }

    // metoda za zapis gradiva v datoteko

    public void shraniVDatoteko(String imeDatoteke) throws IOException {
        FileWriter fileWriter = new FileWriter(imeDatoteke);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (Gradivo gradivo : this.polica) {
            printWriter.print(gradivo.shraniKotNiz());
        }
        printWriter.close();
    }

    // metoda za branje gradiva iz datoteke

    public void beriIzDatoteke(String imeDatoteke) throws Exception {

        FileReader fileReader = new FileReader(imeDatoteke);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        ArrayList<String> podatkiOGradivu;
        int stevec = 0;

        while (bufferedReader.ready()) {
            String vrstica = bufferedReader.readLine().trim();

            if (vrstica.equals("*Gradivo*")) {

                podatkiOGradivu = new ArrayList<String>();

                while (bufferedReader.ready() && !vrstica.equals("**")) {
                    vrstica = bufferedReader.readLine();
                    podatkiOGradivu.add(vrstica);
                }

                Gradivo gradivo = Gradivo.preberiIzNiza(podatkiOGradivu);

                // dodajGradivo(gradivo);
                if (!preveriSifro(gradivo)) {
                    this.polica.add(gradivo);
                    stevec++;
                }

            }
        }
        bufferedReader.close();
        System.out.printf("* Vnesenih je bilo %d kosov gradiva.\n\n", stevec);
    }
}

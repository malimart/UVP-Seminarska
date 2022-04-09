import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UporabniskiVmesnik {

    public static void main(String[] args) {

        System.out.println("\n*** KNJIZNICA v0.1 ***\n");

        Polica polica = new Polica();

        while (true) {

            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            System.out.println("Pritisnite (1) za vnos gradiva");
            System.out.println("Pritisnite (2) za izpis gradiva");
            System.out.println("Pritisnite (3) za izbris gradiva");
            System.out.println("Pritisnite (4) za spremembo statusa gradiva");
            System.out.println("Pritisnite (5) za iskanje gradiva");
            System.out.println("Pritisnite (6) za vnos gradiva iz datoteke");
            System.out.println("Pritisnite (7) za zapis vsega gradiva v datoteko");
            System.out.println("Pritisnite (x) za izhod iz programa");

            String vnos;

            try {
                vnos = bufferedReader.readLine();
                char prviZnak = vnos.charAt(0);

                switch (prviZnak) {
                    case '1':
                        System.out.println("Izberi vrsto gradiva: ");
                        System.out.println("(1) Roman");
                        System.out.println("(2) Ucbenik");
                        System.out.println("(3) Glasba");
                        System.out.println("(4) Videoposnetek");
                        System.out.println("(5) Poljubno gradivo");

                        vnos = bufferedReader.readLine();
                        prviZnak = vnos.charAt(0);

                        switch (prviZnak) {
                            case '1':
                                Roman roman = Roman.vnesiGradivo();
                                polica.dodajGradivo(roman);
                                break;
                            case '2':
                                System.out.println("Izberi vrsto ucbenika: ");
                                System.out.println("(1) Tiskani ucbenik");
                                System.out.println("(2) eUcbenik");

                                vnos = bufferedReader.readLine();
                                prviZnak = vnos.charAt(0);

                                switch (prviZnak) {
                                    case '1':
                                        TiskaniUcbenik tiskaniUcbenik = TiskaniUcbenik.vnesiGradivo();
                                        polica.dodajGradivo(tiskaniUcbenik);
                                        break;
                                    case '2':
                                        EUcbenik eUcbenik = EUcbenik.vnesiGradivo();
                                        polica.dodajGradivo(eUcbenik);
                                        break;
                                    default:
                                        System.out.println("* Izbira ni pravilna, poskusite ponovno.\n");
                                        break;
                                }
                                break;
                            case '3':
                                Glasba glasba = Glasba.vnesiGradivo();
                                polica.dodajGradivo(glasba);
                                break;
                            case '4':
                                Videoposnetek videoposnetek = Videoposnetek.vnesiGradivo();
                                polica.dodajGradivo(videoposnetek);
                                break;
                            case '5':
                                Gradivo gradivo = Gradivo.vnesiGradivo();
                                polica.dodajGradivo(gradivo);
                                break;
                            default:
                                System.out.println("* Izbira ni pravilna, poskusite ponovno.\n");
                                break;
                        }
                        break;
                    case '2':
                        polica.izpis();
                        break;
                    case '3':
                        polica.izbris();
                        break;
                    case '4':
                        polica.spremeniStatus();
                        break;
                    case '5':
                        System.out.println("Izberite kriterij iskanja: ");
                        System.out.println("(1) Kljucna beseda");
                        System.out.println("(2) Status");
                        System.out.println("(3) Sifra");

                        vnos = bufferedReader.readLine();
                        prviZnak = vnos.charAt(0);

                        switch (prviZnak) {
                            case '1':
                                System.out.println("Vnesite kljucno besedo: ");
                                vnos = bufferedReader.readLine();
                                polica.isciPoKljucniBesedi(vnos);
                                break;
                            case '2':
                                System.out.println();
                                System.out.println("Izisi gradivo, ki je: ");
                                System.out.println("(1) Prosto");
                                System.out.println("(2) Rezervirano");
                                System.out.println("(3) Izposojeno");
                                vnos = bufferedReader.readLine();
                                prviZnak = vnos.charAt(0);
                                switch (prviZnak) {
                                    case '1':
                                        polica.isciPoStatusu("prosto");
                                        break;
                                    case '2':
                                        polica.isciPoStatusu("rezervirano");
                                        break;
                                    case '3':
                                        polica.isciPoStatusu("izposojeno");
                                        break;
                                    default:
                                        System.out.println("* Izbira ni pravilna, poskusite ponovno.\n");
                                        break;
                                }
                                break;
                            case '3':
                                System.out.println("Vnesite sifro gradiva: ");
                                vnos = bufferedReader.readLine();
                                int novaSifra = Integer.parseInt(vnos);
                                polica.isciPoSifri(novaSifra);
                                break;
                            default:
                                System.out.println("* Izbira ni pravilna, poskusite ponovno.\n");
                                break;
                        }
                        break;
                    case '6':
                        System.out.println("Vnesi ime datoteke za branje: ");
                        String imeDatoteke = bufferedReader.readLine();
                        polica.beriIzDatoteke(imeDatoteke);
                        break;
                    case '7':
                        System.out.println("Vnesi ime datoteke za shranjevanje: ");
                        String imeDatoteke2 = bufferedReader.readLine();
                        polica.shraniVDatoteko(imeDatoteke2);
                        System.out.println("* Zapis v datoteko uspesno koncan.\n");
                        break;
                    case 'x':
                        System.out.println("* Program je koncan.\n");
                        return;
                    default:
                        System.out.println("* Izbira ni pravilna, poskusite ponovno.\n");
                        break;
                }

            } catch (Exception e) {
                System.out.println("* Napaka pri vnosu, poskusite ponovno.\n");
            }
        }
    }
}
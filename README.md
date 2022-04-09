# UVP-Seminarska
Projektna seminarska naloga za predmet Uvod v programiranje (Java)

Program sestavlja devet razredov. Sedem razredov ja namenjenih razlicnim tipom gradiva. Glavni razred je razred gradivo,
ki ima stiri podrazrede: roman, ucbenik, videoposnetek, glasba. Nadalje ima razred ucbenik sam dva podrazreda: tiskani
ucbenik in eUcbenik.

Razred polica vsebuje seznam v katerega se shranjujejo vsi kosi gradiva. Uporabniski vmesnik pa sluzi kot vmesnik iz
katerega uporabnik klice razlicne metode.

Razred gradivo vsebuje poleg polj, konstruktorjev ter set in get metod tudi ostale metode kot so: metoda za vnos gradiva,
metoda za izpis gradiva, metoda za pretvorbo gradiva v niz in metoda za ustvarjanje novega gradiva iz datoteke.

Razred polica vsebuje metode za dodajanje gradiva na polico (v knjiznico), za preverjanje sifre (vsako gradivo ima enolicno
sifro za identifikacijo), metodo za izpis vsega gradiva na polici, metodo za izbris gradiva iz police na podlagi sifre,
metodo za spremembo statusa gradiva (prosto, rezervirazno, izposojeno), tri metode za iskanje gradiva (na podlagi sifre,
kljucne besede in statusa), ter metodi za dodajanje novega gradiva iz datoteke in zapisovanje vsega gradiva v datoteko.

Prilozena je datoteka seznam.txt, ki vsebuje 15 razlicnih kosov gradiva, ki se lahko uvozijo v program.

V mapi je devet .java datotek z izvorno kodo (main metoda se nahaja v razredu UporabniskiVmesnik),
seznam.txt, ki vsebuje seznam gradiva ter .jar datoteka, ki omogoca zagon programa (java -jar KnjiznicaCrt.jar).

Program sestavlja devet razredov. Sedem razredov ja namenjenih razlicnim tipom gradiva. Glavni razred je razred gradivo,
ki ima �tiri podrazrede: roman, ucbenik, videoposnetek, glasba. Nadalje ima razred ucbenik sam dva podrazreda: tiskani
ucbenik in eUcbenik.

Razred polica vsebuje seznam v katerega se shranjujejo vsi kosi gradiva. Uporabni�ki vmesnik pa slu�i kot vmesnik iz
katerega uporabnik klice razlicne metode.

Razred gradivo vsebuje poleg polj, konstruktorjev ter set in get metod tudi ostale metode kot so: metoda za vnos gradiva,
metoda za izpis gradiva, metoda za pretvorbo gradiva v niz in metoda za ustvarjanje novega gradiva iz podatkov iz datoteke.

Razred polica vsebuje metode za dodajanje gradiva na polico (v knji�nico), za preverjanje �ifre (vsako gradivo ima enolicno
�ifro za identifikacijo), metodo za izpis vsega gradiva na polici, metodo za izbris gradiva iz police na podlagi �ifre,
metodo za spremembo statusa gradiva (prosto, rezervirazno, izposojeno), tri metode za iskanje gradiva (na podlagi �ifre,
kljucne besede in statusa), ter metodi za dodajanje novega gradiva iz datoteke in zapisovanje vsega gradiva v datoteko.

Prilo�ena je datoteka seznam.txt, ki vsebuje 15 razlicnih kosov gradiva, ki se lahko uvozijo v program.

V mapi je devet .java datotek z izvorno kodo (main metoda se nahaja v razredu UporabniskiVmesnik), devet .class datotek,
seznam.txt, ki vsebuje seznam gradiva, readme.txt ki vsebuje ta opis, ter .jar datoteka, ki omogoca zagon programa
(java -jar KnjiznicaCrt.jar).
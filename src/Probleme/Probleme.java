package Probleme;

import java.util.Scanner;

public class Probleme {

        //todo: Scrieti un program "Java" care citeste de la tastatura o fraza de maximum 255 de caractere(litere mari ale alfabetului englez si spatii), ale carei cuvinte sun despartite prin cate un spatiu si afiseaza pe primul rand al ecranunui numarul total al cuvintelor din fraaza
        //      Iar oe rand de ecran in ordine alfabetica, scrise o singura data. consoanele care nu apar in fraza.

        public void solutie1() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduceti  un text");
            String text=scanner.nextLine();
            String solutie = "";
            solutie += "Numarul de cuvinte in text este: " + numarCuvinte(text) + " " ;
            System.out.println(solutie);
            String textFinal = consoaneCareNuAparInFraza(text);
            System.out.println(textFinal);

        }

        private int numarCuvinte(String str) {
            int nr =0;
            String[] split = str.split(" ");
            for (int i =0; i < split.length; i++) {
                nr++;
            }
            return nr;
        }

        private boolean apareInString(String str, char cr) {
            for (int i =0; i < str.length();i++) {
                if (str.charAt(i) == cr) {
                    return true;
                }
            }
            return false;

        }

        private String consoaneCareNuAparInFraza(String str) {
            String consoane = "BCDFGHJKLMNPQRSTVWXYZ";
            String aux = " ";
            for (int i =0; i < consoane.length(); i++) {
                if(apareInString(str,consoane.charAt(i)) == true) {
                    aux+= consoane.charAt(i);
                    aux+= " ";
                }
            }
            return aux;
        }




        //todo: Un sir cu maximum 255 de caractere contine cuvinte separate prin unul sau mai multe spatii. Cuvintele sunt formate numai din litere mici ale alfabetului englez.
        //      Scrieti un program "Java" care cisteste un astfel de sir si il afiseaza modificat, prima si ultima litera a fiecarui cvant fiind afisata ca litera mare.


        public void solutie2() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduceti  un text");
            String text=scanner.nextLine();
            String textFinal = tranformarePcSiUcInLitereMariLaFiecareCuvant(text);
            System.out.println(textFinal);
        }

        private String tranformarePcSiUcInLitereMariLaFiecareCuvant(String str) {
            String[] split = str.split(" ");
            String aux = "";
            for(int i =0; i < split.length; i++) {
                aux += tranformarePrimaSiUltimaLiteraInLitereMari(split[i]);
                aux += " ";
            }
            return aux;
        }
        private String tranformarePrimaSiUltimaLiteraInLitereMari(String str) {
            char pl = Character.toUpperCase(str.charAt(0));
            char ul = Character.toUpperCase(str.charAt(str.length()-1));
            String aux = "";
            for (int i =0; i < str.length(); i++) {
                if (i == 0) {
                    aux+= pl;
                }
                else if (i == str.length()-1) {
                    aux+= ul;
                }
                else {
                    aux+= str.charAt(i);
                }
            }
            return aux;
        }




        //todo: Un sir cu maximum 255 de caractere contine cuvinte separate prin cate un spatiu. Cuvintele sunt formate numai din litere mici ale alfabetului englez.
        //      Scrieti un program "Java" care citeste de la tastatura un astfel de sir si il afiseaza pe ecran modificat, inversand prin oglindire doar cuvintele care incep cu vocala, ca in exemplu.


        void solutie3() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduceti  un text");
            String text=scanner.nextLine();
            String textFinal = inversareCuvinteCareIncepCuVocala(text);
            System.out.println(textFinal);
        }

        public String inversareCuvinteCareIncepCuVocala(String str) {
            String[] split = str.split(" ");
            String aux = "";
            for (int i =0; i < split.length; i++) {
                if (incepeCuVocala(split[i]) == true) {
                    aux+= inversareCuvant(split[i]);
                    aux+= " ";
                }
                else {
                    aux+= split[i];
                    aux+= " ";
                }
            }
            return aux;
        }

        private boolean isVocala(char caracter){
            if(!Character.isAlphabetic(caracter)){
                return false;
            }
            String vocale="AEIOUaeiou";
            return  vocale.contains(caracter+"");
        }

        public boolean incepeCuVocala(String str) {
            if (isVocala(str.charAt(0)) == true) {
                return true;
            }
            return false;
        }

        public String inversareCuvant(String str) {
            String aux = "";
            for (int i = str.length()-1; i >= 0; i--) {
                aux+= str.charAt(i);
            }
            return aux;
        }

}

package cartas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Baraja {
    private static List<Carta> baraja = new ArrayList<>();
    private static Carta noCarta;
    public static Carta getNoCarta() {
        return noCarta;
    }

    public static Map<String, String> graficos = new HashMap<>();
    public Map<String, String> getGr() {
        return graficos;
    }

    // requisito
    private static void Barajar(List<Carta> baraja) {
        Collections.shuffle(baraja);
    }

    // requisito        
    public Carta repartirCarta() {
        if(baraja.size()==0){
            return noCarta;
        } else {
            return baraja.remove(0);
        }
    }
    public Carta ultimaCarta() {
        return baraja.get(baraja.size()-1);
    }

    public boolean vacia(){
        return baraja.size()==0;
    }
    public int quedan(){
        return baraja.size();
    }

    
    static {
        try (Scanner fi = new Scanner(new File("./cartas/cartas.txt"))) {
            String trasera = "", traserah = "", titulo = "", hueco = "", win="", youwin="", youloose="";
            char[] colors = { 'g', 'r', 'c', 'v' };
            int[][] valors = {
                    { 11, 10 }, // as : puntos, valor en jugada
                    { 0, 1 }, // dos
                    { 10, 9 }, // tres
                    { 0, 2 }, // cuatro
                    { 0, 3 }, // cinco
                    { 0, 4 }, // seis
                    { 0, 5 }, // siete
                    { 2, 6 }, // sota
                    { 3, 7 }, // caballo
                    { 4, 8 }, // rey
            };
            for (char palo : colors) {
                for (int[] is : valors) {
                    String ascii = "";
                    for (int i = 0; i < 6; i++)
                        ascii += fi.nextLine() + "\n";
                    Carta c = new Carta(palo, is[0], is[1], ascii);
                    baraja.add(c);
                }
            }
            for (int i = 0; i < 6; i++) trasera += fi.nextLine() + "\n";
            for (int i = 0; i < 6; i++) hueco += fi.nextLine() + "\n";
            traserah = fi.nextLine() + "\n" + fi.nextLine() + "\n" + fi.nextLine();
            titulo = fi.nextLine() + "\n" + fi.nextLine() + "\n" + fi.nextLine();
            win =fi.nextLine() + "\n" + fi.nextLine();
            for (int i = 0; i < 8; i++) youwin += fi.nextLine() + "\n";
            for (int i = 0; i < 8; i++) youloose += fi.nextLine() + "\n";
            graficos.put("titulo", titulo);
            graficos.put("trasera", trasera);
            graficos.put("traserah", traserah);
            graficos.put("hueco", hueco);
            graficos.put("win",win);
            graficos.put("youwin", youwin);
            graficos.put("youloose",youloose);
            fi.close();
            noCarta= new Carta('n',-1000,0,graficos.get("hueco"));
            Barajar(baraja);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import cartas.*;

public class leefich {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        int hor=70,ver=24,ch=7,cv=6;
        int pm=0,pp=0; //puntuación
        Pantalla pan = new Pantalla(hor , ver);
        List<Carta> baraja = new ArrayList<>();
        Map<String,String> graficos = new HashMap<>();        
        getValors(baraja,graficos);
        Carta noCarta= new Carta('n',0,0,graficos.get("hueco"));
        Carta trasera= new Carta('w',0,0,graficos.get("trasera"));
        //Carta[] mano = {noCarta,noCarta,noCarta};
        //Carta[] manom= {noCarta,noCarta,noCarta};
        Carta[] mano = {noCarta,noCarta,noCarta};
        Carta[] mosmaq= {noCarta,noCarta,noCarta};
        Carta[] manom= new Carta[3];
        Barajar(baraja); // Barajar
        Carta ultima=baraja.get(baraja.size()-1);
        char triunfos=ultima.getPalo();
               
        for (int i = 0; i < 3; i++) {
            if (mano[i]==null && baraja.size()>0 ) mano[i]=repartirCarta(baraja);
        }
        for (int i = 0; i < 3; i++) {
            if (manom[i]==null && baraja.size()>0 ) mano[i]=repartirCarta(baraja);
        }

        int v=5;
        pan.situa(hor-1-(1*ch),v,ultima.toString(),triunfos);
        //pan.situa(hor+2-(1*ch),v+1,graficos.get("trasera"),'w');
        pan.situa(hor-(1*ch)-3,v+4,graficos.get("traserah"),'w');
        pan.marc();
        pan.marc(0,0,hor-7-1,v,'l','n');
        pan.marc(0,0,hor-14-2,v,'l','n');
        pan.situa(hor-7-1,1,"PERSONA",'w');
        String stp= Integer.toString(pp);
        pan.situa(hor-7-1+((7-stp.length())/2),3,stp,'w');
        stp= Integer.toString(pm);
        pan.situa(hor-14-2,1,"MÁQUINA",'w');
        pan.situa(hor-14-2+((7-stp.length())/2),3,stp,'w');
        pan.marc(0,0,hor,v,'d','l');
        pan.situa(2,1,graficos.get("titulo"),'w');
        pan.situa(1,v,graficos.get("trasera"),'w');
        pan.situa(1+ch,v,graficos.get("trasera"));
        pan.situa(1+2*ch,v,graficos.get("trasera"));
        pan.situa(hor-1-(3*ch),ver-cv-2,mano[0].toString(),mano[0].getPalo());
        pan.situa(hor+1-(3*ch),ver-2,"↑1↑",'n');
        pan.situa(hor-1-(2*ch),ver-cv-2,mano[1].toString(),mano[1].getPalo());
        pan.situa(hor+1-(2*ch),ver-2,"↑2↑",'n');
        pan.situa(hor-1-(1*ch),ver-cv-2,mano[2].toString(),mano[2].getPalo());
        pan.situa(hor+1-(1*ch),ver-2,"↑3↑",'n');
        pan.mostra();
        for (int i = 0; i < hor-(2*ch)+2; i++) {
            System.out.print(" ");
        }
        sc.nextLine();
        
        

    }

    private static void Barajar(List<Carta> baraja) {
        Collections.shuffle(baraja);
    }
    private static Carta repartirCarta(List<Carta> baraja) {
        return baraja.remove(0);
    }

    private static void getValors(List<Carta> baraja,Map<String, String> graficos) throws FileNotFoundException {
        Scanner fi = new Scanner(new File("./cartas/cartas.txt"));
        String trasera="",traserah="",titulo="",hueco="";
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
                String ascii="";
                for (int i = 0; i < 6; i++) ascii+=fi.nextLine()+"\n";
                Carta c= new Carta(palo, is[0], is[1], ascii);
                System.out.println(c);
                System.out.println("Puntos "+c.getPuntos()+" valor "+c.getValor());
                sc.nextLine();
                baraja.add(c);

            }
        }
        for (int i = 0; i < 6; i++) trasera+=fi.nextLine()+"\n";
        for (int i = 0; i < 6; i++) hueco+=fi.nextLine()+"\n";
        traserah=fi.nextLine()+"\n"+fi.nextLine()+"\n"+fi.nextLine();
        titulo  =fi.nextLine()+"\n"+fi.nextLine()+"\n"+fi.nextLine();
        graficos.put("titulo",titulo);
        graficos.put("trasera",trasera);
        graficos.put("traserah",traserah);
        graficos.put("hueco",hueco);
        fi.close();
    }
}

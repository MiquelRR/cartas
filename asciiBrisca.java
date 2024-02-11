import java.util.Scanner;

import cartas.*;

public class asciiBrisca {
    public static void main(String[] args) throws InterruptedException {
        final int pausa = 300;
        final int hor = 70, ver = 24, ch = 7, cv = 6;
        Pantalla pan = new Pantalla(hor, ver);
        Carta[] centro = { Baraja.getNoCarta(), Baraja.getNoCarta() };
        Scanner sc = new Scanner(System.in);
        // creamos la baraja, mezclada por el msmo metodo
        Baraja baraja = new Baraja();
        // la ultima carta define el palo del triunfo
        Carta ultima= baraja.ultimaCarta();
        char triunfo = ultima.getPalo();
        JuegoBrisca Brisca = new JuegoBrisca(triunfo);
        Jugador robot = new Jugador(3);
        Jugador humano = new Jugador(3);
        muestraTapete(pan, ultima, triunfo, baraja, robot, humano); // muestra tapete en vacio
        boolean salehumano = true;
        // reparte las cartas iniciales
        for (int i = 0; i < 3; i++) {
            robot.recibeCarta(baraja.repartirCarta());
            humano.recibeCarta(baraja.repartirCarta());
            baraja.graficos.get(" ");
            muestraTapete(pan, ultima, triunfo, baraja, robot, humano);
            Thread.sleep(pausa);
        }
    }

    private static void muestraTapete(Pantalla pan, Carta ultima, char triunfo, Baraja baraja,
    Jugador robot, Jugador humano) {
        final int ch = 7, cv = 6;
        int hor=pan.getHor(), ver = pan.getVer();
        int v = 5;
        pan.situa(hor - 1 - (1 * ch), v, ultima.toString(), triunfo);
        // pan.situa(hor+2-(1*ch),v+1,graficos.get("trasera"),'w');
        pan.situa(hor - (1 * ch) - 3, v + 4, baraja.graficos.get("traserah"), 'w');
        pan.marc();
        pan.marc(0, 0, hor - 7 - 1, v, 'l', 'n');
        pan.marc(0, 0, hor - 14 - 2, v, 'l', 'n');
        pan.situa(hor - 7 - 1, 1, "PERSONA", 'w');
        String stp = Integer.toString(humano.getPuntos());
        pan.situa(hor - 7 - 1 + ((7 - stp.length()) / 2), 3, stp, 'w');
        stp = Integer.toString(robot.getPuntos());
        pan.situa(hor - 14 - 2, 1, "MÁQUINA", 'w');
        pan.situa(hor - 14 - 2 + ((7 - stp.length()) / 2), 3, stp, 'w');
        pan.marc(0, 0, hor, v, 'd', 'l');
        pan.situa(2, 1, baraja.graficos.get("titulo"), 'w');
        pan.situa(1, v, baraja.graficos.get("trasera"), 'w');
        pan.situa(1 + ch, v, baraja.graficos.get("trasera"));
        pan.situa(1 + 2 * ch, v, baraja.graficos.get("trasera"));
        pan.situa(hor - 1 - (3 * ch), ver - cv - 2, humano.mano[0].toString(), humano.mano[0].getPalo());
        pan.situa(hor + 1 - (3 * ch), ver - 2, "↑1↑", 'n');
        pan.situa(hor - 1 - (2 * ch), ver - cv - 2, humano.mano[1].toString(), humano.mano[1].getPalo());
        pan.situa(hor + 1 - (2 * ch), ver - 2, "↑2↑", 'n');
        pan.situa(hor - 1 - (1 * ch), ver - cv - 2, humano.mano[2].toString(), humano.mano[2].getPalo());
        pan.situa(hor + 1 - (1 * ch), ver - 2, "↑3↑", 'n');
        pan.mostra();

    }

}

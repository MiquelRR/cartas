package cartas;

public class Carta {

    @Override
    public String toString() {
        return ascii;
    }

    public char getPalo() {
        return palo;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getValor() {
        return valor;
    }

    char palo;
    int puntos;
    int valor;
    String ascii;

    public Carta(char palo, int puntos, int valor, String ascii) {
        this.palo = palo;
        this.puntos = puntos;
        this.valor = valor;
        this.ascii = ascii;
    }
}

package cartas;

public class JuegoBrisca extends JuegoDeCartas{

    private final char triunfo;
    private char palo='n';

    public void setPalo(char palo) {
        this.palo = palo;
    }

    public JuegoBrisca(char triunfo){
        this.triunfo=triunfo;
    }
    
    @Override
    public int ganaMano(Carta carta1, Carta carta2) {
        //devuelve puntos obtenidos +1 para que nunca devuelva cero,
        //en positivo si gana la carta1, negativo carta2
        // como me gustaria devolver dos valores, quien gana y cuanto gana, pero eso en python...
        int baza=carta1.getPuntos()+carta2.getPuntos()+1;
        int p1=(carta1.getPalo()==this.triunfo)?100:0;
        p1+=(carta1.getPalo()==this.palo)?10:0;
        p1+=carta1.getValor();
        int p2=(carta2.getPalo()==triunfo)?100:0;
        p2+=(carta2.getPalo()==palo)?10:0; //si es del palo de carta1
        p2+=carta2.getValor();
        if(p1<p2) baza*=-1;
        return baza;
    }
    
}

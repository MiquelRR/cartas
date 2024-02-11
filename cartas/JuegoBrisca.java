package cartas;

public class JuegoBrisca extends JuegoDeCartas{

    private char triunfo;
    public JuegoBrisca(char triunfo){
        this.triunfo=triunfo;
    }
    @Override
    int ganaMano(Carta carta1, Carta carta2) {
        //la primera carta que se pasa es la de mano
        //devuelve puntos obtenidos,
        //en positivo si gana la carta de mano y en negativo
        int baza=carta1.getPuntos()+carta2.getPuntos();
        int p1=(carta1.getPalo()==triunfo)?100:0;
        p1+=10+carta1.getValor();
        int p2=(carta2.getPalo()==triunfo)?100:0;
        p2+=(carta2.getPalo()==carta1.getPalo())?10:0; //si es del palo de carta1
        p2+=carta2.getValor();
        return (p1>p2)?baza:baza*-1;
    }
    
}

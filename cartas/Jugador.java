package cartas;

//esta clase define una mano de numero fijo de cartas, asignadas a la carta noCarta
public class Jugador {
    private int puntos;
    public Carta[] mano;

    public int getPuntos() {
        return puntos;
    }
    public void suma(int puntos){
            this.puntos+= puntos;
    }

    public Jugador(int ncartas){
        this.puntos=0;
        this.mano= new Carta[ncartas];
        for (int i = 0; i < mano.length; i++) {
           this.mano[i]=Baraja.getNoCarta();
        }
    }
    public boolean conCartas(){
        boolean concartas= false;
        for (int i = 0; i < mano.length; i++) {
            concartas = concartas || mano[i]!= Baraja.getNoCarta();
        }
        return concartas;
    }
    //requisito 
    public boolean recibeCarta(Carta carta){
        int i=0;
        while (i<3) {
            if(mano[i].getValor()==0){
                mano[i]=carta;
                i=4;
            } else i++;          
        }
        return i==4; //si se asigna a un hueco, devuelve true
    }
    //requisito
    public Carta juegaCarta(int pos){
        Carta c=mano[pos];
        mano[pos]=Baraja.getNoCarta();
        return c; //devuelve carta y cubre el hueco
    }
     
}

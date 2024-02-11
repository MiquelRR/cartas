package cartas;

//esta clase define una mano de numero fijo de cartas, asignadas a la carta noCarta
public class Jugador {
    private boolean humano;
    private int puntos;
    
    private Carta[] mano;

    public int getPuntos() {
        return puntos;
    }
    public void suma(int puntos){
            this.puntos+= puntos;
    }

    public Jugador(boolean humano, int ncartas){
        this.humano=humano;
        this.puntos=0;
        this.mano= new Carta[ncartas];
        for (int i = 0; i < mano.length; i++) {
           this.mano[i]=Baraja.getNoCarta();
        }
    }
    
    //requisito 
    public boolean recibeCarta(Carta carta){
        int i=0;
        while (i<3) {
            if(mano[i].getValor()==0){
                mano[1]=carta;
                i=4;
            }            
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

package fciencias.edatos.proyecto01;


public class Jugador{

//un jugador tendra un nombre
public String nombre;

//un jugador tendra una lista de cartas
public DoubleLinkedList<Carta> barajaJugador;

/* BARAJA AUXILIAR */
public  DoubleLinkedList<Carta> barajaJugadorCopia;


public int m;
//para saber si el jugador es un humano o una computadora
public boolean computadora;

//metodo constructor
public Jugador(boolean t){
	this.nombre=nombre;
<<<<<<< HEAD
	barajaJugador= new DoubleLinkedList<Carta>();
	this.computadora=t;
	this.m=m;
}

public Jugador(){ //SOBREESCRITURA DEL METODO CONSTRUCTOR

}

=======
	barajaJugador=new DoubleLinkedList<Carta>();
	this.computadora=t;
	this.m=m;
}
//metodo constructor
public Jugador(DoubleLinkedList<Carta> barajaJugador){
	this.nombre=nombre;
	this.barajaJugador=barajaJugador;
	this.computadora=computadora;
	this.m=m;
}
//para saber si es una computadora
>>>>>>> 76b378550c0aa6e55819bd64a595d9861a6150af
public boolean isComputadora(){
	return computadora;
}
//regresa el nombre del jugador
public String nombre(){
	return nombre;
}

public int getNumero(){
	return m;
}
//obtener la lista de cartas del jugador
public DoubleLinkedList<Carta> getLista(){
	return barajaJugador;
}
<<<<<<< HEAD


/**
 * Guarda en la lista BarajaJugadorCopia la baraja inicial de cada jugador
 * @param Un jugador creado
 * @return La baraja inicial
 */
public  DoubleLinkedList<Carta> barajaCopia(Jugador jugador){
	
	
	barajaJugadorCopia = jugador.getLista();

	return barajaJugadorCopia;

	

}


public int getSize(DoubleLinkedList<Carta> barajaJugador){
=======
//obtener el tamaño de la lista
public int getSize(){
>>>>>>> 76b378550c0aa6e55819bd64a595d9861a6150af
	return barajaJugador.size();
}

//quita un par de la lista de carta
public void quitaPar(DoubleLinkedList<Carta> barajaJugador){
	Carta carta1= new Carta();
	Carta carta2=new Carta();
	boolean par= false;

	for(int i=0; i<barajaJugador.size(); i++){
		carta1=barajaJugador.get(i);
		for(int j=i+1; j<barajaJugador.size(); j++){
			carta2=barajaJugador.get(j);
			//por lo que vi, no tienen que ser exactamente igual las cartas, solo su tipo y rango
			//para considerarlas iguales 
			if(carta1.tipo().equals(carta2.tipo()) && carta1.rango().equals(carta2.rango())){
				barajaJugador.elimina(carta1);
				barajaJugador.elimina(carta2);
				par=true;
			}else{
				par=false;
				
			}
			
		}

	}
	
}

public boolean quitaPar2(DoubleLinkedList<Carta> barajaJugador){
	Carta carta1= new Carta();
	Carta carta2=new Carta();
	boolean par= false;

	for(int i=0; i<barajaJugador.size(); i++){
		carta1=barajaJugador.get(i);
		for(int j=i+1; j<barajaJugador.size(); j++){
			carta2=barajaJugador.get(j);
			//por lo que vi, no tienen que ser exactamente igual las cartas, solo su tipo y rango
			//para considerarlas iguales 
			if(carta1.tipo().equals(carta2.tipo()) && carta1.rango().equals(carta2.rango())){
				barajaJugador.remove(i);
				barajaJugador.remove(j);
				par=true;
			}else{
				par=false;
				break;
			}
			
		}

	}
	return par;
	
}
//agrega una carta a la lista de cartas
public void agrega(Carta carta){
	barajaJugador.add(0,carta);
}
<<<<<<< HEAD


=======
//elimina una carta de la lista del jugador 
>>>>>>> 76b378550c0aa6e55819bd64a595d9861a6150af
public void remove(Carta carta){
	barajaJugador.elimina(carta);
}


}
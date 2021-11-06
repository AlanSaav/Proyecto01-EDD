package fciencias.edatos.proyecto01;
import java.util.Random;
import fciencias.edatos.proyecto01.Jugador;
import java.util.Scanner;

public class Juego{
//la baraja de cartas con la que se juega//
public Baraja mazo;
//jugadores que permanecen en el juego//
public DoubleLinkedList<Jugador> jugadores;
//jugadores que ganan//
public DoubleLinkedList<Jugador> jugadoresGanadores;

public Jugador jugador;

public Carta cartaAux;
//la lista de cartas del jugador
public DoubleLinkedList<Carta> pila;

public int i;

//dira si el juego acabo o no//
public boolean partida;

/**metodo constructor
 */
public Juego(){
mazo= new Baraja();
jugadores=new DoubleLinkedList<Jugador>();
pila=new DoubleLinkedList<Carta>();

this.cartaAux=cartaAux;
jugadoresGanadores=new DoubleLinkedList<Jugador>();
this.i=i;
jugador=new Jugador(pila);

}
/**nos dice si el juego termina 
*el juego termina si solo hay un jugador
*/
public boolean termino(){
	if(jugadores.size()==1)
		partida=true;
	else{
		partida=false;
	}	
	return partida;
}

/**nos permite saber si en la partida hay 
* ganadores, si un jugador gana se sale del juego
*/
public boolean ganador(Jugador jugador){
boolean ganar;

if(jugador.getLista().size()==0){
	ganar=true;
	
	

}else{
	ganar=false;
}
return ganar;
}
/**Quita el par de una baraja del jugador
 */
public void par(Jugador jugador){
	if(!jugador.quitaPar2(jugador.getLista())){
		System.out.println("no hay pares en esta lista");
	}
	jugador.quitaPar(jugador.getLista());
	
}
/**un jugador toma la carta de otro jugador
* @param i la carta a quitar o agregar
*/
public void tomaCarta(int i, Jugador jugador1, Jugador jugador2){

jugador1.agrega(jugador.getLista().get(i));
jugador2.remove(jugador.getLista().get(i));

}
/**Genera jugadores 
 * @param t el valor de es computadora o no
 */ 
public Jugador generaJugador(boolean t){
Jugador nuevo=new Jugador(t);
if(t==true){
	nuevo=new Jugador(true);
}else{
	nuevo=new Jugador(false);
}	
return nuevo;

}
/**le da el turno de un jugador a otro
 * da el turno de jugadores de 2 en 2
*/
public void turno(Jugador jugador1, Jugador jugador2){
Scanner scan = new Scanner(System.in);
int s;
if(jugador1.getLista().size()!=0){
	
	if(!jugador.isComputadora()){
<<<<<<< HEAD
		System.out.println("Escoge una carta del otro juador, del 0 al "+jugador2.getSize(jugador2.getLista())); 
=======
		System.out.println("Escoge una carta del otro juador, del 0 al"+jugador2.getSize()); 
>>>>>>> 76b378550c0aa6e55819bd64a595d9861a6150af
		s=scan.nextInt();

		while(s<0 || s>jugador2.getSize()-1){
			System.out.println("Escoge una carta del otro juador, del 0 al"+jugador2.getSize());
			s=scan.nextInt();
			tomaCarta(s,jugador1,jugador2);
		}
	
		}else{//la computadora//
			Random rn=new Random();
			int random;
			random = rn.nextInt(jugador2.getSize());
			s=random;
			tomaCarta(s, jugador1,jugador2);
		}
	}
}
/**Inicia el juego, da la cantidad de jugadores
 * reparte las cartas entre los jugadores
 * empieza el juego
 */
public void iniciaJuego(){
//decidir si jugar con una maquina o un humano//
System.out.println("Si quieres jugar con la computadora pon true, de lo contrario false");
Scanner scan = new Scanner(System.in);
boolean side = scan.nextBoolean();
generaJugador(side);
mazo=new Baraja();


//decidir cuantos jugadores seran//
System.out.println("¿Cuántos jugadores seran?");
Scanner scen = new Scanner(System.in);
int s=scen.nextInt();
int m=0;
jugadores=new DoubleLinkedList<Jugador>();

//generar la lista con la cantidad de jugadores pedidos//
	while(m<s){
	generaJugador(side);
	jugadores.agregaFinal(generaJugador(side));
	m++;
	}

//repartir la cantidad de cartas entre la cantidad de jugadores
Random rn=new Random();
int random;
random = rn.nextInt(51);
int k=51/s;
	while(!mazo.getBaraja().isEmpty()){
	random = rn.nextInt(51);
	for(int x=0; x<jugadores.size(); x++){
	while(jugadores.get(x).getLista().size() < k){	
	
	if(!mazo.getBaraja().get(random).equals(mazo.getBaraja().get(random))){
	
	jugadores.get(x).agrega(mazo.getBaraja().get(random));
	mazo.getBaraja().elimina(mazo.getBaraja().get(random));
		}
	}
	}
}


//inicializar el juego//
while(!termino()){
	for(int i=jugadores.size()-1; i>=0; i--){
			System.out.println("sigue el juego, turno nuevo");
			System.out.println("Hay " +jugadores.size()+ " jugadores");
			
			if(!ganador(jugadores.get(i))){
				jugadores.elimina(jugadores.get(i));
			}
			if(i!=0){
			turno(jugadores.get(i),jugadores.get(i-1));
			par(jugadores.get(i));
		
			}
			if(termino()){
			System.out.println("el jugador "+jugadores.get(0)+" perdio");
			break;
		}
		}
	}


}


	/**
	 * Metodo que da la opcion de dar el historial de los movimientos
	 */
	public void historial(){

		/* Colocar try catch */

		//Variables
		String respuesta;
		Scanner scan = new Scanner(System.in);
		Jugador jg = new Jugador();





		System.out.println("¿Mostrar historial de partida?: Colocar s/n");
		respuesta = scan.nextLine();

		if(respuesta.equals("s")){
			System.out.println("Cartas iniciales del jugador  + jugador + " + " : " + jg.barajaJugador);

			System.out.println("Cartas robadas por el jugador + jugador + : + cartasrobadas");

			System.out.println("Pares realizados: + pares");

			System.out.println("Los jugadores que lograron quedarse sin cartas: ");
			getJugadoresG(jugadoresGanadores);


		}



	}

	
	/**
	 * Recorre la lista de jugadores ganadores y los imprime
	 * @param jugador
	 */
	public void getJugadoresG(DoubleLinkedList<Jugador>jugador){
	

			for(int g = 0; g <  jugador.size() ; g++){
			
			System.out.println(jugador.get(g));
			}

	}













}